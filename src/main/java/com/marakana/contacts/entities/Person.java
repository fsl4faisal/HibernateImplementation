package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Person extends Contact {

	@OneToOne(cascade = CascadeType.ALL,optional=false)
	private Address address;

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
