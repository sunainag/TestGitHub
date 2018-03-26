package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
