package com.example.springboot.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.springboot.model.Team;

//@RestResource(path="teams",rel="teams")
public interface TeamDao extends CrudRepository<Team, Long> {

	List<Team> findAll();
	Team findById(Long arg0);
}
