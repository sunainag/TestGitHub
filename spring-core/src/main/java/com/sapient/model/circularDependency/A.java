package com.sapient.model.circularDependency;

public class A {
	
	B b;
	
	public A(B b) {
		this.b=b;
	}

}
