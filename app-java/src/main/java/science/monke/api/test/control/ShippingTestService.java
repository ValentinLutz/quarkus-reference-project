package science.monke.api.test.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import science.monke.mq.shipping.boundary.ShippingPublisherSNS;

@ApplicationScoped
public class ShippingTestService {

  @Inject
  ShippingPublisherSNS shippingPublisherSNS;

  public void publish(final String message) {
    shippingPublisherSNS.publish(null, message);
  }

}
