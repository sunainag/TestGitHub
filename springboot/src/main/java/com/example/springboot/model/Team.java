package com.example.springboot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Team {
	
	@Id
	@GeneratedValue
	Long id;
	@Column
	String name;
	@Column
	String location;
	@Column
	String mascot;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teamId")
	Set<Player> players;
	
	public Team() {
		super();
	}
	
	public Team(String name, String location, Set<Player> players) {
		this();
		this.name = name;
		this.location = location;
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMascot() {
		return mascot;
	}
	public void setMascot(String mascot) {
		this.mascot = mascot;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}
