package science.monke.mq;

import java.util.Map;
import javax.inject.Inject;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.MessageAttributeValue;

public abstract class PublisherSNS {

  @Inject
  protected SnsClient snsClient;

  public abstract void publish(final Map<String, MessageAttributeValue> messageAttributes, final String message);

}
