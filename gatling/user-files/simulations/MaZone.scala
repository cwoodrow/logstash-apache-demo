
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MaZone extends Simulation {
	val feeder = csv("pages.csv").random

	val httpProtocol = http
		.baseURL("http://localhost/ma-zone/")
		.inferHtmlResources()

	val scn = scenario("MaZone")
		.feed(feeder)
		.exec(http("Get Page")
			.get("""${page}"""))

	setUp(
		scn.inject(
			atOnceUsers(1),
			constantUsersPerSec(10) during(2 minutes)
		)).protocols(httpProtocol)
}
