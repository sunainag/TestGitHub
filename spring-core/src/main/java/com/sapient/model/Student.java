package com.sapient.model;

public class Student {
	
	private Integer age;
	private String name;
	private Address address;
	
	public Student() {
		System.out.println("setter injection requires no-arg constructor");
	}
	
	public Student(Integer age, String name, Address add) {
		System.out.println("In argument constructor of student.");
		this.age=age;
		this.name=name;
		this.address=add;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
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


	public void setAddress(Address address) {
		this.address = address;
	}

	public void printDetails(){
		System.out.println("student name: "+this.getName());
		System.out.println("student age: "+this.getAge());
		System.out.println("student address: "+this.getAddress());
	}
}
