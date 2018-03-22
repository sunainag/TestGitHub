package com.sapient.model;

import org.springframework.beans.factory.BeanNameAware;

public class Address implements BeanNameAware{

	private String address;
	private int pinCode;
	
	public Address() {
		System.out.println("Create Address instance");
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		System.out.println("Setting address properties");
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

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Calling Bean Aware Interfaces");
	}
}
