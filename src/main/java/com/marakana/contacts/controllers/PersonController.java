package com.marakana.contacts.controllers;

import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Person;
import com.marakana.contacts.repositories.CompanyRepository;
import com.marakana.contacts.repositories.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.GET)
	@LogMessage(level = Level.INFO)
	public String getAddPerson() {
		return "person/add";
	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.GET)
	public String getEditPerson(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		model.addAttribute("managers", personRepository.findAll());
		model.addAttribute("employers", companyRepository.findAll());
		return "person/edit";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getViewPerson(@RequestParam long id, Model model) {
		System.out.println("inside getViewPerson PersonController");
		model.addAttribute("person", personRepository.findOne(id));
		return "person/view";
	}

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	public String postAddPerson(@RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam String name) {
		Address address = new Address(street, city, state, zip);
		Person person = new Person(name, address);
		person = personRepository.save(person);

		return "redirect:person?id=" + person.getId();

	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.POST)
	@Transactional
	public String postEditPerson(@RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam String name,
			@RequestParam long id, @RequestParam("employer_id") long employerId,
			@RequestParam("manager_id") long managerId) {
		System.out.println("inside postEditPerson PersonController");
		System.out.println("Inside postEditPerson");
		Person person = personRepository.findOne(id);
		Address address = person.getAddress();
		person.setName(name);
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		person.setAddress(address);
		person.setEmployer(companyRepository.findOne(employerId));
		person.setManager(personRepository.findOne(managerId));

		person = personRepository.save(person);
		System.out.println("details from personServlet after the update :"
				+ person.getName());
		// redirect to view page
		return "redirect:person?id=" + person.getId();
	}

	@RequestMapping(value = "/person", params = "delete", method = RequestMethod.POST)
	public String postDeletePerson(@RequestParam long id) {
		personRepository.delete(personRepository.findOne(id));

		return "redirect:contacts";

	}

}
