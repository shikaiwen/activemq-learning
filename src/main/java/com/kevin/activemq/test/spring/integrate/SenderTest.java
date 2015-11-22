package com.kevin.activemq.test.spring.integrate;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:application-spring-jms-integrate-sender.xml"
		})
public class SenderTest {

	@Resource
	private Sender sender;
	
	@Test
//	@Ignore
	public void testSender(){
		
		sender.sendTestMessage();
//		System.out.println("testSender");
	}
	
}
