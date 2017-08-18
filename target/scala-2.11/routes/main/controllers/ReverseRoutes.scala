
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/conf/routes
// @DATE:Tue Aug 15 12:27:37 CEST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:2
  class ReverseApiAggregation(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(mainResourceUrl:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/aggregation/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("mainResourceUrl", mainResourceUrl)))
    }
  
  }

  // @LINE:4
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def index(any:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + implicitly[play.api.mvc.PathBindable[String]].unbind("any", any))
    }
  
  }


}
