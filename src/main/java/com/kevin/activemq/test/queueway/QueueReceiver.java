package com.kevin.activemq.test.queueway;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueReceiver {

	public static final String BROKER_URL = "tcp://localhost:61616";
	public static final String DESTINATION = "info.test.queue";
	
	public static void main(String[] args) throws Exception{
		run();
	}
	
	public static void run() throws Exception{
		
		QueueConnection queueConnection = null;
		QueueSession queueSession  = null;
		try{
			QueueConnectionFactory factory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD,
					BROKER_URL);
			queueConnection = factory.createQueueConnection();
			queueConnection.start();
			queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = queueSession.createQueue(DESTINATION);
			
			javax.jms.QueueReceiver queueReceiver = queueSession.createReceiver(queue);
			queueReceiver.setMessageListener( new MessageListener(){
				public void onMessage(Message message) {
					if(message != null){
						MapMessage map = (MapMessage)message;
						try {
							
							System.out.println(map.getString("text"));
							System.out.println(map.getLong("time"));
							
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
				}
			});
			Thread.currentThread().sleep(1000 * 3);
			queueSession.commit();	
		}catch(JMSException e){
			throw e;
		}finally{
			if (queueConnection != null)
				queueConnection.close();
			if (queueSession != null)
				queueSession.close();
		}
		
		
		
		
	}
}
