package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sapient.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
