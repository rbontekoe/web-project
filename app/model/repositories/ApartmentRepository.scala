package model.repositories

import model.domain.RoomId
import model.domain.Apartment

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