package services

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.libs.ws.WSClient
import main.scala.domain.AlarmType
import main.scala.api.RoomStatus
import main.scala.infrastructure.SensorRepositoryAdapter
import main.scala.infrastructure.ObjectRecognationAdapter
import main.scala.domain.SensorId
import main.scala.domain.Room
import main.scala.domain.NonEmptyRoom
import main.scala.domain.EmptyRoom
import main.scala.infrastructure.SensorRepository

class SensorService(wsClient: WSClient) {

  def getRoomInfo(url: String, 
                  sensorRepositoryAdapter: SensorRepositoryAdapter, 
                  objectRecognationAdapter: ObjectRecognationAdapter): Future[RoomInfo] = {
    val roomF = wsClient.url(url).get()
    roomF.map { sensorResponse =>

      val testApp = new RoomStatus(sensorRepositoryAdapter, objectRecognationAdapter)
      val room: Room = testApp.processSensorData(new SensorId(10100), null)
      room match {
        case NonEmptyRoom(roomId, _ , alarmType, persons) => RoomInfo(
          persons.head.name,
          alarmType.toString,
          roomId.value.toString)
        case EmptyRoom(roomId) => RoomInfo("", "", "")
      }
    }
  }

}

case class RoomInfo(name: String, status: String, roomNumber: String)