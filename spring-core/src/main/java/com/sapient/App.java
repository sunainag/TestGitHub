package com.sapient;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sapient.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans.xml");
    	Student student = (Student)ctx.getBean("student");
    	student.printDetails();
    	student.printDetails();
    	student.printDetails();
        ctx.registerShutdownHook();
    }
}
