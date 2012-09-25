package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.Repository;

@WebServlet("/contacts")
public class ContactCollectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Repository<Contact> contactRepository = new Repository<Contact>(Contact.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("contacts", contactRepository.findAll());
			RequestDispatcher view = request.getRequestDispatcher("jsp/contactCollection.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
