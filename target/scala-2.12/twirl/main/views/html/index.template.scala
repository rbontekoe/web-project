
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
        <div>Current temperature: """),_display_(/*14.36*/weatherInfo/*14.47*/.temperature),format.raw/*14.59*/("""</div>
        <div>Current pressure: """),_display_(/*15.33*/weatherInfo/*15.44*/.pressure),format.raw/*15.53*/("""</div>
        <div>Current humidity: """),_display_(/*16.33*/weatherInfo/*16.44*/.humidity),format.raw/*16.53*/("""</div>
        
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
                  DATE: Fri Nov 03 11:56:02 CET 2017
                  SOURCE: C:/workspace/web/web-project/app/views/index.scala.html
                  HASH: 46a82f6622f12d4ea0d4ec412382037807119f32
                  MATRIX: 782->1|985->108|1013->110|1182->253|1196->259|1255->298|1369->385|1385->392|1414->400|1477->436|1493->443|1521->450|1591->493|1611->504|1644->516|1711->556|1731->567|1761->576|1828->616|1848->627|1878->636|1947->678|1976->686|2076->759|2093->767|2119->772|2181->807|2198->815|2230->826|2292->861|2309->869|2337->876
                  LINES: 21->1|26->1|27->2|32->7|32->7|32->7|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|43->18|43->18|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22
                  -- GENERATED --
              */
          