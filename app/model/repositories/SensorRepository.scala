package model.repositories

/*
 * Sensor repository (+ test data)
 */
trait SensorRepository {
  def findRoom(sensorId: Int): Int
}
object SensorRepository {
  // Maping sensorid's to rooms
  val map = Map(10100 -> 15, 101001 -> 16, 10102 -> 17, 10103 -> 18, 10104 -> 19)

  def findRoom(sensorId: Int): Int =
    map(sensorId)
}