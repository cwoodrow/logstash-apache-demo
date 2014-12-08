package com.serli.demo

import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.Headers.Names._
import io.gatling.http.Headers.Values._
import scala.concurrent.duration._
import bootstrap._
import assertions._

class GenerateLogstashInput extends Simulation {
	val feeder = csv("pages.csv").random
	
	val httpProtocol = http
		.baseURL("http://localhost")
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
		.connection("keep-alive")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:32.0) Gecko/20100101 Firefox/32.0")

	val scn = scenario("GenerateLogstashInput")
		.feed(feeder)
		.exec(http("Get Page")
			.get("""${page}"""))

	setUp(scn.inject(constantRate(20 usersPerSec) during (30 seconds))).protocols(httpProtocol)
}