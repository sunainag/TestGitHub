package com.sapient.model;

import java.util.Map;

public class Student {

	private int id;
	private String name;
	private Map<Integer, String> idAddressMap;
	
	private Student(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public void setIdAddressMap(Map<Integer, String> idAddressMap) {
		this.idAddressMap = idAddressMap;
	}

	public void printDetails() {
		System.out.println("name:"+this.name);
		System.out.println("address:"+this.idAddressMap.get(this.id));
	}
	
	public static Student createStudentInstance(int id,String name) {
		return new Student(id, name);
	}
}
