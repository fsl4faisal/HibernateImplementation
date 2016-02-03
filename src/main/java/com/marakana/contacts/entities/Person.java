package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Person extends Contact {

	@OneToOne(cascade = CascadeType.ALL,optional=false)
	private Address address;
	
	@ManyToOne
	private Person manager;
	
	@ManyToOne
	private Company employer;

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

	public Person(String name, Address address) {
		super(name);
		this.address = address;
	}
	
	public Person(){}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
