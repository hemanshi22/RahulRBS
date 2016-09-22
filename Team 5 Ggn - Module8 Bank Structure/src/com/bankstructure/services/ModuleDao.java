package com.bankstructure.services;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ModuleDao {

	@SuppressWarnings({ "unchecked" })
	public Module getModulePermissions(int emp_id) throws SQLException {

		List<Module> moduleList = null;
		int desk_id = 0;

		System.out.println("Inside DAO");
		Connection connection = null;
		Statement statement = null;
		int desk_ids = 0;
		
		// cm = customer management module
		// rd = reference data module
		// rm = record management module
		// pc = product catalog
		// ao = account opening
		// tml = tranasaction management-loans
		// tmtd = transaction management-term deposit
		// tmsa = transaciton management-savings account
		// r= reporting
		// la = login and authentication
		
		int cm = 0,
			rd = 0,
			rm = 0,
			pc = 0,
			ao = 0,
			tml = 0,
			tmtd = 0,
			tmsa = 0,
			r = 0,
			la = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM BANK_STRUCTURE WHERE EMP_ID=" + emp_id);
			//obtaining the desk of the employee
			while (resultSet.next()) {
				desk_ids = resultSet.getInt("DESK_ID");

			}

			desk_id = desk_ids % 100;

			// checking for the modules whose access is allowed to a particular
			// employee(based on his desk-id)
			ResultSet res = statement.executeQuery("SELECT * FROM MODULE_PERMISSION WHERE DESK_ID=" + desk_id);
			//cm = 1 if employee has customer management module access and 0 otherwise
			while (res.next()) {
				cm = (res.getInt("CM"));
				rd = (res.getInt("RD"));
				rm = (res.getInt("RM"));
				pc = (res.getInt("PC"));
				ao = (res.getInt("AO"));
				tml = (res.getInt("TML"));
				tmtd = (res.getInt("TMTD"));
				tmsa = (res.getInt("TMSA"));
				r = (res.getInt("R"));
				la = (res.getInt("LA"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}

		Module module = new Module(desk_id, cm, rd, rm, pc, ao, tml, tmtd, tmsa, r, la);

		try {
			File file = new File("Modules_10.dat");
			if (!file.exists()) {
				moduleList = new ArrayList<Module>();
				moduleList.add(module);
				saveModuleList(moduleList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				moduleList = ((List<Module>) ois.readObject());
				ois.close();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return module;
	}

	private void saveModuleList(List<Module> moduleList) throws FileNotFoundException {
		try {
			File file = new File("Modules_10.dat");
			FileOutputStream fos = null;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(moduleList);
			oos.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
}