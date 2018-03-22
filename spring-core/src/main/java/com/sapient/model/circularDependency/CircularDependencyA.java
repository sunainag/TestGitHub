package com.sapient.model.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {

	private CircularDependencyB b;

	@Autowired
	public CircularDependencyA(@Lazy CircularDependencyB b) {
		System.out.println("A's constructor");
		this.b=b;
	}
	
	public CircularDependencyB getB() {
		return b;
	}

	public void getMessageFromA() {
		System.out.println("I received an object of A");
	}
}
