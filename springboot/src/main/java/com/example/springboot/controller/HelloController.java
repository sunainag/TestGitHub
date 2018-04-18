package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Team;

@RestController //invoked correct HttpMessageConverter, based on requested format and jars in classpa
public class HelloController {
	
	@Autowired
	private TeamDao teamDao;
	
	@RequestMapping("/hi/{id}")
	public Team showTeamById(@PathVariable Long id){
        return teamDao.findById(id);
	}
	
	@RequestMapping("/teams/{id}")
	public Team showTeams(@PathVariable Long id){
        return teamDao.findById(id);
	}
}
