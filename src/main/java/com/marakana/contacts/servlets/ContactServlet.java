package com.marakana.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

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
			long id = Long.parseLong(request.getParameter("id"));
			try {
				Contact contact = contactRepository.find(id);
				Address address = addressRepository
						.find(contact.getAddressId());
				request.setAttribute("contact", contact);
				request.setAttribute("address", address);
				request.getRequestDispatcher("jsp/viewContact.jsp").forward(
						request, response);
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				Address address = new Address(request.getParameter("street"),
						request.getParameter("city"),
						request.getParameter("state"),
						request.getParameter("zip"));
				addressRepository.create(address);
				Contact contact = new Contact(request.getParameter("name"),
						address.getId());
				contactRepository.create(contact);
				response.sendRedirect("contact?id=" + contact.getId());
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
