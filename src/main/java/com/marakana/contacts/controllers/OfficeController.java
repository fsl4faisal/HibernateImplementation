package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Office;
import com.marakana.contacts.repositories.OfficeRepository;

@Controller
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
	public String getAddOffice() {
		return "office/add";
	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.GET)
	public String getEditOffice(@RequestParam long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/edit";
	}

	@RequestMapping(value = "/office", method = RequestMethod.GET)
	public String getViewOffice(@RequestParam long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/view";
	}

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.POST)
	public String postAddOffice(@RequestParam String name) {

		Office office = new Office(name);
		office = officeRepository.save(office);

		return "redirect:office?id=" + office.getId();

	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
	public String postEditOffice(@RequestParam String name,
			@RequestParam long id) {

		Office office = officeRepository.findOne(id);

		office = officeRepository.save(office);
		System.out.println("details from officeServlet after the update :"
				+ office.getName());
		// redirect to view page
		return "redirect:office?id=" + office.getId();
	}

	@RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
	public String postDeleteOffice(@RequestParam long id) {
		officeRepository.delete(officeRepository.findOne(id));

		return "redirect:contacts";

	}

}
