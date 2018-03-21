package com.sapient.model;

public class DemoBean {

	private String message;
	public DemoDependency dummy;

	public DemoBean() {
		System.out.println("In constructor of DemoBean");
	}
	public DemoBean(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public DemoDependency getDummy() {
		return dummy;
	}
	public void setDummy(DemoDependency dummy) {
		System.out.println("Setting dummy bean as dependency of class DemoBean");
		this.dummy = dummy;
	}
	public void show() {
		System.out.println("In Demo Bean");
	}
}
