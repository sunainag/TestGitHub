package com.sapient.model.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

	CircularDependencyA a;
	
	private String message = "Hi!";
	
	public CircularDependencyB() {
	}
	
	public CircularDependencyB(CircularDependencyA a) {
		this.a=a;
	}
	
	public String getMessage() {
        return message;
    }

	public CircularDependencyA getA() {
		return a;
	}

	@Autowired
	public void setA(CircularDependencyA a) {
		this.a = a;
	}
}
