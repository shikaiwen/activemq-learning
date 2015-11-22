package com.kevin.activemq.test.jmsway;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//博客地址：http://www.cnblogs.com/hoojo/p/active_mq_jms_apache_activeMQ.html

public class MessageSender1 {

	public static void main(String[] args) {
		MessageSender1.run();
	}
	
	private static void sendMessage(Session session, MessageProducer producer){
		
		String message = "发送Message 1";
		TextMessage text = null;
		try {
//			text = session.createTextMessage(message);
			ObjectMessage objMsg = session.createObjectMessage();
			Member member = new Member("kevin",26);
			objMsg.setObject(member);
			producer.send(objMsg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void run()
	{
		Connection connection = null;
		Session session = null;
		//用户名和密码配置在 credential.properties里
		ConnectionFactory factory = new ActiveMQConnectionFactory("system",
				"manager",
				"tcp://localhost:61616");
		
//		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
//				ActiveMQConnection.DEFAULT_PASSWORD,
//				"tcp://localhost:61616");
		
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
			Destination destination = session.createQueue("info.test1");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			sendMessage(session,producer);
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
