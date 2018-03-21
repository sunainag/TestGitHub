package com.sapient;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import com.sapient.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	DefaultListableBeanFactory bf= new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
    	System.out.println("******id:1, name:Sunaina ******");
    	Student one = (Student)bf.getBean("studentOne");
    	one.printDetails();
    	System.out.println();
    	System.out.println("*********id:2, name:Sam *****");
    	Student two = (Student)bf.getBean("studentTwo");
    	two.printDetails();
    }
}
