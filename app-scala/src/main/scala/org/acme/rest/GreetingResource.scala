package org.acme.rest

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

@Path("/greeting")
class GreetingResource {

  @Inject
  var greetingConfig: GreetingConfig = _

  @GET
  @Produces(Array[String](MediaType.TEXT_PLAIN))
  def hello(): String = greetingConfig.message
}
