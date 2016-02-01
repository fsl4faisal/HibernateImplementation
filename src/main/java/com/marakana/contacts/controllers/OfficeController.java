package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.Office;
import com.marakana.contacts.repositories.CompanyRepository;
import com.marakana.contacts.repositories.OfficeRepository;

@Controller
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;

	@Autowired
	private CompanyRepository CompanyRepository;

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
	public String getAddOffice(Model model,
			@RequestParam("company_id") long companyId) {
		model.addAttribute("company", CompanyRepository.findOne(companyId));
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
	public String postAddOffice(@RequestParam("company_id") long companyId,
			@RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip,
			@RequestParam String name) {
		Company company = CompanyRepository.findOne(companyId);
		Address address = new Address(street, city, state, zip);
		Office office = new Office(address, name, company);
		office = officeRepository.save(office);

		return "redirect:" + office.getUrl();

	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
	public String postEditOffice(@RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam String name,
			@RequestParam long id) {

		Office office = officeRepository.findOne(id);
		Address address = office.getAddress();
		office.setName(name);
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		office.setAddress(address);
		office = officeRepository.save(office);
		System.out.println("details from officeServlet after the update :"
				+ office.getName());
		// redirect to view page
		return "redirect:" + office.getUrl();
	}

	@RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
	public String postDeleteOffice(@RequestParam long id) {
		Office office=officeRepository.findOne(id);
		officeRepository.delete(office);
		return "redirect:"+office.getCompany().getUrl();

	}

}
