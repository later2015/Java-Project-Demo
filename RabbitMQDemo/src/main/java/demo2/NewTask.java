package demo2;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 场景2，单发送多接收,但每个消息只会被其中一个收到。从另外一个角度，可以认为是实现了负载均衡。
 * Created by liqiliang <liqiliang@baibu.la> on 2016/10/12.
 */
public class NewTask {
    private static final String TASK_QUEUE_NAME = "si.test.queue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.85.128");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

        String message = getMessage(argv);
        boolean flag=true;
        int i=0;
        while (flag) {
            i++;
            System.out.println("send Message::::"+i);

            /////////set header part
            Map headers=new HashMap();
            headers.put("id","93958203850");
            headers.put("newid","93958203850");
            headers.put("timestamp","999999999999999999");
            AMQP.BasicProperties b=new AMQP.BasicProperties("a", "UTF-8", headers, 2, 1, "correlationId", "replyTo", null,"messageId", new Date(), "type","guest","appId222", null);
            ///set header part

            channel.basicPublish("", TASK_QUEUE_NAME,
                    b,
                    message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            flag=false;
        }
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1)
            return "Hello World!665555";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
