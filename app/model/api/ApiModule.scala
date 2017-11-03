package main.scala.api

import main.scala.domain.AlarmType
import main.scala.domain.EmptyRoom
import main.scala.domain.NonEmptyRoom
import main.scala.domain.ObjectRecognationApi
import main.scala.domain.Room
import main.scala.domain.RoomId
import main.scala.domain.SensorId
import main.scala.domain.SensorImage
import main.scala.domain.SensorRepositoryApi
import model.java.TestImage


trait RoomStatusApi {
  def processSensorData(sensorId: SensorId, image: SensorImage): Room
}

class RoomStatus(sensor: SensorRepositoryApi, objectRecognation: ObjectRecognationApi) extends RoomStatusApi {
  def processSensorData(sensorId: SensorId, image: SensorImage): Room = {
    val persons = objectRecognation.analyseImage(null)
    val roomNumber = new RoomId(sensor.findRoomNbr(sensorId.value))

    if (compare(image))
      EmptyRoom(roomNumber)
    else {
      NonEmptyRoom(roomNumber, null, AlarmType.Warning, persons)
    }
  }

  private def compare(imageNew: SensorImage): Boolean = {
    val threshold = 0.1
    // save imageNew
    // compare images (Java)
    val test: Double = (new TestImage).compareImages("http://www.appligate.nl/images/xpages_bullet.jpg")
    test > threshold 
    }
}