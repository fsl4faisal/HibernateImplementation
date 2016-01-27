package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request,
					response);
		} else {
			/*
			 * get contact id from request parameter and populate model with
			 * contact and address objects
			 */

			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			request.setAttribute("contact", contact);

			/*
			 * dispatch either to the edit page or to the view page
			 */
			if (request.getParameter("edit") != null) {
				request.getRequestDispatcher("jsp/editContact.jsp").forward(
						request, response);
			} else {
				System.out.println("ContactServlet above jsp/viewContact.jsp");
				for (Contact c : contactRepository.findAll()) {
					System.out.println("findAll() from ContactServlet :" + c.getName());
				}
				request.getRequestDispatcher("jsp/viewContact.jsp").forward(
						request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// add a new contact
		if (request.getParameter("add") != null) {
			// create new contact and address from form parameter and
			// persist
			Address address = new Address(request.getParameter("street"),
					request.getParameter("city"),
					request.getParameter("state"), request.getParameter("zip"));
			Contact contact = new Contact(request.getParameter("name"), address);

			contact = contactRepository.save(contact);

			// redirect to contact view page
			response.sendRedirect("contact?id=" + contact.getId());
		}
		if (request.getParameter("edit") != null) {
			// lookup exiting contact and address, edit fields and persist
			System.out.println("Inside ContectServlet doPost Edit");
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
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
			
			System.out.println("ContactServlet in edit doPost after saving contacts in the database");
			for (Contact c : contactRepository.findAll()) {
				System.out.println("ContactServlet in edit doPost after saving contacts in the database:findAll() from ContactServlet :" + c.getName());
			}
			
			response.sendRedirect("contact?id=" + contact.getId());

		}
		if (request.getParameter("delete") != null) {
			System.out.println("Inside delete doPost");
			// delete and persist
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			contactRepository.delete(contact);
			// redirect to view page
			response.sendRedirect("contacts");

		}
	}

}
