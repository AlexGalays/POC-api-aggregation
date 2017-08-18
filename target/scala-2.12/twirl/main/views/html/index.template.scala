
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
    <pre><code style="display: block; margin-top: 40px"></code></pre>
  </body>

  <script>
    function fire() """),format.raw/*18.21*/("""{"""),format.raw/*18.22*/("""
      """),format.raw/*19.7*/("""const body = `
        next
        results
          url?lol=lel
            weight
            forms
              url
                sprites
        lol
          pouet
      `

      fetch(`api/aggregation/$"""),format.raw/*31.31*/("""{"""),format.raw/*31.32*/("""encodeURIComponent('http://pokeapi.co/api/v2/pokemon?limit=3')"""),format.raw/*31.94*/("""}"""),format.raw/*31.95*/("""`, """),format.raw/*31.98*/("""{"""),format.raw/*31.99*/("""
        """),format.raw/*32.9*/("""method: 'POST',
        body
      """),format.raw/*34.7*/("""}"""),format.raw/*34.8*/(""")
      .then(res => res.ok
        ? res.json()
        : res.text().then(Promise.reject)
      )
      .then(json => document.querySelector('code').textContent = JSON.stringify(json, null, 2))
      .catch(err => document.querySelector('code').textContent = err)
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""
  """),format.raw/*42.3*/("""</script>
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
                  DATE: Fri Aug 18 08:57:36 CEST 2017
                  SOURCE: /Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/app/views/index.scala.html
                  HASH: 0aad23c459f99f7f27b1734d8832d5bbc2a4bc60
                  MATRIX: 722->1|818->3|846->5|1388->519|1417->520|1451->527|1691->739|1720->740|1810->802|1839->803|1870->806|1899->807|1935->816|1997->851|2025->852|2321->1121|2349->1122|2379->1125
                  LINES: 21->1|26->1|28->3|43->18|43->18|44->19|56->31|56->31|56->31|56->31|56->31|56->31|57->32|59->34|59->34|66->41|66->41|67->42
                  -- GENERATED --
              */
          