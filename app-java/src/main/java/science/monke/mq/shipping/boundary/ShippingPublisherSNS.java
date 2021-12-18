package science.monke.mq.shipping.boundary;

import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import science.monke.mq.PublisherSNS;
import software.amazon.awssdk.services.sns.model.MessageAttributeValue;

@ApplicationScoped
public class ShippingPublisherSNS extends PublisherSNS {

  @ConfigProperty(name = "custom.sns.shipping.topic-arn")
  String topicArn;

  @Override
  public void publish(final Map<String, MessageAttributeValue> messageAttributes, final String message) {
    snsClient.publish(publishRequest -> publishRequest.topicArn(topicArn)
        .messageAttributes(messageAttributes)
        .message(message));
  }
  
}
