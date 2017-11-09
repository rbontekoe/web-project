package services

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import model.api.RoomStatus
import model.domain.EmptyRoom
import model.domain.NonEmptyRoom
import model.domain.RoomState
import model.domain.SensorId
import model.infrastructure.ObjectRecognationAdapter
import model.infrastructure.SensorRepositoryAdapter
import model.repositories.ApartmentRepository
import play.api.libs.ws.WSClient

class SensorService(wsClient: WSClient) {

  def getRoomInfo(url: String,
                  sensorRepositoryAdapter: SensorRepositoryAdapter,
                  objectRecognationAdapter: ObjectRecognationAdapter): Future[RoomInfo] = {
    val roomF = wsClient.url(url).get()

    roomF.map { sensorResponse =>

      // Gather actual room data
      val roomStatus = new RoomStatus(sensorRepositoryAdapter, objectRecognationAdapter)
      val room: RoomState = roomStatus.processSensorData(new SensorId(101001), null)

      room match {
        case NonEmptyRoom(id, _, alarmType, persons) => {
          val apartment = ApartmentRepository.findAppartmentByRoomId(id)
          val test = apartment.rooms.filter(p => p.roomId.value == id.value)(0)
          RoomInfo(persons.head.name.value, alarmType.toString, id.value.toString, 
              test.roomType.toString, apartment.apartmentId.value.toString(), 
              apartment.person.name.value)
        }
        case EmptyRoom(roomId) =>
          RoomInfo("", "", roomId.value.toString(), "", "", "")
      }
    }
  }
}

case class RoomInfo(name: String, status: String, roomNumber: String, roomType: String, apartmentNbr: String, habitant: String)