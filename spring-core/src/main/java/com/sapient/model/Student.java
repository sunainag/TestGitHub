package com.sapient.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{

	private int age;
	private String name;
	
	private Address address;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address add) {
		this.address=add;
	}
	
	public void printDetails() {
		System.out.println("address:"+this.getAddress().printAddress());
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("In destroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterpropertiesSet method");
	}
	
}
