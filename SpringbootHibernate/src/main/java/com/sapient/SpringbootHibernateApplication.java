package com.sapient;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.dao.UserProfileRepository;
import com.sapient.dao.UserRepository;
import com.sapient.entities.Asset;
import com.sapient.entities.Gender;
import com.sapient.entities.User;
import com.sapient.entities.UserProfile;

@SpringBootApplication
public class SpringbootHibernateApplication implements CommandLineRunner {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        // Create a User instance
        User user = new User("Rajeev", "rajeev@callicoder.com");
        
        Asset a1 = new Asset("a1","a1 asset");
        Asset a2 = new Asset("a2","a2 asset");
        user.getAssets().add(a1);
        user.getAssets().add(a2);

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        // Create a UserProfile instance
        UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "India", "560008");


        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        // Save Parent Reference (which will save the child as well)
        userRepository.save(user);
        userProfileRepository.save(userProfile);
        
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        System.out.println(userProfiles.get(0).getUser().getName());
	}
}
