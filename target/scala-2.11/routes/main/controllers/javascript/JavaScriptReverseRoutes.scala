
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/conf/routes
// @DATE:Tue Aug 15 12:27:37 CEST 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:2
  class ReverseApiAggregation(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiAggregation.index",
      """
        function(mainResourceUrl0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/aggregation/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("mainResourceUrl", mainResourceUrl0))})
        }
      """
    )
  
  }

  // @LINE:4
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function(any0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("any", any0)})
        }
      """
    )
  
  }


}
