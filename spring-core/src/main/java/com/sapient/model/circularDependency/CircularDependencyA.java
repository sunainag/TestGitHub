package com.sapient.model.circularDependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA implements ApplicationContextAware,InitializingBean{
	
	private CircularDependencyB b;
	private ApplicationContext context;

	public CircularDependencyB getB() {
		System.out.println("A's getter");
		return b;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("A's afterproperties called");
		b=this.context.getBean(CircularDependencyB.class);
		System.out.println("A's afterproperties ends");
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("A's setApplicationContext called");
		this.context=ctx;
		System.out.println("A's setApplicationContext ends");
	}

	public void getMessageFromA() {
		System.out.println("I received an object of A");;
	}
}
