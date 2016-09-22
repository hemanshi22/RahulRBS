package com.bankstructure.services;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EmpDetailsDao {
	
	
	@SuppressWarnings("unchecked")
	public EmpDetails getEmpDetailsPermissions(int emp_id) throws SQLException {
		
		List<EmpDetails> EmpDetailsList = null;
		
		int area_id = 0;
		String area_name = null;
		
		int branch_id = 0;
		String branch_name = null;
		
		int desk_id1 = 0;
		int desk_id = 0;
		String desk_name = null;
		Connection connection=null;
		Statement statement=null;
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott", "rbs");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM BANK_STRUCTURE WHERE EMP_ID="+emp_id);
			while (rs.next()) {
				desk_id1 = rs.getInt("DESK_ID");
				desk_id = desk_id1%100;
				System.out.println(desk_id);
				area_id = rs.getInt("AREA_ID");
				System.out.println(area_id);
				branch_id = rs.getInt("BRANCH_ID");
				System.out.println(branch_id);
			}
			
			ResultSet rs1 = statement.executeQuery("SELECT * FROM AREA WHERE AREA_ID = "+area_id);
			
			while (rs1.next() ){
				area_name = rs1.getString("AREA_NAME");
				System.out.println(area_name);
			}
			
			ResultSet rs2 = statement.executeQuery("SELECT * FROM BRANCH WHERE BRANCH_ID = "+branch_id);
			
			while (rs2.next() ){
				branch_name = rs2.getString("BRANCH_NAME");
				System.out.println(area_name);
			}
			
			ResultSet rs3 = statement.executeQuery("SELECT * FROM DESK WHERE DESK_ID = "+desk_id);
			
			while (rs3.next() ){
				desk_name = rs3.getString("DESK_NAME");
				System.out.println(desk_name);
			}
		} catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			statement.close();
			connection.close();
		}
		
		

		EmpDetails EmpDetails = new EmpDetails(emp_id, area_id, area_name, branch_id, branch_name, desk_id, desk_name);
		
		try{
			File file=new File("EmpDetails.dat");
				if(!file.exists()) {
					EmpDetailsList = new ArrayList<EmpDetails>();
					EmpDetailsList.add(EmpDetails);
					saveEmpDetailsList(EmpDetailsList);
				}
			else {
				FileInputStream fis=new FileInputStream(file);
				ObjectInputStream ois=new ObjectInputStream(fis);
				EmpDetailsList=((List<EmpDetails>)ois.readObject());
				ois.close();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}

		return EmpDetails;	
	}


	private void saveEmpDetailsList(List<EmpDetails> EmpDetailsList) throws FileNotFoundException{
		try {
			File file=new File("EmpDetails.dat");
			FileOutputStream fos=null;
		    fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(EmpDetailsList);
			oos.close();
			} catch(FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch(IOException e) {
				System.out.println(e.getMessage());
		}
	}
}