package com.example.springboot.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Player;
import com.example.springboot.model.Team;

@RestController //ithnvoked correct HttpMessageConverter, based on requested format and jars in classpa
public class HelloController {
	
	private Team team;

	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<>();
		players.add(new Player("Ajay1","pitcher"));
		players.add(new Player("Vijay1","shortstop"));
		
		team = new Team("Punjab", "Bathinda", players);
		
	}
	@RequestMapping("/hi")
	public Team showTeams(){
        return team;
	}
}
