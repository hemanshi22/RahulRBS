package com.bankstructure.services;

import java.io.*;
import java.sql.*;
import java.util.*;

public class RightsDao {

	@SuppressWarnings("unchecked")

	// Define Rights Permission Function

	public Rights getRightsPermissions(int desk_id, String mod) throws SQLException {

		List<Rights> rightsList = null;

		int get = 0, put = 0, post = 0, del = 0, fin_lim = 0;
		String getparam = null, putparam = null, postparam = null, delparam = null;
		Connection connection = null;
		Statement statement = null;
		try {
			System.out.println("Inside Try");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");
			System.out.println("Connected");
			statement = connection.createStatement();

			mod = mod.toUpperCase();
			// getting access rights(get,put,post,delete) permission based on
			// desk id and module being accessed
			ResultSet rs1 = statement.executeQuery(
					"SELECT * FROM SERVICE_RIGHTS WHERE DESK_ID = '" + desk_id + "' AND MODULE = '" + mod + "'");

			while (rs1.next()) {
				get = (rs1.getInt("GET"));
				put = (rs1.getInt("PUT"));
				post = (rs1.getInt("POST"));
				del = (rs1.getInt("DEL"));
				fin_lim = (rs1.getInt("FIN_LIM"));
				getparam = (rs1.getString("GETPARAM"));
				putparam = (rs1.getString("PUTPARAM"));
				postparam = (rs1.getString("POSTPARAM"));
				delparam = (rs1.getString("DELPARAM"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}

		Rights rights = new Rights(desk_id, mod, get, put, post, del, fin_lim, getparam, putparam, postparam, delparam);

		try {
			File file = new File("Rights.dat");
			if (!file.exists()) {
				rightsList = new ArrayList<Rights>();
				rightsList.add(rights);
				saveRightsList(rightsList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				rightsList = ((List<Rights>) ois.readObject());
				ois.close();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return rights;
	}

	private void saveRightsList(List<Rights> rightsList) throws FileNotFoundException {
		try {
			File file = new File("Rights.dat");
			FileOutputStream fos = null;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(rightsList);
			oos.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}