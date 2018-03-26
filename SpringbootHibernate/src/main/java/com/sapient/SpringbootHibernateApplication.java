package com.sapient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.dao.SpringBootHibernateRepository;
import com.sapient.entities.Address;
import com.sapient.entities.Employee;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner {

	@Autowired
	private SpringBootHibernateRepository myRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Employee emp = getEmployee(); employeeRepo.save(emp);
		 * 
		 * Employee emp1 = new Employee(); emp1.setName("Sahil"); emp1.setSalary(new
		 * Double(1400)); emp1.setDoj(new Date()); employeeRepo.save(emp1);
		 */

		Address address = new Address("address line 1","address line 2","city", "state", "country","1234");
		//User person = new User("John Doe", address);
		myRepo.save(address);
	}

	private Employee getEmployee() {
		Employee emp = new Employee();
		emp.setName("Sunaina");
		emp.setSalary(new Double(1200));
		emp.setDoj(new Date());
		return emp;
	}
}
