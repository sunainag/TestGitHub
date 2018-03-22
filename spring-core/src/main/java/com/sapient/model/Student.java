package com.sapient.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	private int age;
	private String name;
	@Autowired
	@Qualifier("address2")
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

	public void printDetails() {
		System.out.println("name:"+this.name);
		System.out.println("age:"+this.age);
		System.out.println("address:"+this.getAddress());
	}
	
}
