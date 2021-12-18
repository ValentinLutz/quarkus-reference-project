package science.monke.mq;

import javax.inject.Inject;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;

public abstract class ListenerSQS {

  @Inject
  protected SqsClient sqsClient;

  protected abstract void listen();

  protected abstract void processMessage(Message message);

  protected void deleteMessage(final String queueUrl, final String receiptHandle) {
    sqsClient.deleteMessage(DeleteMessageRequest.builder()
        .queueUrl(queueUrl)
        .receiptHandle(receiptHandle)
        .build());
  }

}
