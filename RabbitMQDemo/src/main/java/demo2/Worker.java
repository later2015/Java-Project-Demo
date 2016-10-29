package demo2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2016/10/12.
 */
public class Worker {
    private static final String TASK_QUEUE_NAME = "si.test.queue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.85.128");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);
        //使用了channel.basicQos(1)保证在接收端一个消息没有处理完时不会接收另一个消息，即接收端发送了ack后才会接收下一个消息。在这种情况下发送端会尝试把消息发送给下一个not busy的接收端。

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
//在使用channel.basicConsume接收消息时使autoAck为false，即不自动会发ack，由channel.basicAck()在消息处理完成后发送消息。
        int i=0;
        while (true) {
            i++;
            System.out.println("get Message:::"+i);
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

//            Map headers= delivery.getProperties().getHeaders();
//            System.out.println("header::"+headers.get("id"));//获取header信息

            String message = new String(delivery.getBody());

            System.out.println(" [x] Received '" + message + "'");
            doWork(message);
            System.out.println(" [x] Done"+delivery.getProperties().getCorrelationId()+delivery.getProperties().getMessageId());//TODO 获取header的内容

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            ;
            //if (ch == '.') Thread.sleep(1000);
        }
    }
}
