//package com.sapient.entities;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.ElementCollection;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class User {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private String name;
//	private String email;
//	private Set<String> phoneNumbers = new HashSet<>();
//	private Set<Address> addresses = new HashSet<>();
//	
//	public User() {
//		//TODO: Builder design pattern implementation
//	}
//	
//	public User(String name, String email, Set<String> phoneNumbers, Set<Address> addresses) {
//		this.name=name;
//		this.email=email;
//		this.phoneNumbers=phoneNumbers;
//		this.addresses=addresses;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	//@ElementCollection
//	//use an element collection to persist a Collection of value types.
//	public Set<String> getPhoneNumbers() {
//		return phoneNumbers;
//	}
//
//	public void setPhoneNumbers(Set<String> phoneNumbers) {
//		this.phoneNumbers = phoneNumbers;
//	}
//
//	@Embedded
//	public Set<Address> getAddresses() {
//		return addresses;
//	}
//
//	public void setAddresses(Set<Address> addresses) {
//		this.addresses = addresses;
//	}
//	
//	
//}
