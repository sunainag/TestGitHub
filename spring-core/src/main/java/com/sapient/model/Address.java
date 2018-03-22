package com.sapient.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Address implements BeanNameAware, ApplicationContextAware{

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

	@Override
	public void setBeanName(String beanName) {
		System.out.println("BeanNameAware Interface");
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("ApplicationContextAware interface");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct of Address");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("@PreDestroy of Address");
	}
	
}
