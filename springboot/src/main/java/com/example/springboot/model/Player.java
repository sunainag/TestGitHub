package com.example.springboot.model;

public class Player {

	String name;
	String position;
	
	
	public Player(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
