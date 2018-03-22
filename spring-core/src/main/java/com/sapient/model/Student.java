package com.sapient.model;

public class Student {

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
	
}
