package com.kevin.activemq.test.spring.integrate;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Resource
	private JmsTemplate jmsTemplate;
	
	public void sendTestMessage(){
		
		
		try{
			
			jmsTemplate.send(new MessageCreator(){
				public Message createMessage(Session session) throws JMSException {
					TextMessage ms = session.createTextMessage();
					ms.setText("i am a message");
					return ms;
				}
			});
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	
}
