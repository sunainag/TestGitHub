package com.sapient.model;

import java.util.Set;

public class Student {
	
	private Integer age;
	private String name;
	private Set subjects;
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
	public Set getSubjects() {
		subjects.forEach(System.out::println);
		return subjects;
	}
	public void setSubjects(Set subjects) {
		this.subjects = subjects;
	}

}
