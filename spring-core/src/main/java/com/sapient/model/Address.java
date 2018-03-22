package com.sapient.model;

public class Address{

	private String address;
	private int pinCode;
	
	public Address() {
		System.out.println("Address constructor");
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		System.out.println("setAddress in class Address");
		this.address = address;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public String printAddress() {
		return "Address printed.";
	}

}
