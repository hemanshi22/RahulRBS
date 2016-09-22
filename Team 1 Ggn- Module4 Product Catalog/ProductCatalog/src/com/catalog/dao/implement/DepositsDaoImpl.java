package com.catalog.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.catalog.connection.Connections;
import com.catalog.dao.methods.DepositsDao;

public class DepositsDaoImpl implements DepositsDao {

	public ArrayList<Integer> getAllDepId() {
		ArrayList<Integer> depId_list = new ArrayList<Integer>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPOSITS");

			while (resultSet.next()) {
				depId_list.add(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
		return depId_list;
	}

	public List<Map<String, String>> getAllData() {
		List<Map<String, String>> myMap = new ArrayList<Map<String, String>>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPOSITS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int i = 0;
			while (resultSet.next()) {
				Map<String, String> myMap1 = new HashMap<String, String>();
				myMap1.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
				myMap1.put(resultSetMetaData.getColumnName(2), resultSet.getString(2));
				myMap1.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
				myMap1.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));
				myMap1.put(resultSetMetaData.getColumnName(5), resultSet.getString(5));
				myMap1.put(resultSetMetaData.getColumnName(6), resultSet.getString(6));
				myMap.add(i, myMap1);
				i += 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
		return myMap;
	}

	public List<Map<String, String>> getInterest() {
		List<Map<String, String>> myMap = new ArrayList<Map<String, String>>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPOSITS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int i = 0;
			while (resultSet.next()) {
				Map<String, String> myMap1 = new HashMap<String, String>();
				myMap1.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
				myMap1.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));
				myMap1.put(resultSetMetaData.getColumnName(6), resultSet.getString(6));
				myMap.add(i, myMap1);
				i += 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
		return myMap;
	}

	public void insertDeposit(String depositType, double interestRate, String description,
			int maximumDuration) {
		// TODO Auto-generated method stub
		Connection connection = Connections.getConnections();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(DEPOSIT_ID) FROM DEPOSITS");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int depositId = 1 + resultSet.getInt(1);
			String insert = "INSERT INTO DEPOSITS VALUES(2,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, depositId);
			preparedStatement.setString(2, depositType);
			preparedStatement.setDouble(3, interestRate);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, maximumDuration);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
	}

	public void updateDeposit(int depositId, String depositType, double interestRate, String description,
			int maximumDuration) {
		// TODO Auto-generated method stub
		Connection connection = Connections.getConnections();
		try {
			String update = "UPDATE DEPOSITS SET DEPOSIT_TYPE=?, INT_RATE=?, DESCRIPTION=?, MAX_DURATION=? WHERE DEPOSIT_ID=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, depositType);
			preparedStatement.setDouble(2, interestRate);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, maximumDuration);
			preparedStatement.setInt(5, depositId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
	}

}
