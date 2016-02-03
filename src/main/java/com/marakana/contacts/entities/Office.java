package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Office extends UrlEntity{

	@OneToOne(optional=false,cascade=CascadeType.ALL)
	private Address address;

	@Column(nullable=false,length=64)
	@NotBlank
	private String name;
	
	@ManyToOne(optional=false)
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Office(){}


	public Office(Address address, String name, Company company) {
		super();
		this.address = address;
		this.name = name;
		this.company = company;
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
