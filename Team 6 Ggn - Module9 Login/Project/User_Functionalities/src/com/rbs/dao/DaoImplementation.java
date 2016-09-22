package com.rbs.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rbs.dao.DatabaseConnection;

public class DaoImplementation {

	public int insertUSER_TABLE(String UserId, String UserName, String Phone,  String password,String Email , int finaldesk_id)
			 throws Exception {
				int return1=0;
			// TODO Auto-generated method stub
			try {
				Connection connection = DatabaseConnection.getConnection();
				
				int nextEmpID = getEmployeeIDnext();
				nextEmpID++;
				int finalarea_id = finaldesk_id/1000;
				int finalbranch_id = (finaldesk_id % 1000)/100 ;
				
				String insert1 = "INSERT INTO BANK_STRUCTURE(EMP_ID,AREA_ID,BRANCH_ID,DESK_ID) VALUES(?,?,?,?)";
				PreparedStatement preparedStatement2 = connection.prepareStatement(insert1);
				preparedStatement2.setInt(1, nextEmpID);
				preparedStatement2.setInt(2, finalarea_id );
				preparedStatement2.setInt(3, finalbranch_id);
				preparedStatement2.setInt(4, finaldesk_id);
				preparedStatement2.executeUpdate();
				
				
				
				String insert = "INSERT INTO USER_TABLE(EMP_ID,USER_ID,PASSWORD,NAME,PHONE,EMAIL,ACTIVE,DESK_ID) VALUES(?,?,?,?,?,?,1,?)";
				
				
				PreparedStatement preparedStatement = connection.prepareStatement(insert);
				preparedStatement.setInt(1, nextEmpID);
				preparedStatement.setString(2, UserId);
				preparedStatement.setString(3, password);
				preparedStatement.setString(4, UserName);
				preparedStatement.setString(5, Phone);
				preparedStatement.setString(6, Email);
				preparedStatement.setInt(7, finaldesk_id);
				
				return1 = preparedStatement.executeUpdate();
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return return1;
		}
	
	
	public int getEmployeeIDnext() throws Exception
	{  
		int employeeid = 0;
		try {
			
			Connection connection = DatabaseConnection.getConnection();
			
			String insert = "SELECT MAX(EMP_ID) from USER_TABLE";	
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			employeeid = rs.getInt(1);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeid;
		
	}
	
	
	@SuppressWarnings("unused")
	public int updateDetails(String userPhone, String userName, String userEmail,
			int userActive,int userEmpid,int finaldesk_id,int final_areaid,int final_branchid) throws Exception {
		// TODO Auto-generated method stub
		int return1 = 0;
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			String update = "UPDATE USER_TABLE SET NAME=?, PHONE=?, EMAIL=?, ACTIVE=?,DESK_ID=? WHERE EMP_ID=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userPhone);
			preparedStatement.setString(3, userEmail);
			preparedStatement.setInt(4, userActive);
			preparedStatement.setInt(5, finaldesk_id);
			preparedStatement.setInt(6, userEmpid);
			
			return1 = preparedStatement.executeUpdate();
			
			
			String update1 = "UPDATE BANK_STRUCTURE SET AREA_ID=?, BRANCH_ID=?, DESK_ID=? WHERE EMP_ID=? ";
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(update1);
			preparedStatement2.setInt(1, final_areaid);
			preparedStatement2.setInt(2, final_branchid );
			preparedStatement2.setInt(3, finaldesk_id);
			preparedStatement2.setInt(4, userEmpid);
			preparedStatement2.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return return1;
	}
	
	
	
	public int emailduplicacy(String email) throws Exception {
		// TODO Auto-generated method stub
		int return3 = 0;
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			String update = "SELECT COUNT(EMAIL) FROM USER_TABLE WHERE EMAIL = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			return3 = rs.getInt(1);
			
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return return3;
	}
	
	public int useridduplicacy(String userid ) throws Exception {
		// TODO Auto-generated method stub
		int return4 = 0;
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			String update = "SELECT COUNT(USER_ID) FROM USER_TABLE WHERE USER_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, userid);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			return4= rs.getInt(1);
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return return4;
	}
	
	
	
	
}
