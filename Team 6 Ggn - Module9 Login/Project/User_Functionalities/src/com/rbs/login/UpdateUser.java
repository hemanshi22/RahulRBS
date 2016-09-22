package com.rbs.login;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rbs.dao.DaoImplementation;

import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeID = Integer.parseInt(request.getParameter("emp_id"));
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott",
					"rbs");
			
			String insert = "SELECT * FROM USER_TABLE WHERE EMP_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, employeeID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				UserDetails update = new UserDetails();
				
				update.setuserName(resultSet.getString(4));
				update.setuserPhone(resultSet.getString(5));
				update.setuserEmail(resultSet.getString(6));
				update.setuserActive(resultSet.getInt(8));
				update.setuserEmpid(employeeID);
				update.setuserDeskid(resultSet.getInt(9));
				
				String msg = "";
				request.setAttribute("msg", msg);
				
				request.setAttribute("update", update);
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUser.jsp");
				dispatcher.forward(request, response);
				connection.close();
				
			}
			
			else
			{
				String msg = "Employee ID Does not Exist!!";
				request.setAttribute("msg", msg);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
				dispatcher.forward(request, response);
			}
			
			
			
	
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userPhone = request.getParameter("userPhone");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		int userActive = Integer.parseInt(request.getParameter("userActive"));
		int userEmpid = Integer.parseInt(request.getParameter("userEmpid"));
		
		
		int area_id = Integer.parseInt(request.getParameter("area_id"));
		int branch_id = Integer.parseInt(request.getParameter("branch_id"));
		int desk_id = Integer.parseInt(request.getParameter("desk_id"));
		
		int finaldesk_id = area_id*1000 + branch_id*100 + desk_id;
		int return1 = 0;
		DaoImplementation dao=new DaoImplementation();
		
		
		try {
			return1 = dao.updateDetails(userPhone, userName, userEmail, userActive,userEmpid,finaldesk_id,area_id,branch_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // call insert method
		
		if (return1 == 1) {
			String msg = "User Successfully Updated";
			request.setAttribute("msg", msg);
		} else {
			String msg = "Error in User Updation";
			request.setAttribute("msg", msg);

		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
		dispatcher.forward(request, response);
	}

	
	
	
}
