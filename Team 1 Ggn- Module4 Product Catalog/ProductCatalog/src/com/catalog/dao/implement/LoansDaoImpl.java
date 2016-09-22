package com.catalog.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.catalog.connection.Connections;
import com.catalog.dao.methods.LoansDao;
import com.catalog.model.Loans;

public class LoansDaoImpl implements LoansDao {

	public List<Loans> getAllLoans() {
		List<Loans> list = new ArrayList<Loans>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM LOANS");
			while (resultSet.next()) {
				Loans loans = new Loans();
				loans.setLoanType(resultSet.getString(3));
				
				loans.setDescription(resultSet.getString(5));
				loans.setLoanId(resultSet.getInt(2));
				loans.setInterestRate(resultSet.getDouble(4));
				list.add(loans);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			Connections.closeConnections(connection);
		}
		return list;
	}

	public void updateLoan(int loanId, String loanType, double interestRate, String description, int maximumDuration) {
		Connection connection = Connections.getConnections();
		try {
			String update = "UPDATE LOANS SET LOAN_TYPE=?, INT_RATE=?, DESCRIPTION=?, MAX_DURATION=? WHERE LOAN_ID=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, loanType);
			preparedStatement.setDouble(2, interestRate);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, maximumDuration);
			preparedStatement.setInt(5, loanId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			Connections.closeConnections(connection);
		}
	}

	public void insertLoan(String loanType, double interestRate, String description, int maximumDuration) {
		Connection connection = Connections.getConnections();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(LOAN_ID) FROM LOANS");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int loanId = 1 + resultSet.getInt(1);
			String insert = "INSERT INTO LOANS VALUES(1,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, loanId);
			preparedStatement.setString(2, loanType);
			preparedStatement.setDouble(3, interestRate);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, maximumDuration);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Connections.closeConnections(connection);
		}
	}






}
