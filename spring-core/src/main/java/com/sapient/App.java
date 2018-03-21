package com.sapient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.model.DemoBean;
import com.sapient.model.DemoDependency;
import com.sapient.model.Student;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Student ob = (Student) ctx.getBean("student");
        ob.printDetails();
        
        DemoBean demo = (DemoBean) ctx.getBean("demo");
        demo.show();
        
        DemoDependency demoDependency = (DemoDependency) ctx.getBean("dummy");
        demoDependency.show();
        
        
        //Checking circular dependency issue:only in case of constructor injection
        
		/*
		 * Detected during context loading, so no need to getBean here:
		 * org.springframework.beans.factory.BeanCurrentlyInCreationException:
		 * Error creating bean with name 'a': Requested bean is currently in
		 * creation: Is there an unresolvable circular reference?
		 */
       
    }
}
