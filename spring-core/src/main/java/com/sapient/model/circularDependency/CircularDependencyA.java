package com.sapient.model.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
	
	CircularDependencyB b;
	
	public CircularDependencyA() {
	}
	
	public CircularDependencyA(CircularDependencyB b) {
		this.b=b;
	}
	
	public CircularDependencyB getB() {
		return b;
	}

	@Autowired
	public void setB(CircularDependencyB b) {
		this.b = b;
	}

}
