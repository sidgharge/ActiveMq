package com.bridgelabz;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String msg) {
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(msg);
				
				return message;
			}
		});
	}
}
