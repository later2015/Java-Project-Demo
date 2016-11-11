package org.springframework.integration.samples.amqp.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;

public class SubscriberServiceActivator {

	private static Log logger = LogFactory
			.getLog(SubscriberServiceActivator.class);
//处理接收到的消息．ｘｍｌ里已经配置好了使用这个类去监听
	public void logXml_old(Message<?> msg) throws Exception {
		logger.info("correlationId:::::"+msg.getHeaders().get("correlationId"));
		if (msg.getPayload() instanceof byte[]){
			logger.info(" PAYLOAD 11 ###" + new String((byte[])msg.getPayload()));
		}else{
			logger.info(" PAYLOAD 22 ###" + msg.getPayload());
		}
	}
	//处理接收到的消息．ｘｍｌ里已经配置好了使用这个类去监听
	public Message logXml(Message<?> msg) throws Exception {
		System.out.println(msg.getHeaders().get("amqp_consumerQueue"));

		logger.info("correlationId:::::"+msg.getHeaders().get("correlationId"));
		if (msg.getPayload() instanceof byte[]){
			logger.info(" PAYLOAD 11 ###" + new String((byte[])msg.getPayload()));
		}else{
			logger.info(" PAYLOAD 22 ###" + msg.getPayload());
		}

		return msg;
	}
}
