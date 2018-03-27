package com.sapient.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Asset {

	private String name;
	
	private String description;
	
	public Asset() {
		// TODO Auto-generated constructor stub
	}
	
	public Asset(String name, String desc) {
		this.name=name;
		this.description=desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
