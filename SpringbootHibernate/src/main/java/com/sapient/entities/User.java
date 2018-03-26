package com.sapient.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	@ElementCollection
	@CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "phone_number")
	private Set<String> phoneNumbers = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
	@AttributeOverrides({ @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
	private Set<Address> addresses = new HashSet<>();

	public User() {
		// TODO: Builder design pattern implementation
	}

	public User(String name, String email, Set<String> phoneNumbers, Set<Address> addresses) {
		this.name = name;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// @ElementCollection
	// use an element collection to persist a Collection of value types.
	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Embedded
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
