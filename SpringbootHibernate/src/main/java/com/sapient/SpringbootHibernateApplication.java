package com.sapient;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sapient.dao.UserRepository;
import com.sapient.entities.Address;
import com.sapient.entities.User;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup database tables.
        //userRepository.deleteAll();
        
		Address address = new Address("street1a","street1b", "city1", "state1", "country1", "1234");
		HashSet<Address> addresses = new HashSet<>();
		addresses.add(address);
		
		HashSet<String> phoneNums = new HashSet<>();
		phoneNums.add("123");
		
		User person = new User("Spring Boot", "springboot@example.com", phoneNums, addresses);
		userRepository.save(person);
	}
}
