package com.marakana.contacts.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public void getContactList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.setAttribute("contacts", contactRepository.findAll());

		RequestDispatcher view = request
				.getRequestDispatcher("view/contact/list.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void getContact(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (request.getParameter("add")!=null){
			request.getRequestDispatcher("view/contact/add.jsp").forward(request,response);
		}else{
			///get contact id from request parameter and populate model
			//with the contact and address objects
			long id=Long.parseLong(request.getParameter("id"));
			Contact contact=contactRepository.find(id);//TODO
			request.setAttribute("contact", contact);
			
			//dispatch either to the edit page or to view page
			if(request.getParameter("edit")!=null){
				request.getRequestDispatcher("view/contact.edit.jsp").forward(request, response);
			}
		}

	}

}
