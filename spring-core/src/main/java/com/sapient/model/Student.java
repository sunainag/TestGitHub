package com.sapient.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

	private int age;
	private String name;
	
	@Autowired
	private Address address;

	public Student() {
		System.out.println("Student constructor");
	}
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
		System.out.println("name:"+this.getName());
	}
	
}
