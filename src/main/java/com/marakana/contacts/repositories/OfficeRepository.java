package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Office;
import com.marakana.contacts.entities.Person;

public interface OfficeRepository extends JpaRepository<Office, Long> {


}