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
	private CompanyRepository companyRepository;

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
	public String getAddOffice(@RequestParam long company_id, Model model) {
		model.addAttribute("company", companyRepository.findOne(company_id));
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
	public String postAddOffice(@RequestParam long company_id,
			@RequestParam String name, @RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip) {
		Company company = companyRepository.findOne(company_id);
		Address address = new Address(street, city, state, zip);
		Office office = new Office(name, address, company);
		office = officeRepository.save(office);

		return "redirect:office?id=" + office.getId();
	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
	public String postEditOffice(@RequestParam long id,
			@RequestParam String name, @RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip) {
		Office office = officeRepository.findOne(id);
		Address address = office.getAddress();
		office.setName(name);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		officeRepository.save(office);

		return "redirect:office?id=" + office.getId();
	}

	@RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
	public String postDeleteOffice(@RequestParam long id) {
		Office office = officeRepository.findOne(id);
		Company company = office.getCompany();
		company.getOffices().remove(office);
		companyRepository.save(company);

		return "redirect:company?id=" + company.getId();
	}

}
