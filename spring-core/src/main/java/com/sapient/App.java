package com.sapient;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans.xml");
    	Student student = ctx.getBean(Student.class);
    	Student student1 = ctx.getBean(Student.class);
    	
    	System.out.println(student==student1);
    	System.out.println(student.getAddress()==student1.getAddress());
        ctx.registerShutdownHook();
    }
}
