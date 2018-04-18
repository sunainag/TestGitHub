package com.example.springboot;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.springboot.controller.TeamDao;
import com.example.springboot.model.Player;
import com.example.springboot.model.Team;

@SpringBootApplication
public class SpringbootApplication  extends SpringBootServletInitializer{

	/*Used when run as a JAR*/
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	/*Used when run as a WAR*/
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApplication.class);
	}
	
	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<>();
		players.add(new Player("Ajay1","pitcher"));
		players.add(new Player("Vijay1","shortstop"));
		
		Team team = new Team("Punjab", "Bathinda", players);
		teamDao.save(team);
	}
	
	@Autowired
	TeamDao teamDao;
}
