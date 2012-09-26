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

	@RequestMapping(value = "/contact", params = "add", method = RequestMethod.POST)
	public String postAddContact(@RequestParam String name,
			@RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip) {
		Address address = new Address(street, city, state, zip);
		Contact contact = new Contact(name, address);
		contact = contactRepository.save(contact);

		return "redirect:contact?id=" + contact.getId();
	}

	@RequestMapping(value = "/contact", params = "edit", method = RequestMethod.POST)
	public String postEditContact(@RequestParam long id,
			@RequestParam String name, @RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip) {
		Contact contact = contactRepository.findOne(id);
		Address address = contact.getAddress();
		contact.setName(name);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		contactRepository.save(contact);

		return "redirect:contact?id=" + contact.getId();
	}

	@RequestMapping(value = "/contact", params = "delete", method = RequestMethod.POST)
	public String postDeleteContact(@RequestParam long id) {
		contactRepository.delete(id);
		return "redirect:contacts";
	}

}
