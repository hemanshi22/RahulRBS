package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection getConnection()throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	return DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb","scott","rbs");
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@122.162.81.201:1521:orcl","varun","varun");*/
	}
}
