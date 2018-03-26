package com.sapient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.dao.EmployeeRepository;
import com.sapient.entities.Employee;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = getEmployee();
		employeeRepo.save(emp);
		
		Employee emp1 = new Employee();
		emp1.setName("Sahil");
		emp1.setSalary(new Double(1400));
		emp1.setDoj(new Date());
		employeeRepo.save(emp1);
		
	}

	private Employee getEmployee() {
		Employee emp = new Employee();
		emp.setName("Sunaina");
		emp.setSalary(new Double(1200));
		emp.setDoj(new Date());
		return emp;
	}
}
