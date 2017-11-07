package model.test

import model.api.RoomStatus
import model.domain.RoomState
import model.domain.SensorId
import model.infrastructure.ObjectRecognationAdapter
import model.infrastructure.SensorRepositoryAdapter

object Test2 extends App {
  println("RoomStatus\n==========")

  // functional test alert
  val testApp = new RoomStatus(new SensorRepositoryAdapter, new ObjectRecognationAdapter)
  val room: RoomState = testApp.processSensorData(new SensorId(10100), null)
  println(room)
}