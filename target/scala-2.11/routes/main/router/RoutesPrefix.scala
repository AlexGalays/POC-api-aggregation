
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/conf/routes
// @DATE:Tue Aug 15 12:27:37 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
