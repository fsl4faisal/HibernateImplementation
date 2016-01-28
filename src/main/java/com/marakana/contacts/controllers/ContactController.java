package com.marakana.contacts.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public void postContact(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (request.getParameter("add") != null) {
			// create new contact and address from form parameters
			// and persist
			Address address = new Address(request.getParameter("street"),
					request.getParameter("city"),
					request.getParameter("state"), request.getParameter("zip"));
			Contact contact = new Contact(request.getParameter("name"), address);

			contact = contactRepository.save(contact);

			// redirect to contact view page
			response.sendRedirect("contact?id=" + contact.getId());
		} else if (request.getParameter("edit") != null) {
			// lookup exiting contact and address, edit fields and persist
			System.out.println("Inside ContectServlet doPost Edit");
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.findOne(id);
			Address address = contact.getAddress();
			contact.setName(request.getParameter("name"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setStreet(request.getParameter("street"));
			address.setZip(request.getParameter("zip"));
			contact.setAddress(address);
			contact = contactRepository.save(contact);
			System.out.println("details from contactServlet after the update :"
					+ contact.getName());
			// redirect to view page

			System.out
					.println("ContactServlet in edit doPost after saving contacts in the database");
			for (Contact c : contactRepository.findAll()) {
				System.out
						.println("ContactServlet in edit doPost after saving contacts in the database:findAll() from ContactServlet :"
								+ c.getName());
			}

			response.sendRedirect("contact?id=" + contact.getId());

		} else if (request.getParameter("delete") != null) {
			System.out.println("Inside delete doPost");
			// delete and persist
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.findOne(id);
			contactRepository.delete(contact);
			// redirect to view page
			response.sendRedirect("contacts");

		}

	}

}
