package com.bridgelabz;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Producer jmsMessageSender = (Producer) ctx.getBean("jmsMessageSender");

		// send to default destination
		jmsMessageSender.send("hello JMSs");
		jmsMessageSender.send("hello JM");
		// send to a code specified destination
		/*ActiveMQQueue queue = new ActiveMQQueue("AnotherDest");
		jmsMessageSender.send(queue, "hello Another Message");*/

		// close spring application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
