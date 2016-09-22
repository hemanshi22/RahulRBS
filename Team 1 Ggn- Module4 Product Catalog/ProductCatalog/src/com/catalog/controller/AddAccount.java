package com.catalog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.dao.implement.AccountDaoImpl;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountType = request.getParameter("accountType");
		System.out.println(request.getParameter("interestRate"));
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		double minimumBalance = Double.parseDouble(request.getParameter("minimumBalance"));
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		accountDaoImpl.insertAccount(accountType, interestRate, description, minimumBalance);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

	
}
