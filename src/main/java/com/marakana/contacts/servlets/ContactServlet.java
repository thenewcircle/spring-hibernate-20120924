package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	private final ContactRepository contactRepository = new ContactRepository();
	private final AddressRepository addressRepository = new AddressRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				request.getRequestDispatcher("jsp/addContact.jsp").forward(
						request, response);
			} else {
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepository.find(id);
				Address address = addressRepository
						.find(contact.getAddressId());

				request.setAttribute("contact", contact);
				request.setAttribute("address", address);

				String viewName;
				if (request.getParameter("edit") != null)
					viewName = "jsp/editContact.jsp";
				else
					viewName = "jsp/contact.jsp";
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Contact contact;
			Address address;

			if (request.getParameter("edit") != null) {
				long id = Long.parseLong(request.getParameter("id"));
				contact = contactRepository.find(id);
				address = addressRepository.find(contact.getAddressId());
			} else if (request.getParameter("add") != null) {
				contact = new Contact();
				address = new Address();
			} else {
				throw new UnsupportedOperationException("invalid method");
			}

			address.setStreet(request.getParameter("street"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setZip(request.getParameter("zip"));
			addressRepository.save(address);

			contact.setName(request.getParameter("name"));
			contact.setAddressId(address.getId());
			contactRepository.save(contact);

			response.sendRedirect("contact?id=" + contact.getId());

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
