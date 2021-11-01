package science.monke;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

  @Inject
  GreetingConfig greetingConfig;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return greetingConfig.message();
  }
}