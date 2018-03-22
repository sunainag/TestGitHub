package com.sapient.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Address {

	private String address;
	private int pinCode;
	
	public Address() {
		System.out.println("In Address constructor");
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
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
