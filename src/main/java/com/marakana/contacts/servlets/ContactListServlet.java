package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contacts")
public class ContactListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Above doGet for /contacts of findAll()");
		request.setAttribute("contacts", contactRepository.findAll());
		//List<Contact> contacts = contactRepository.findAll();

		for (Contact contact : contactRepository.findAll()) {
			System.out.println("findAll() from ContactListServlet :" + contact.getName());
		}
		
		RequestDispatcher view = request
				.getRequestDispatcher("jsp/contactList.jsp");
		view.forward(request, response);


	}

}
