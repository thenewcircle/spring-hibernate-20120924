package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Company;
import com.marakana.contacts.repositories.Repository;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Repository<Company> companyRepository = new Repository<Company>(Company.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				request.getRequestDispatcher("jsp/addCompany.jsp").forward(
						request, response);
			} else {
				long id = Long.parseLong(request.getParameter("id"));
				Company company = companyRepository.find(id);
				request.setAttribute("company", company);

				String viewName;
				if (request.getParameter("edit") != null)
					viewName = "jsp/editCompany.jsp";
				else
					viewName = "jsp/company.jsp";
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
			Company company;

			if (request.getParameter("edit") != null) {
				long id = Long.parseLong(request.getParameter("id"));
				company = companyRepository.find(id);
			} else if (request.getParameter("add") != null) {
				company = new Company();
			} else {
				throw new UnsupportedOperationException("invalid method");
			}

			company.setName(request.getParameter("name"));
			company = companyRepository.save(company);

			response.sendRedirect("company?id=" + company.getId());

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
