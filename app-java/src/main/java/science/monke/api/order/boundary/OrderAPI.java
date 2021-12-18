package science.monke.api.order.boundary;

import io.smallrye.mutiny.Uni;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import science.monke.api.order.control.OrderService;
import science.monke.api.order.entity.NewOrderDTO;
import science.monke.api.order.entity.OrderDTO;

@Tag(name = "Orders")
@Path("/orders")
public class OrderAPI {

  @Inject
  OrderService orderService;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiResponse(responseCode = "200",
      content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDTO.class))))

  public Uni<List<OrderDTO>> getOrders() {
    return Uni.createFrom()
        .item(List.of(OrderDTO.builder()
            .orderId(UUID.randomUUID())
            .build(), OrderDTO.builder()
            .orderId(UUID.randomUUID())
            .build()));
  }

  @GET
  @Path("/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = OrderDTO.class)))
  public Uni<OrderDTO> getOrder(@PathParam(value = "orderId") final int orderId) {
    return Uni.createFrom()
        .item(OrderDTO.builder()
            .orderId(UUID.randomUUID())
            .build());
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = OrderDTO.class)))
  public Uni<Response> postOrder(final NewOrderDTO newOrder) {
    return Uni.createFrom()
        .item(Response.ok()
            .build());
  }
}

