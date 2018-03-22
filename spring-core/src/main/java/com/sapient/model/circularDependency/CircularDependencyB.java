package com.sapient.model.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

	private CircularDependencyA a;
	private String message = "Hi!";

	public CircularDependencyB() {
		System.out.println("B's constructor");
	}
	
	public void getMessage() {
        System.out.println(message); ;
    }

	//@Autowired
	public void setA(CircularDependencyA a) {
		System.out.println("Set object A in class B");
		a.getMessageFromA();
		this.a = a;
	}
	
}
