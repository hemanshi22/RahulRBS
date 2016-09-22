package com.j2ee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao1 {
	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");

			PreparedStatement ps = con.prepareStatement("select * from USER_TABLE where user_id=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int getEmpid(String name, String pass) {
		int emp = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");

			PreparedStatement ps = con
.prepareStatement("select emp_id from USER_TABLE where user_id=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			rs.next();
			emp = rs.getInt(1);

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return emp;

	}

	public static String getEmpName(String name, String pass) {

		String Name = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");

			PreparedStatement ps = con.prepareStatement("select name from USER_TABLE where user_id=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			rs.next();

			Name = rs.getString(1);
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return Name;

	}

}