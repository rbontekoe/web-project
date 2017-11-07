package model.infrastructure

import model.domain.Room
import model.domain.RoomId
import model.domain.Apartment
import services.RoomInfo

object TestApp {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val apTest = ApartmentRepository.findAppartmentByRoomId(RoomId(19))
                                                  //> apTest  : model.domain.Apartment = Apartment(ApartmentId(2),Person(PersonId(
                                                  //| 1),Mrs Mary),List(Room(RoomId(18),Livingroom), Room(RoomId(19),Bathroom), Ro
                                                  //| om(RoomId(20),Bedroom)))

  val test = apTest.rooms.filter(p => p.roomId.value == 19)(0).roomType
                                                  //> test  : model.domain.RoomType = Bathroom
	println(test)                             //> Bathroom
}