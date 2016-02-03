package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Contact extends UrlEntity{


	@Column(nullable=false)
	@NotBlank
	private String name;

	public Contact(String name) {
		super();
		this.name = name;
	}

	public Contact() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
