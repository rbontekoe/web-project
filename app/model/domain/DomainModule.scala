package model.domain

trait ObjectRecognationApi {
  def analyseImage(image: SensorImage): List[Person]
}

trait SensorRepositoryApi {
  def findRoomNbr(sensorId: Int): Int
}

case class SensorId(value: Int) extends AnyVal
case class RoomId(value: Int) extends AnyVal
case class PersonId(value: Int) extends AnyVal
case class ApartmentId(value: Int) extends AnyVal
case class PersonName(value: String) extends AnyVal

case class Person(personId: PersonId, name: PersonName)
case class SensorImage(sensorId: SensorId, image: Array[Byte])

trait RoomType
object RoomType {
  case object Kitchen extends RoomType
  case object Bathroom extends RoomType
  case object Bedroom extends RoomType
  case object Livingroom extends RoomType
  case object Balcony extends RoomType
}

case class Room(roomId: RoomId, roomType: RoomType)
case class Apartment(apartmentId: ApartmentId, person: Person, rooms: List[Room])

trait AlarmType
object AlarmType {
  case object Info extends AlarmType
  case object Warning extends AlarmType
  case object Severe extends AlarmType
  case object Error extends AlarmType
}

trait RoomState
case class EmptyRoom(roomId: RoomId) extends RoomState
case class NonEmptyRoom(roomId: RoomId, sensorImage: SensorImage, alarmType: AlarmType, persons: List[Person]) extends RoomState
