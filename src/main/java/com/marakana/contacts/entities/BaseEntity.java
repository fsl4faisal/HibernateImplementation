package com.marakana.contacts.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Id
	@GeneratedValue	
	private long id;
	
	@Version
	private Long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
