package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Office extends BaseEntity{

	@OneToOne
	private Address address;

	@Column
	private String name;
	
	public Office(){}

	public Office(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Office(Address address) {
		super();
		this.address = address;
	}

	
}
