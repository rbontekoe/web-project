package model.test

import main.scala.infrastructure.SensorRepositoryAdapter
import main.scala.infrastructure.ObjectRecognationAdapter
import main.scala.domain.Room
import main.scala.api.RoomStatus
import main.scala.domain.SensorId

object Test2 extends App {
  println("RoomStatus\n==========")

  // functional test alert
  val testApp = new RoomStatus(new SensorRepositoryAdapter, new ObjectRecognationAdapter)
  val room: Room = testApp.processSensorData(new SensorId(10100), null)
  println(room)
}