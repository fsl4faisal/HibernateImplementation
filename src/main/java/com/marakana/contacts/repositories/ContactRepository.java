package com.marakana.contacts.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.marakana.contacts.entities.Contact;

public class ContactRepository extends Repository<Contact> {

	private final EntityManager em = Persistence.createEntityManagerFactory(
			"training2").createEntityManager();
	
	public ContactRepository() {
		super(Contact.class);
	}
	
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts;
		contacts=em.createQuery("from " + Contact.class.getSimpleName(),
				Contact.class).getResultList();
		for (Contact contact : contacts) {
			System.out.println("inside findAll() function from ContactRepository.java :" + contact.getName());
		}
		System.out.println("inside findAll() function from ContactRepository.java size:"+contacts.size());
		
		return contacts;
	}

}
