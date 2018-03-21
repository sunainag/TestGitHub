package com.sapient.model.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

	private CircularDependencyA a;
	private String message = "Hi!";

	public void getMessage() {
        System.out.println(message); ;
    }

	@Autowired
	public void setA(CircularDependencyA a) {
		System.out.println("B's setter");
		this.a = a;
	}
	
	public void checkCircularDependency() {
		//checks if we have autowired the object of A correctly to this class B in setA(...)
		 a.getMessageFromA();
	}
}
