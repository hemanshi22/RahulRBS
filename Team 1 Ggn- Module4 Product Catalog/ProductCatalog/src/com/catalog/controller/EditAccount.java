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
import com.catalog.dao.implement.AccountDaoImpl;
import com.catalog.model.Accounts;

//import com.google.gson.Gson;

@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameterNames().nextElement());
Connection connection=Connections.getConnections();
		try {
			String update = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Accounts accounts = new Accounts();
			accounts.setAccountId(accountId);
			accounts.setAccountType(resultSet.getString(3));
			accounts.setDescription(resultSet.getString(6));
			accounts.setInterestRate(resultSet.getDouble(5));
			accounts.setMinimumBalance(resultSet.getDouble(4));
			request.setAttribute("account", accounts);
			connection.close();
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditAccount.jsp");
			dispatcher.forward(request, response);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
finally{
	Connections.closeConnections(connection);
}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		System.out.println(accountId);
		String accountType = request.getParameter("accountType");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		String description = request.getParameter("description");
		double minimumBalance = Double.parseDouble(request.getParameter("minimumBalance"));
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		accountDaoImpl.updateAccount(accountId, accountType, interestRate, description, minimumBalance); // call insert method
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

}
