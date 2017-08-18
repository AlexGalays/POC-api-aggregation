import play.api.{ApplicationLoader, BuiltInComponentsFromContext, LoggerConfigurator}
import play.api.i18n._
import play.api.routing.Router
import play.api.libs.ws.ahc.AhcWSComponents
import router.Routes


class CustomApplicationLoader extends ApplicationLoader {
  def load(context: ApplicationLoader.Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }
    new CustomComponents(context).application
  }
}

class CustomComponents(context: ApplicationLoader.Context)
  extends BuiltInComponentsFromContext(context)
  with AhcWSComponents {

  val defaultEc = actorSystem.dispatcher

  override lazy val httpFilters = Seq()

  lazy val router: Router = new Routes(httpErrorHandler, apiAggregationController, homeController)

  lazy val homeController = new controllers.Application(controllerComponents)
  lazy val apiAggregationController = new controllers.ApiAggregation(controllerComponents, wsClient)(defaultEc)
}
