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
    	
    	System.out.println("******parent bean ******");
    	Student student = (Student)ctx.getBean("student");
    	student.getSubjects();
    	System.out.println("**********child bean *****");
    	Student scienceStudent = (Student)ctx.getBean("scienceStudent");
    	scienceStudent.getSubjects();
        ctx.registerShutdownHook();
    }
}
