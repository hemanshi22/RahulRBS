package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		long accountnumber=Integer.parseInt(request.getParameter("accountdelete"));
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");  
	    out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
	    
		out.println("</head>");	  
		out.println("<body>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb","scott","rbs");
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:8080:rbsdb","admin","rbs");
			
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from ACCOUNT_DETAILS where ACC_NO=" + accountnumber);
			if(rs.next()==false)
			{
//				response.setContentType("text/html");  
//				out.println("<script type=\"text/javascript\">");  
//				out.println("alert('Wrong Account Number Entered.');");  
//				out.println("else    window.location.reload();" );
//				out.println("</script>");
				request.setAttribute("error", "Account Number does not exist.");
				RequestDispatcher d=request.getRequestDispatcher("delete.jsp");
				d.forward(request, response);
				
				
			}
			ResultSet rs1=statement.executeQuery("update ACCOUNT_DETAILS set ARCHIVED_STATUS=1 where ACC_NO=" + accountnumber);
			if(rs1.next()==true)
			{
				request.setAttribute("error", "Account deleted successfully");
				RequestDispatcher d=request.getRequestDispatcher("delete.jsp");
				d.forward(request, response);
			}
			
		}catch (
				ClassNotFoundException e)
				{
					System.out.println("Where is your Oracle JDBC Driver?");
					return;
				} catch (
				SQLException s)
				{
					System.out.println("Connection Failed! Check output console");
					return;
				}
	}

}
