package services

import play.api.libs.ws.WSClient
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class WeatherService(wsClient: WSClient) {

  def getWeatherInfo(url: String): Future[WeatherInfo] = {
    val weatherResonseF = wsClient.url(url).get()
    weatherResonseF.map { weatherResponse =>
      val json = weatherResponse.json
      val temperature = (json \ "temperature" \ "value").as[Double]
      val pressure = (json \ "pressure" \ "value").as[Double]
      val humidity = (json \ "humidity" \ "value").as[Double]
      val weatherInfo = WeatherInfo(temperature, pressure, humidity)
      weatherInfo
    }
  }
  
}

case class WeatherInfo(temperature: Double, pressure: Double, humidity: Double)