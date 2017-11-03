package main.scala.infrastructure

import main.scala.domain.ObjectRecognationApi
import main.scala.domain.PersonId
import main.scala.domain.SensorImage
import main.scala.domain.SensorRepositoryApi
import main.scala.domain.Person

// implementation Adapters
trait RestApi {
  def analyse(image: SensorImage): List[Person]
}

class ObjectRecognationAdapter extends ObjectRecognationApi with RestApi {
  def analyseImage(image: SensorImage): List[Person] =
    analyse(image: SensorImage)
  def analyse(image: SensorImage): List[Person] =
    List(new Person(new PersonId(210), "Mrs Neeltje"))
}

// Sensor repository adapter
trait RoomLookupApi {
  def findRoomNumber(sensorId: Int): Int
}

class SensorRepositoryAdapter extends SensorRepositoryApi with RoomLookupApi {
  def findRoomNbr(sensorId: Int): Int =
    findRoomNumber(sensorId: Int)
  def findRoomNumber(sensorId: Int): Int = SensorRepository.findRoom(sensorId)
}

// Sensor repository
trait SensorRepository {
  def findRoom(sensorId: Int): Int
}

object SensorRepository {
  val map = Map(10100 -> 15)

  def findRoom(sensorId: Int): Int =
    map(sensorId)
}


