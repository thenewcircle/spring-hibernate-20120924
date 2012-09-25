package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final AddressRepository addressRepository = new AddressRepository();
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request,
					response);
		} else {
			// get contact id from request parameter, and populate model
			// with the contact and address objects
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());
			request.setAttribute("contact", contact);
			request.setAttribute("address", address);

			// dispatch either to the edit page or to the view page
			if (request.getParameter("edit") != null) {
				request.getRequestDispatcher("jsp/editContact.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("jsp/viewContact.jsp").forward(
						request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {

			// create new contact and address from form parameters, and
			// persist
			Address address = new Address(request.getParameter("street"),
					request.getParameter("city"),
					request.getParameter("state"), request.getParameter("zip"));
			addressRepository.save(address);
			Contact contact = new Contact(request.getParameter("name"),
					address.getId());
			contactRepository.save(contact);

			// redirect to contact view page
			response.sendRedirect("contact?id=" + contact.getId());

		} else if (request.getParameter("edit") != null) {

			// look up existing contact and address, edit fields and persist
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());
			contact.setName(request.getParameter("name"));
			address.setStreet(request.getParameter("street"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setZip(request.getParameter("zip"));
			contactRepository.save(contact);
			addressRepository.save(address);

			// redirect to contact view page
			response.sendRedirect("contact?id=" + contact.getId());
		} else if (request.getParameter("delete") != null) {
			// look up existing contact and address, and delete
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());
			contactRepository.delete(contact);
			addressRepository.delete(address);

			// redirect to contact list page
			response.sendRedirect("contacts");
		} else {
			super.doPost(request, response);
		}
	}

}
