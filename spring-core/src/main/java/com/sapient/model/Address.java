package com.sapient.model;

public class Address {

	private String address;
	private int pinCode;
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
	
	public String toString(){
		return this.getAddress()+", "+this.getPinCode();
	}
}
