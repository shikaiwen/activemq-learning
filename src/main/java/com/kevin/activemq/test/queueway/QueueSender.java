package com.kevin.activemq.test.queueway;


import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {

	public static final String BROKER_URL = "tcp://localhost:61616";
	public static final String DESTINATION = "info.test.queue";
	
	public static void main(String[] args) {
		run();
	}
	
	
	public static void send(QueueSession session,javax.jms.QueueSender sender) throws JMSException{
		
		for(int i = 0;i< 1;i++){
			String msg = "msg " + i;
			MapMessage map = session.createMapMessage();
			map.setString("text", msg);
			map.setLong("time", System.currentTimeMillis());
			sender.send(map);
			
		}
	}
	
	public static void run() {
		
		QueueConnection queueConnection = null;
		QueueSession queueSession = null;
		try{
			QueueConnectionFactory factory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD,
					BROKER_URL);
			queueConnection = factory.createQueueConnection();
			queueConnection.start();
			queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = queueSession.createQueue(DESTINATION);
			
			javax.jms.QueueSender queueSender = queueSession.createSender(queue);
			
			queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			send(queueSession,queueSender);
			queueSession.commit();
		}catch(JMSException e){
			e.printStackTrace();
		}finally{
			try{
				if(queueConnection != null) queueConnection.close();
				if(queueSession != null) queueSession.close();
			}catch(JMSException e){}
		}
		
		
		
	}
}
