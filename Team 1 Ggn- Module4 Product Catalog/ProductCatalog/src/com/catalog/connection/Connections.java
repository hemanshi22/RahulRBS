package com.catalog.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static Connection getConnections(){
		Connection connection =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection =  DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott",
					"rbs"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnections(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
