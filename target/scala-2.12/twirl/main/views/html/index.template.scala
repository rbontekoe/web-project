
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[services.SunInfo,services.WeatherInfo,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(sunInfo:  services.SunInfo, weatherInfo: services.WeatherInfo, requests: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
        <link rel="shortcut icon" type="image/png"
           href=""""),_display_(/*7.19*/routes/*7.25*/.Assets.versioned("images/favicon.png")),format.raw/*7.64*/("""">
    </head>

    <body>
        <h1>Hello Play</h1>
        <div>Sunrise time: """),_display_(/*12.29*/sunInfo/*12.36*/.sunrise),format.raw/*12.44*/("""</div> 
        <div>Sunset time: """),_display_(/*13.28*/sunInfo/*13.35*/.sunset),format.raw/*13.42*/("""</div>
        <div>Current temperature: """),_display_(/*14.36*/weatherInfo/*14.47*/.temperature),format.raw/*14.59*/("""</div>
        <div>Current pressure: """),_display_(/*15.33*/weatherInfo/*15.44*/.pressure),format.raw/*15.53*/("""</div>
        <div>Current humidity: """),_display_(/*16.33*/weatherInfo/*16.44*/.humidity),format.raw/*16.53*/("""</div>
        <div>Requests: """),_display_(/*17.25*/requests),format.raw/*17.33*/("""</div>
    </body>
</html>
"""))
      }
    }
  }

  def render(sunInfo:services.SunInfo,weatherInfo:services.WeatherInfo,requests:Int): play.twirl.api.HtmlFormat.Appendable = apply(sunInfo,weatherInfo,requests)

  def f:((services.SunInfo,services.WeatherInfo,Int) => play.twirl.api.HtmlFormat.Appendable) = (sunInfo,weatherInfo,requests) => apply(sunInfo,weatherInfo,requests)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 02 11:16:07 CET 2017
                  SOURCE: C:/workspace/web/web-project/app/views/index.scala.html
                  HASH: 0c4c7cf081fbe17817d6a4086f866802cf3413a4
                  MATRIX: 764->1|937->79|965->81|1137->227|1151->233|1210->272|1324->359|1340->366|1369->374|1432->410|1448->417|1476->424|1546->467|1566->478|1599->490|1666->530|1686->541|1716->550|1783->590|1803->601|1833->610|1892->642|1921->650
                  LINES: 21->1|26->1|27->2|32->7|32->7|32->7|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|42->17|42->17
                  -- GENERATED --
              */
          