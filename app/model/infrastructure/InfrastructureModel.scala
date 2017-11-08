package model.infrastructure

import model.domain.Apartment
import model.domain.ObjectRecognationApi
import model.domain.Person
import model.domain.PersonId
import model.domain.RoomId
import model.domain.SensorImage
import model.domain.SensorRepositoryApi
import model.domain.PersonName

/*
 * ObjectRecognationAdapter
 */
trait RestApi {
  def analyse(image: SensorImage): List[Person]
}

class ObjectRecognationAdapter extends ObjectRecognationApi with RestApi {
  def analyseImage(image: SensorImage): List[Person] = analyse(image: SensorImage)
  def analyse(image: SensorImage): List[Person] =
    List(new Person(new PersonId(210), PersonName("Mrs Neeltje")))
  /*
     * For now: test purpose
     * For future projects: Face recognition
     * Also video: Hand gesture recognition, Speech recognition, etc. 
     */
}

/*
 * SensorRepositoryAdapter
 */
trait RoomLookupApi {
  def findRoomNumber(sensorId: Int): Int
}
class SensorRepositoryAdapter extends SensorRepositoryApi with RoomLookupApi {
  def findRoomNbr(sensorId: Int): Int = findRoomNumber(sensorId: Int)
  def findRoomNumber(sensorId: Int): Int = SensorRepository.findRoom(sensorId)
}

/*
 * Sensor repository (+ test data)
 */
trait SensorRepository {
  def findRoom(sensorId: Int): Int
}
object SensorRepository {
  val map = Map(10100 -> 15, 101001 -> 16, 10102 -> 17, 10103 -> 18, 10104 -> 19)

  def findRoom(sensorId: Int): Int =
    map(sensorId)
}

/*
 * Apartment repository
 */
trait ApartmentRepository {
  def findAppartmmentByRoomId(roomId: RoomId): Apartment
}
object ApartmentRepository {
  val myList = ApartmentData.getApartments

  def findAppartmentByRoomId(roomId: RoomId): Apartment = {
    val apps = for {
      apartment <- myList
      room <- apartment.rooms
    } yield {
      if (room.roomId.value == roomId.value) apartment
      else Nil
    }
    apps.filter(_ != Nil)(0).asInstanceOf[Apartment]
  }
}

