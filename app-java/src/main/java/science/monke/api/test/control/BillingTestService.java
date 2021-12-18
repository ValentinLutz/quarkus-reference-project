package science.monke.api.test.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import science.monke.mq.billing.boundary.BillingPublisherSNS;

@ApplicationScoped
public class BillingTestService {

  @Inject
  BillingPublisherSNS billingPublisherSNS;

  public void publish(final String message) {
    billingPublisherSNS.publish(null, message);
  }

}
