package com.sapient;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sapient.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans.xml");
    	
		/*
		 * Student student = ctx.getBean(Student.class);
		 * org.springframework.beans.factory.NoUniqueBeanDefinitionException: No
		 * qualifying bean of type [com.sapient.model.Student] is defined: expected
		 * single matching bean but found 2: student,scienceStudent
		 * 
		 * System.out.println(student.getName());
		 * 
		 * So use @Qualifier
		 */
    	
    	Student student = (Student)ctx.getBean("student");
    	
    	System.out.println("*******printing list of address************");
    	student.getAddressList().forEach(item->System.out.println(item));
    	System.out.println("*******printing set of address*************");
    	student.getAddressSet().forEach(System.out::println);
    	System.out.println("*******printing map of address*************");
    	student.getAddressMap().forEach((k,v)->System.out.println(k+","+v));
    	System.out.println("*******printing properties of address*************");
    	student.getAddressProp().forEach((k,v)->System.out.println(k+","+v));
    	
    	Student scienceStudent = (Student)ctx.getBean("scienceStudent");
    	System.out.println("******student's name is ******\n"+student.getName());
    	System.out.println("**********science student's name is *****\n"+scienceStudent.getName());
        ctx.registerShutdownHook();
    }
}
