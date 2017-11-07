package model.infrastructure

import model.domain.Room
import model.domain.RoomId
import model.domain.Apartment
import services.RoomInfo

object TestApp {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(200); 
  println("Welcome to the Scala worksheet");$skip(72); 

  val apTest = ApartmentRepository.findAppartmentByRoomId(RoomId(19));System.out.println("""apTest  : model.domain.Apartment = """ + $show(apTest ));$skip(74); 

  val test = apTest.rooms.filter(p => p.roomId.value == 19)(0).roomType;System.out.println("""test  : model.domain.RoomType = """ + $show(test ));$skip(15); 
	println(test)}
}
