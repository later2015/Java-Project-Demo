package org.springframework.integration.samples.amqp.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class interceptorService implements ChannelInterceptor{

	private static Log logger = LogFactory
			.getLog(interceptorService.class);
//处理接收到的消息．ｘｍｌ里已经配置好了使用这个类去监听
	public void logXml(Message<?> msg) throws Exception {
		logger.debug("correlationId:::::"+msg.getHeaders().get("correlationId"));
		if (msg.getPayload() instanceof byte[]){
			logger.info(" PAYLOAD 1 ###" + new String((byte[])msg.getPayload()));
		}else{
			logger.info(" PAYLOAD 2 ###" + msg.getPayload());
		}
	}

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel messageChannel) {
		System.out.println("got it . preSend!");
		return message;
	}

	@Override
	public void postSend(Message<?> message, MessageChannel messageChannel, boolean b) {
		System.out.println("got it . postSend!");
	}

	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel messageChannel, boolean b, Exception e) {
		System.out.println("got it . afterSendCompletion!");
	}

	@Override
	public boolean preReceive(MessageChannel messageChannel) {
		System.out.println("*****got it . preReceive!");
		return false;
	}

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel messageChannel) {
		System.out.println("*****got it . postReceive!");
		return message;
	}

	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel messageChannel, Exception e) {
		System.out.println("*****got it . afterReceiveCompletion!");

	}
}
