package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import javax.inject._
import play.api._
import play.api.libs.ws.WSClient
import play.api.mvc._
import services.SunService
import services.WeatherService
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import actors.StatsActor
import akka.actor.ActorSystem
import akka.pattern._
import services.SensorService

//class Application @Inject() (components: ControllerComponents, ws: WSClient)
class Application(components: ControllerComponents,
                  sunService: SunService,
                  weatherService: WeatherService,
                  actorSystem: ActorSystem,
                  sensorService: SensorService)
    extends AbstractController(components) {

  def index = Action.async {
    val sunInfoF = sunService.getSunInfo(52.11667, 5.4)
    val weatherInfoF = weatherService.getWeatherInfo("http://raspi3:5000/json")
    val sensorInfoF = sensorService.getRoomInfo("http://raspi3:5000/json")

    implicit val timeout = Timeout(5, TimeUnit.SECONDS)
    val requestsF = (actorSystem.actorSelection(StatsActor.path) ? StatsActor.GetStats).mapTo[Int]

    for {
      sunInfo <- sunInfoF
      weatherInfo <- weatherInfoF
      requests <- requestsF
      roomInfo <- sensorInfoF
    } yield {
      Ok(views.html.index(sunInfo, weatherInfo, requests, roomInfo))
    }
  }
}


