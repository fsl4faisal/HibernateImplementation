package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Company;
import com.marakana.contacts.repositories.CompanyRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	
	@RequestMapping(value = "/company", params = "add", method = RequestMethod.GET)
	public String getAddCompany() {
		return "company/add";
	}

	@RequestMapping(value = "/company", params = "edit", method = RequestMethod.GET)
	public String getEditCompany(@RequestParam long id, Model model) {
		model.addAttribute("company", companyRepository.findOne(id));
		return "company/edit";
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String getViewCompany(@RequestParam long id, Model model) {
		model.addAttribute("company", companyRepository.findOne(id));
		return "company/view";
	}

	@RequestMapping(value = "/company", params = "add", method = RequestMethod.POST)
	public String postAddCompany(@RequestParam String name) {
		
		System.out.println("Inside add/Post/CompanyController with :"+name);

		Company company = new Company(name,null);
		company = companyRepository.save(company);
		System.out.println("inside postAddCompany(findAll)" +companyRepository.findAll());

		return "redirect:company?id=" + company.getId();

	}

	@RequestMapping(value = "/company", params = "edit", method = RequestMethod.POST)
	public String postEditCompany(@RequestParam String name,
			@RequestParam long id) {

		Company company = companyRepository.findOne(id);
		company.setName(name);
		company = companyRepository.save(company);
		System.out.println("details from companyServlet after the update :"
				+ company.getName());
		// redirect to view page
		return "redirect:company?id=" + company.getId();
	}

	@RequestMapping(value = "/company", params = "delete", method = RequestMethod.POST)
	public String postDeleteCompany(@RequestParam long id) {
		companyRepository.delete(companyRepository.findOne(id));

		return "redirect:contacts";

	}

}
