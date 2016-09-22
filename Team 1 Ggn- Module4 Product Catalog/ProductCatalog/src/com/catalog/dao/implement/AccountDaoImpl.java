package com.catalog.dao.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

import org.codehaus.jettison.json.JSONObject;

import com.catalog.connection.Connections;
import com.catalog.dao.methods.AccountsDao;
import com.catalog.model.User;;

public class AccountDaoImpl implements AccountsDao {

	public ArrayList<Integer> getAllAccountNum() {
		Connection connection = Connections.getConnections();
		Statement statement = null;
		ArrayList<Integer> acc_list = new ArrayList<Integer>();
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNTS");
			while (resultSet.next()) {
				acc_list.add(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
		return acc_list;
	}

	@Override
	public List<Map<String, String>> getAllData() {
		List<Map<String, String>> myMap = new ArrayList<Map<String, String>>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNTS");
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNTS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int i = 0;
			while (resultSet.next()) {
				Map<String, String> myMap1 = new HashMap<String, String>();
				myMap1.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
				myMap1.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));
				myMap1.put(resultSetMetaData.getColumnName(5), resultSet.getString(5));
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

	public void insertAccount(String accountType, double interestRate, String description, double minimumBalance) {
		Connection connection = Connections.getConnections();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(ACCOUNT_ID) FROM ACCOUNTS");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int accountId = 1 + resultSet.getInt(1);
			String insert = "INSERT INTO ACCOUNTS VALUES(3,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, accountId);
			preparedStatement.setString(2, accountType);
			preparedStatement.setDouble(3, minimumBalance);
			preparedStatement.setDouble(4, interestRate);
			preparedStatement.setString(5, description);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			Connections.closeConnections(connection);
		}
	}

	public void updateAccount(int accountId, String accountType, double interestRate, String description,
			double minimumBalance) {
		Connection connection = Connections.getConnections();
		try {

			String update = "UPDATE ACCOUNTS SET ACCOUNT_TYPE=?, INT_RATE=?, DESCRIPTION=?, MIN_BALANCE=? WHERE ACCOUNT_ID=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, accountType);
			preparedStatement.setDouble(2, interestRate);
			preparedStatement.setString(3, description);
			preparedStatement.setDouble(4, minimumBalance);
			preparedStatement.setInt(5, accountId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connections.closeConnections(connection);
		}
	}

	public User getModuleAcess(User user) {
		try {

			URL url = null;
			HttpURLConnection httpURLConnection = null;
			BufferedReader bufferedReader = null;
			JSONObject jsonObject = null;
			int deskId = 0;
			String output = null;

			url = new URL(
					"http://103.62.238.195:8080/BankStructServices/rest/ModuleService/getModule?emp_id=" + user.getEmpId());
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept", "application/json");
			if (httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
			}
			bufferedReader = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
			output = bufferedReader.readLine();
			jsonObject = new JSONObject(output);
			deskId = jsonObject.getInt("desk_id");
			user.setDeskId(deskId);
			httpURLConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getModuleServiceAcess(User user) {
		try {

			URL url = null;
			HttpURLConnection httpURLConnection = null;
			BufferedReader bufferedReader = null;
			JSONObject jsonObject = null;
			String output = null;

			url = new URL("http://103.62.238.195:8080/BankStructServices/rest/RightsService/getRights?desk_id="
					+ user.getDeskId() + "&mod=PC");
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept", "application/json");
			if (httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
			}
			bufferedReader = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
			output = bufferedReader.readLine();
			jsonObject = new JSONObject(output);
			if (jsonObject.getInt("put") == 1 && jsonObject.getInt("post") == 1 && jsonObject.getInt("del") == 1) {
				user.setIsAdmin(1);
			}
			httpURLConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
