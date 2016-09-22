package com.catalog.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.connection.Connections;

/**
 * Servlet implementation class DeleteLoan
 */
@WebServlet("/DeleteLoan")
public class DeleteLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int loanId = Integer.parseInt(request.getParameterNames().nextElement());
		Connection connection = Connections.getConnections();
		try {
			String insert = "DELETE FROM LOANS WHERE LOAN_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, loanId);
			preparedStatement.executeUpdate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
	}
}
