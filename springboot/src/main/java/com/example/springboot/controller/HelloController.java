package com.example.springboot.controller;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.springboot.model.Player;
import com.example.springboot.model.Team;

@Controller
public class HelloController {
	
	private Team team;

	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<>();
		players.add(new Player("Ajay","pitcher"));
		players.add(new Player("Vijay","shortstop"));
		
		team = new Team("Punjab", "Bathinda", players);
		
	}
	@RequestMapping("/hi")
	public @ResponseBody Team showTeams(){
        return team;
	}
}
