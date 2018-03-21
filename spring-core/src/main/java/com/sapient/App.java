package com.sapient;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.model.circularDependency.CircularDependencyA;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans.xml");
        CircularDependencyA circA = ctx.getBean(CircularDependencyA.class);
        circA.getB().getMessage();
        ctx.registerShutdownHook();
    }
}
