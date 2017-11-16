
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/web/web-project/conf/routes
// @DATE:Thu Nov 16 15:13:00 CET 2017


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
