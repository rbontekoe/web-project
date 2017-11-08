
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
        <div><h3>==== Room info ===</h3></div
        <div>Detected person: """),_display_(/*20.32*/roomInfo/*20.40*/.name),format.raw/*20.45*/("""</div>
        <div>Apartment: """),_display_(/*21.26*/roomInfo/*21.34*/.apartmentNbr),format.raw/*21.47*/("""</div>
        <div>Owner: """),_display_(/*22.22*/roomInfo/*22.30*/.habitant),format.raw/*22.39*/("""</div>
        <div>Room: """),_display_(/*23.21*/roomInfo/*23.29*/.roomNumber),format.raw/*23.40*/(""" """),format.raw/*23.41*/("""- """),_display_(/*23.44*/roomInfo/*23.52*/.roomType),format.raw/*23.61*/("""</div>
        <div>Room status: """),_display_(/*24.28*/roomInfo/*24.36*/.status),format.raw/*24.43*/("""</div>
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
                  DATE: Tue Nov 07 22:02:48 CET 2017
                  SOURCE: C:/workspace/web/web-project/app/views/index.scala.html
                  HASH: d2818e9f5959fb97f63b74cbfe84b677e4673e3b
                  MATRIX: 782->1|985->108|1013->110|1182->253|1196->259|1255->298|1369->385|1385->392|1414->400|1477->436|1493->443|1521->450|1583->485|1603->496|1636->508|1707->552|1727->563|1757->572|1816->604|1836->615|1866->624|1935->666|1964->674|2077->760|2094->768|2120->773|2180->806|2197->814|2231->827|2287->856|2304->864|2334->873|2389->901|2406->909|2438->920|2467->921|2497->924|2514->932|2544->941|2606->976|2623->984|2651->991
                  LINES: 21->1|26->1|27->2|32->7|32->7|32->7|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|43->18|43->18|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|48->23|48->23|48->23|48->23|49->24|49->24|49->24
                  -- GENERATED --
              */
          