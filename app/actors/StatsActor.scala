package actors

import akka.actor.Actor
import actors.StatsActor.Ping
import actors.StatsActor.RequestReceived
import actors.StatsActor.GetStats

object StatsActor {
  val name = "StatsActor"
  val path = s"/user/$name"
  
  case object Ping
  case object RequestReceived
  case object GetStats
}

class StatsActor extends Actor {
  var counter = 0
  
  override def receive: Receive = {
    case Ping => ()
    case RequestReceived => counter += 1
    case GetStats => sender() ! counter
  }
}