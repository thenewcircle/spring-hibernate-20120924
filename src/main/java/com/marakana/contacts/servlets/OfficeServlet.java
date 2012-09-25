package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.Office;
import com.marakana.contacts.repositories.Repository;

@WebServlet("/office")
public class OfficeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Repository<Company> companyRepository = new Repository<Company>(Company.class);
	private final Repository<Office> officeRepository = new Repository<Office>(Office.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				long companyId = Long.parseLong(request.getParameter("company"));
				request.setAttribute("company", companyRepository.find(companyId));
				request.getRequestDispatcher("jsp/addOffice.jsp").forward(
						request, response);
			} else {
				long id = Long.parseLong(request.getParameter("id"));
				Office office = officeRepository.find(id);
				request.setAttribute("office", office);

				String viewName;
				if (request.getParameter("edit") != null)
					viewName = "jsp/editOffice.jsp";
				else
					viewName = "jsp/office.jsp";
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
			Office office;
			Company company;
			Address address;

			if (request.getParameter("edit") != null) {
				long id = Long.parseLong(request.getParameter("id"));
				office = officeRepository.find(id);
				company = office.getCompany();
				address = office.getAddress();
			} else if (request.getParameter("add") != null) {
				long companyId = Long.parseLong(request.getParameter("company"));
				company = companyRepository.find(companyId);
				office = new Office();
				address = new Address();
				office.setAddress(address);
				office.setCompany(company);
			} else {
				throw new UnsupportedOperationException("invalid method");
			}

			office.setName(request.getParameter("name"));
			address.setStreet(request.getParameter("street"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setZip(request.getParameter("zip"));
			office = officeRepository.save(office);

			response.sendRedirect("office?id=" + office.getId());

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
