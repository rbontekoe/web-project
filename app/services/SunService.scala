package services

import play.api.libs.ws.WSClient
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId

class SunService(wsClient: WSClient) {
  def getSunInfo(lat: Double, lon: Double): Future[SunInfo] = {
    val url: String = "http://api.sunrise-sunset.org/json?" + "lat=" + lat + "&lng=" + lon + "&formatted=0"

    val responseF = wsClient.url(url).get()
    responseF.map { response =>
      val json = response.json
      val sunriseTimeStr = (json \ "results" \ "sunrise").as[String]
      val sunsetTimeStr = (json \ "results" \ "sunset").as[String]
      val sunriseTime = ZonedDateTime.parse(sunriseTimeStr)
      val sunsetTime = ZonedDateTime.parse(sunsetTimeStr)

      val formatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Europe/Amsterdam"))
      val sunInfo = SunInfo(sunriseTime.format(formatter), sunsetTime.format(formatter))
      sunInfo
    }
  }
}

case class SunInfo(sunrise: String, sunset: String)