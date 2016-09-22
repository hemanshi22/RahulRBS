package com.catalog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.dao.implement.LoansDaoImpl;


@WebServlet("/AddLoan")
public class AddLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loanType = request.getParameter("loanType");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		int maximumDuration = Integer.parseInt(request.getParameter("maximumDuration"));
		LoansDaoImpl loansDaoImpl = new LoansDaoImpl();
		loansDaoImpl.insertLoan(loanType, interestRate, description, maximumDuration); // call insert method
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}
}
