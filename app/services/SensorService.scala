package services

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.libs.ws.WSClient
import main.scala.domain.AlarmType

class SensorService(wsClient: WSClient) {

  def getRoomInfo(url: String): Future[RoomInfo] = {
    val roomF = wsClient.url(url).get()
    roomF.map { sensorResponse =>
      
      val roomInfo = RoomInfo("Mevrouw Neeltje de Groot", (AlarmType.Warning).toString(), "112")
      roomInfo
    }
  }

}

case class RoomInfo(name: String, status: String, roomNumber: String)