
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>API Aggregation demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" />
  </head>

  <body>
    <button style="background: #FF4444; color: white; padding: 10px" onclick="fire()">GET THE POKEMUNS</button>
    <code style="display: block; margin-top: 40px"></code>
  </body>

  <script>
    function fire() """),format.raw/*18.21*/("""{"""),format.raw/*18.22*/("""
      """),format.raw/*19.7*/("""const body = `
        next
        results
          url
            weight
            forms
              url
                sprites
        lol
          pouet
      `

      fetch(`api/aggregation/$"""),format.raw/*31.31*/("""{"""),format.raw/*31.32*/("""encodeURIComponent('http://pokeapi.co/api/v2/pokemon')"""),format.raw/*31.86*/("""}"""),format.raw/*31.87*/("""`, """),format.raw/*31.90*/("""{"""),format.raw/*31.91*/("""
        """),format.raw/*32.9*/("""method: 'POST',
        //headers: """),format.raw/*33.20*/("""{"""),format.raw/*33.21*/(""" """),format.raw/*33.22*/("""'Content-Type': 'application/json' """),format.raw/*33.57*/("""}"""),format.raw/*33.58*/(""",
        //body: JSON.stringify(body)
        body
      """),format.raw/*36.7*/("""}"""),format.raw/*36.8*/(""")
      .then(res => res.json())
      .then(json => document.querySelector('code').textContent = json)
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/("""
  """),format.raw/*40.3*/("""</script>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Aug 15 12:27:37 CEST 2017
                  SOURCE: /Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/app/views/index.scala.html
                  HASH: acac3c83926154d8436ecd245c234d97bfc65e9f
                  MATRIX: 722->1|818->3|846->5|1377->508|1406->509|1440->516|1672->720|1701->721|1783->775|1812->776|1843->779|1872->780|1908->789|1971->824|2000->825|2029->826|2092->861|2121->862|2206->920|2234->921|2369->1029|2397->1030|2427->1033
                  LINES: 21->1|26->1|28->3|43->18|43->18|44->19|56->31|56->31|56->31|56->31|56->31|56->31|57->32|58->33|58->33|58->33|58->33|58->33|61->36|61->36|64->39|64->39|65->40
                  -- GENERATED --
              */
          