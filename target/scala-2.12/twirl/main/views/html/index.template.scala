
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[services.SunInfo,services.WeatherInfo,Int,services.RoomInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(sunInfo:  services.SunInfo, weatherInfo: services.WeatherInfo, requests: Int, roomInfo: services.RoomInfo):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.109*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
        <link rel="shortcut icon" type="image/png"
        href=""""),_display_(/*7.16*/routes/*7.22*/.Assets.versioned("images/favicon.png")),format.raw/*7.61*/("""">
    </head>

    <body>
        <h1>Hello Play</h1>
        <div>Sunrise time: """),_display_(/*12.29*/sunInfo/*12.36*/.sunrise),format.raw/*12.44*/("""</div> 
        <div>Sunset time: """),_display_(/*13.28*/sunInfo/*13.35*/.sunset),format.raw/*13.42*/("""</div>
        <div>Temperature: """),_display_(/*14.28*/weatherInfo/*14.39*/.temperature),format.raw/*14.51*/("""</div>
        <div>Atmospheric pressure: """),_display_(/*15.37*/weatherInfo/*15.48*/.pressure),format.raw/*15.57*/("""</div>
        <div>Humidity: """),_display_(/*16.25*/weatherInfo/*16.36*/.humidity),format.raw/*16.45*/("""</div>
        
        <div>Requests: """),_display_(/*18.25*/requests),format.raw/*18.33*/("""</div>
        <div><p>==== Room info ===</p></div
        <div>Name: """),_display_(/*20.21*/roomInfo/*20.29*/.name),format.raw/*20.34*/("""</div>
        <div>Room number: """),_display_(/*21.28*/roomInfo/*21.36*/.roomNumber),format.raw/*21.47*/("""</div>
        <div>Room status: """),_display_(/*22.28*/roomInfo/*22.36*/.status),format.raw/*22.43*/("""</div>
    </body>
</html>
"""))
      }
    }
  }

  def render(sunInfo:services.SunInfo,weatherInfo:services.WeatherInfo,requests:Int,roomInfo:services.RoomInfo): play.twirl.api.HtmlFormat.Appendable = apply(sunInfo,weatherInfo,requests,roomInfo)

  def f:((services.SunInfo,services.WeatherInfo,Int,services.RoomInfo) => play.twirl.api.HtmlFormat.Appendable) = (sunInfo,weatherInfo,requests,roomInfo) => apply(sunInfo,weatherInfo,requests,roomInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Nov 05 12:42:10 CET 2017
                  SOURCE: C:/workspace/web/web-project/app/views/index.scala.html
                  HASH: a474618f2702a1cf9c89e13067b7c747f8221263
                  MATRIX: 782->1|985->108|1013->110|1182->253|1196->259|1255->298|1369->385|1385->392|1414->400|1477->436|1493->443|1521->450|1583->485|1603->496|1636->508|1707->552|1727->563|1757->572|1816->604|1836->615|1866->624|1935->666|1964->674|2064->747|2081->755|2107->760|2169->795|2186->803|2218->814|2280->849|2297->857|2325->864
                  LINES: 21->1|26->1|27->2|32->7|32->7|32->7|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|43->18|43->18|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22
                  -- GENERATED --
              */
          