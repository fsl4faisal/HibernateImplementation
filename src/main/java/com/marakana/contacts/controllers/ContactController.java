package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String getContactList(Model model) {
		model.addAttribute("contacts", contactRepository.findAll());
		return "contact/list";
	}

	@RequestMapping(value = "/contact", params = "add", method = RequestMethod.GET)
	public String getAddContact() {
		return "contact/add";
	}

	@RequestMapping(value = "/contact", params = "edit", method = RequestMethod.GET)
	public String getEditContact(@RequestParam long id, Model model) {
		model.addAttribute("contact", contactRepository.findOne(id));
		return "contact/edit";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getViewContact(@RequestParam long id, Model model) {
		model.addAttribute("contact", contactRepository.findOne(id));
		return "contact/view";
	}
	
	

	@RequestMapping(value = "/contact",params="add", method = RequestMethod.POST)
	public String postAddContact(@RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam String name) {
		Address address = new Address(street, city, state, zip);
		Contact contact = null;//new Contact(name, address);
		contact = contactRepository.save(contact);

		return "redirect:contact?id=" + contact.getId();

	}

	@RequestMapping(value = "/contact",params="edit", method = RequestMethod.POST)
	public String postEditContact(@RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam String name,
			@RequestParam long id) {

		Contact contact = contactRepository.findOne(id);
		Address address = null;//contact.getAddress();
		contact.setName(name);
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		//contact.setAddress(address);
		contact = contactRepository.save(contact);
		System.out.println("details from contactServlet after the update :"
				+ contact.getName());
		// redirect to view page
		return "redirect:contact?id=" + contact.getId();
	}

	@RequestMapping(value = "/contact",params="delete" ,method = RequestMethod.POST)
	public String postDeleteContact(@RequestParam long id) {
		contactRepository.delete(contactRepository.findOne(id));

		return "redirect:contacts";

	}

}
