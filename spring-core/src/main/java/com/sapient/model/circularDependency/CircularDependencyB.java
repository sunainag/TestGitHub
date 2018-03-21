package com.sapient.model.circularDependency;

import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

	CircularDependencyA a;
	
	private String message = "Hi!";
	
	public String getMessage() {
        return message;
    }

	public void setA(CircularDependencyA a) {
		this.a = a;
	}
}
