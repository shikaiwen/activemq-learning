package com.kevin.activemq.test.spring.integrate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Receiver implements MessageListener{

	public void onMessage(Message message) {
		
		if(message instanceof TextMessage){
			TextMessage msg = (TextMessage)message;
			try {
				System.out.println(msg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
