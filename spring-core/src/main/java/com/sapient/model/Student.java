package com.sapient.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Student implements InitializingBean, DisposableBean{

	private int age;
	private String name;
	
	@Autowired
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
	
	@PostConstruct
	public void init(){
		System.out.println("In @PostConstruct init of Student method: "+address.getAddress());
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
