package com.kevin.activemq.test.jmsway;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver1 {

	
	public static void main(String[] args) {
//		System.out.println("username:" +ActiveMQConnectionFactory.DEFAULT_USER +",pwd"+
//				ActiveMQConnectionFactory.DEFAULT_PASSWORD);
		MessageReceiver1.run();
	}
	
	public static void run(){
		Connection connection = null;
		Session session = null;
		ConnectionFactory factory = new ActiveMQConnectionFactory("system",
									"manager",
									"tcp://localhost:61616");
//		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
//				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
//				"tcp://localhost:61616");
		try {
			connection = factory.createConnection();
			connection.start();
			//1:transacted 2:acknowledge
			session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
			Destination destination = session.createQueue("info.test1");
			MessageConsumer consumer = session.createConsumer(destination);
			
			while(true){
				Message message = consumer.receive(5 * 1000);
				ObjectMessage objMsg = (ObjectMessage)message;
				Member member = (Member)objMsg.getObject();
				System.out.println("name="+member.getName() +"  age="+member.getAge());
//				TextMessage msg = (TextMessage)message;
//				System.out.println(msg.getText());
				break;
			}
			 session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			try {
				if(session != null )session.close();
				if(connection != null) connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
	}
	}
}
