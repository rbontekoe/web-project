package main.scala.domain

trait ObjectRecognationApi {
  def analyseImage(image: SensorImage): List[Person]
}

trait SensorRepositoryApi {
  def findRoomNbr(sensorId: Int): Int
}

case class SensorId(value: Int) extends AnyVal
case class RoomId(value: Int) extends AnyVal
case class PersonId(value: Int) extends AnyVal

case class Person(personId: PersonId, name: String)
case class SensorImage(sensorId: SensorId, image: Array[Byte])

trait Room
case class EmptyRoom(roomId: RoomId) extends Room
case class NonEmptyRoom(roomId: RoomId, sensorImage: SensorImage, alarmType: AlarmType, persons: List[Person]) extends Room

trait AlarmType
object AlarmType {
  case object Info extends AlarmType
  case object Warning extends AlarmType
  case object Severe extends AlarmType
  case object Error extends AlarmType
}