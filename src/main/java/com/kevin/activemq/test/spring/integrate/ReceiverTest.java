package com.kevin.activemq.test.spring.integrate;

import javax.annotation.Resource;
import javax.jms.MessageListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:application-spring-jms-integrate-receiver.xml"
		})
public class ReceiverTest {

//	@Resource
//	private MessageListener messageListener;
	
	@Test
	public void testReceive(){
		
		try {
			Thread.currentThread().sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
