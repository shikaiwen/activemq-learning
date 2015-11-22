package com.kevin.activemq.test.spring.simple;

import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Receiver {

	public static void main(String[] args) {
		
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:application-spring-jms.xml");  
        
         
        
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");  
        
        
        
            Object msg = jmsTemplate.receiveAndConvert();  
            
            System.out.println(msg);  
	}
}
