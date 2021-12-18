package science.monke.mq.shipping.boundary;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import science.monke.mq.ListenerSQS;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

@ApplicationScoped
public class ShippingListenerSQS extends ListenerSQS {

  @ConfigProperty(name = "custom.sqs.shipping.queue-url")
  String queueUrl;

  @Override
  @Scheduled(every = "1S", concurrentExecution = Scheduled.ConcurrentExecution.SKIP)
  protected void listen() {
    final ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(
        message -> message.waitTimeSeconds(20)
            .maxNumberOfMessages(10)
            .queueUrl(queueUrl));

    for (final Message message : receiveMessageResponse.messages()) {
      processMessage(message);
    }
  }

  @Override
  protected void processMessage(final Message message) {
    Log.infov("Received message {0} with body {1} and attributes {2}",
        message.messageId(),
        message.body(),
        message.attributesAsStrings());
    deleteMessage(queueUrl, message.receiptHandle());
  }
}
