package com.kevin.activemq.test.spring.simple;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Sender {

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:application-spring-jms.xml");
		
		JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
		jmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session sesssion) throws JMSException {
				TextMessage msg = sesssion.createTextMessage();
				msg.setText("hello spring jms ");
				return msg;
			}
		});
	}
}
