package com.kevin.activemq.test.jmsway;

import java.io.Serializable;

public class Member implements Serializable{

	private static final long serialVersionUID = -6962502648758017869L;
	private String name;
	private int age;
	
	public Member() {}
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
