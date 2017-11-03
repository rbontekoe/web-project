import com.softwaremill.macwire._

import controllers.Application
import play.api.ApplicationLoader.Context
import play.api._
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.mvc._
import play.api.routing.Router

import _root_.controllers.AssetsComponents
import play.filters.HttpFiltersComponents
import router.Routes
import services.WeatherService
import services.SunService
import scala.concurrent.Future
import akka.actor.Props
import services.StatsFilter
import actors.StatsActor
import actors.StatsActor.Ping
import services.SensorService
import main.scala.infrastructure.SensorRepositoryAdapter
import main.scala.infrastructure.ObjectRecognationAdapter

class AppApplicationLoader extends ApplicationLoader {
  def load(context: Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach { cfg =>
      cfg.configure(context.environment)
    }
    new AppComponents(context).application
  } 
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context)
  with AhcWSComponents
  with AssetsComponents
  with HttpFiltersComponents {
  
  lazy val sunService = wire[SunService]
  lazy val weatherService = wire[WeatherService]
  lazy val sensorService = wire[SensorService]
  lazy val sensorRepositoryAdapter = wire[SensorRepositoryAdapter]
  lazy val objectRecognationAdapter = wire[ObjectRecognationAdapter]
  
  lazy val statsFilter: Filter = wire[StatsFilter]
  override lazy val httpFilters = Seq(statsFilter)
  
  override lazy val controllerComponents = wire[DefaultControllerComponents]
  lazy val prefix: String = "/"
  lazy val router: Router = wire[Routes]
  lazy val applicationController = wire[Application]
  
  applicationLifecycle.addStopHook { () =>
    Logger.info("The app is about to stop")
    Future.successful(Unit)
  }
  
  lazy val statsActor = actorSystem.actorOf(Props(wire[StatsActor]), StatsActor.name)
  
  val onStart = {
    Logger.info("The app is abput to start")
    statsActor ! Ping
  }
}