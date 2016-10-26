package org.springframework.integration.samples.amqp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/integration/spring-integration-context.xml"})
//,"classpath:spring-integration-context-stream.xml"
public class PublisherSubscriberTest {

	@Autowired
	@Qualifier("toRabbit")
	MessageChannel messageChannel;

	@Test
	public void testIntegration() {
		try {
			String request = streamToString(getClass().getResourceAsStream(
					"/data/payload.xml"));

			Message<String> message = MessageBuilder.withPayload(request)
					.build();
			//或者通过GenericMessage 生成msg
//			GenericMessage<String> msg = new GenericMessage<String>(request);
//			messageChannel.send(msg);
			messageChannel.send(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testIntegration2() {
		try {
			//或者通过GenericMessage 生成msg
//			String request="payload testtttttttt";
//			GenericMessage<String> msg = new GenericMessage<String>(request);
//			messageChannel.send(msg);
			while (true) {
				String request = streamToString(getClass().getResourceAsStream("/data/payload.xml"));
				Message<String> message = MessageBuilder.withPayload(request).setCorrelationId("99999999").build();
				messageChannel.send(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String streamToString(InputStream inputStream)
			throws IOException {
		Writer writer = new StringWriter();
		byte[] b = new byte[4096];
		for (int n; (n = inputStream.read(b)) != -1;) {
			writer.append(new String(b, 0, n));
		}
		return writer.toString();
	}
}
