package model.infrastructure

import model.domain.Apartment
import model.domain.ObjectRecognationApi
import model.domain.Person
import model.domain.PersonId
import model.domain.RoomId
import model.domain.SensorImage
import model.domain.SensorRepositoryApi
import model.domain.PersonName
import model.repositories.ApartmentData
import model.repositories.SensorRepository

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
