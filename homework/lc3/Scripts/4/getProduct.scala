
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:7777")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0")





	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
		.exec(addCookie(Cookie("token", "f77dd696-bb5e-4f64-96d0-e51d40f20905")))
			.get("/api/products/get_product/5c76cf471f74af0956e761d4"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}