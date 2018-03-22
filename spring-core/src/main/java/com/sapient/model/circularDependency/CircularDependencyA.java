package com.sapient.model.circularDependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {

	@Autowired
	private CircularDependencyB b;
	private ApplicationContext context;

	public CircularDependencyA() {
		System.out.println("A's constructor");
	}
	
	public CircularDependencyB getB() {
		return b;
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;
	}

	public void getMessageFromA() {
		System.out.println("I received an object of A");
	}

	@PostConstruct
	public void init() {
		System.out.println("init of A");
		b.setA(this);
	}

}
