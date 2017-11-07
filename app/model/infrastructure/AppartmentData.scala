package model.infrastructure

import model.domain.Apartment
import model.domain.ApartmentId
import model.domain.Person
import model.domain.PersonId
import model.domain.Room
import model.domain.RoomId
import model.domain.RoomType


object ApartmentData {
  val ap1 = Apartment(
      ApartmentId(1), 
      Person(PersonId(1), "Mrs Neetje"),
      List(
        Room(RoomId(15), RoomType.Livingroom),
        Room(RoomId(16), RoomType.Bathroom),
        Room(RoomId(17), RoomType.Bedroom)
      )
    )
  val ap2 = Apartment(
      ApartmentId(2), 
      Person(PersonId(1), "Mrs Mary"),
      List(
        Room(RoomId(18), RoomType.Livingroom),
        Room(RoomId(19), RoomType.Bathroom),
        Room(RoomId(20), RoomType.Bedroom)
      )
    )
  val ap3 = Apartment(
      ApartmentId(3), 
      Person(PersonId(1), "Mr Harry"),
      List(
        Room(RoomId(21), RoomType.Livingroom),
        Room(RoomId(22), RoomType.Bathroom),
        Room(RoomId(23), RoomType.Bedroom)
      )
    )
    
   def getApartments: List[Apartment] = {
    List(ap1, ap2, ap3)
  }
}

