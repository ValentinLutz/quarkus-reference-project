package science.monke.api.test.boundary;

import io.swagger.v3.oas.annotations.tags.Tag;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import science.monke.api.test.control.BillingTestService;
import science.monke.api.test.control.ShippingTestService;

@Tag(name = "Test")
@Path("/test")
public class TestAPI {

  @Inject
  BillingTestService billingTestService;

  @Inject
  ShippingTestService shippingTestService;

  @POST
  @Path("/billing")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void postBillingSQS(final String message) {
    billingTestService.publish(message);
  }

  @POST
  @Path("/shipping")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void postShippingSQS(final String message) {
    shippingTestService.publish(message);
  }
}

