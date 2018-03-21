package com.sapient.model.circularDependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
public class CircularDependencyA implements ApplicationContextAware,BeanPostProcessor{
	
	private CircularDependencyB b;
	private ApplicationContext context;

	public CircularDependencyB getB() {
		return b;
	}

	/*public void afterPropertiesSet() throws Exception {
		b=this.context.getBean(CircularDependencyB.class);
	}*/

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context=ctx;
	}

	public void getMessageFromA() {
		System.out.println("I received an object of A");;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization of class A");
		return b;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization of class A");
		b = context.getBean(CircularDependencyB.class);
		return b;
	}
}
