package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Person;
import com.marakana.contacts.repositories.Repository;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Repository<Person> personRepository = new Repository<Person>(Person.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				request.getRequestDispatcher("jsp/addPerson.jsp").forward(
						request, response);
			} else {
				long id = Long.parseLong(request.getParameter("id"));
				Person person = personRepository.find(id);
				request.setAttribute("person", person);

				String viewName;
				if (request.getParameter("edit") != null)
					viewName = "jsp/editPerson.jsp";
				else
					viewName = "jsp/person.jsp";
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
			Person person;
			Address address;

			if (request.getParameter("edit") != null) {
				long id = Long.parseLong(request.getParameter("id"));
				person = personRepository.find(id);
				address = person.getAddress();
			} else if (request.getParameter("add") != null) {
				person = new Person();
				address = new Address();
				person.setAddress(address);
			} else {
				throw new UnsupportedOperationException("invalid method");
			}

			person.setName(request.getParameter("name"));
			address.setStreet(request.getParameter("street"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setZip(request.getParameter("zip"));
			person = personRepository.save(person);

			response.sendRedirect("person?id=" + person.getId());

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
