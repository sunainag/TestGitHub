package com.sapient.model.circularDependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
	
	@Autowired
	CircularDependencyB b;
	 
	@PostConstruct
	public void init() {
		b.setA(this);
	}
	
	public CircularDependencyB getB() {
		return b;
	}

}
