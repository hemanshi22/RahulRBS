package com.catalog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.dao.implement.DepositsDaoImpl;

/**
 * Servlet implementation class AddDeposit
 */
@WebServlet("/AddDeposit")
public class AddDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String depositType = request.getParameter("depositType");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		int maximumDuration = Integer.parseInt(request.getParameter("maximumDuration"));
		DepositsDaoImpl depositsDaoImpl = new DepositsDaoImpl();
		depositsDaoImpl.insertDeposit( depositType, interestRate, description, maximumDuration);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

}
