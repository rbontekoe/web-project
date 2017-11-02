package services

import akka.stream.Materializer
import play.api.mvc.{ Filter, RequestHeader, Result }
import akka.stream.Materializer
import akka.actor.ActorSystem
import scala.concurrent.Future
import play.Logger
import actors.StatsActor

class StatsFilter(actorSystem: ActorSystem, implicit val mat: Materializer) extends Filter {
  
  override def apply(nextFilter: (RequestHeader) => Future[Result])(header: RequestHeader): Future[Result] = {
    Logger.info(s"Serving another request: ${header.path}")
    
    actorSystem.actorSelection(StatsActor.path) ! StatsActor.RequestReceived
    
    nextFilter(header)
  }
}