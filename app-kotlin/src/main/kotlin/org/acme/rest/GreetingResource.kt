package org.acme.rest

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource {

    @Inject
    lateinit var greetingConfig: GreetingConfig

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = greetingConfig.message()
}
