package com.sapient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.dao.SpringBootHibernateRepository;
import com.sapient.entities.Address;
import com.sapient.entities.Employee;
import com.sapient.entities.Student;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner {

	@Autowired
	private SpringBootHibernateRepository bootRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Address address = new Address("OMR Road", "Chennai", "TN", "India", "600097");
		Student student = new Student("Eswar", address);
		bootRepo.save(student);
		
		// Employee emp = getEmployee();
		// bootRepo.save(emp);
		// Employee emp1 = new Employee();
		// emp1.setName("Sahil");
		// emp1.setSalary(new Double(14000));
		// emp1.setDoj(new Date());
		// bootRepo.save(emp1);

		// Address address = new Address("address line 1","address line 2","city",
		// "state", "country","1234");
		/*
		 * HashSet addresses = new HashSet(); addresses.add(address); HashSet phoneNums
		 * = new HashSet(); phoneNums.add("123"); User person = new
		 * User("John Doe","email", phoneNums,addresses);
		 */
	}

	private Employee getEmployee() {
		Employee emp = new Employee();
		emp.setName("Sunaina");
		emp.setSalary(new Double(1200));
		emp.setDoj(new Date());
		return emp;
	}
}
