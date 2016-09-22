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
import com.catalog.dao.implement.DepositsDaoImpl;
import com.catalog.model.Deposits;

/**
 * Servlet implementation class EditDeposit
 */
@WebServlet("/EditDeposit")
public class EditDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int depositId = Integer.parseInt(request.getParameterNames().nextElement());
		Connection connection = Connections.getConnections();
		try {
			String insert = "SELECT * FROM DEPOSITS WHERE DEPOSIT_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, depositId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Deposits deposit = new Deposits();
			deposit.setDepositId(depositId);
			deposit.setDepositType(resultSet.getString(3));
			deposit.setDescription(resultSet.getString(5));
			deposit.setInterestRate(resultSet.getDouble(4));
			deposit.setMaximumDuration(resultSet.getInt(6));
			request.setAttribute("deposit", deposit);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditDeposit.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Connections.closeConnections(connection);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int depositId = Integer.parseInt(request.getParameter("depositId"));
		String depositType = request.getParameter("depositType");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		int maximumDuration = Integer.parseInt(request.getParameter("maximumDuration"));
		DepositsDaoImpl depositsDaoImpl= new DepositsDaoImpl();
		depositsDaoImpl.updateDeposit(depositId, depositType, interestRate, description, maximumDuration); // call insert method
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

	
}
