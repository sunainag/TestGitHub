package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.entities.Student;

@Repository
public interface SpringBootHibernateRepository extends JpaRepository<Student, Long> {

}
