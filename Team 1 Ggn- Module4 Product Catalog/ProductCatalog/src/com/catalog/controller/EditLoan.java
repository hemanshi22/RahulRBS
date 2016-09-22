package com.catalog.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.connection.Connections;
import com.catalog.dao.implement.LoansDaoImpl;
import com.catalog.model.Loans;

/**
 * Servlet implementation class EditLoan
 */
@WebServlet("/EditLoan")
public class EditLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int loanId = Integer.parseInt(request.getParameterNames().nextElement());
		Connection connection = Connections.getConnections();
		try {
			String insert = "SELECT * FROM LOANS WHERE LOAN_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, loanId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Loans loans = new Loans();
			loans.setDescription(resultSet.getString(5));
			loans.setInterestRate(resultSet.getDouble(4));
			loans.setLoanId(loanId);
			loans.setLoanType(resultSet.getString(3));
			loans.setMaximumDuration(resultSet.getInt(6));
			request.setAttribute("loan", loans);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditLoan.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		String loanType = request.getParameter("loanType");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		int maximumDuration = Integer.parseInt(request.getParameter("maximumDuration"));
		LoansDaoImpl loansDaoImpl = new LoansDaoImpl();
		loansDaoImpl.updateLoan(loanId, loanType, interestRate, description, maximumDuration);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

}
