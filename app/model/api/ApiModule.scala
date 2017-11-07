package model.api

import model.domain.AlarmType
import model.domain.EmptyRoom
import model.domain.NonEmptyRoom
import model.domain.ObjectRecognationApi
import model.domain.RoomId
import model.domain.RoomState
import model.domain.SensorId
import model.domain.SensorImage
import model.domain.SensorRepositoryApi
import model.java.TestImage


trait RoomStatusApi {
  def processSensorData(sensorId: SensorId, image: SensorImage): RoomState
}

class RoomStatus(sensor: SensorRepositoryApi, objectRecognation: ObjectRecognationApi) extends RoomStatusApi {
  
  def processSensorData(sensorId: SensorId, image: SensorImage): RoomState = {
    
    val persons = objectRecognation.analyseImage(null)
    val roomNumber = new RoomId(sensor.findRoomNbr(sensorId.value))
    
    // Aanalyse image
    if (compare(image))
      EmptyRoom(roomNumber)
    else {
      NonEmptyRoom(roomNumber, null, AlarmType.Warning, persons)
    }
  }

  private def compare(imageNew: SensorImage): Boolean = {
    val threshold = 0.1
    // save imageNew
    // compare images (Java) - simulation
    val test: Double = (new TestImage).compareImages("http://www.appligate.nl/images/xpages_bullet.jpg")
    test > threshold 
    }
}