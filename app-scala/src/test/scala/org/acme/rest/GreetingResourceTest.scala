package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    def testHelloEndpoint() = {
        given()
          .`when`().get("/greeting")
          .then()
             .statusCode(200)
             .body(`is`("Hello Scala RESTEasy"))
    }

}
