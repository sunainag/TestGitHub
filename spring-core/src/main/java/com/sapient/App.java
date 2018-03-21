package com.sapient;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sapient.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans.xml");
    	System.out.println("******id:1, name:Sunaina ******");
    	Student one = (Student)ctx.getBean("studentOne");
    	one.printDetails();
    	System.out.println();
    	System.out.println("*********id:2, name:Sam *****");
    	Student two = (Student)ctx.getBean("studentTwo");
    	two.printDetails();
        ctx.registerShutdownHook();
    }
}
