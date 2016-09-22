
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSP Directives -->
<%-- Writing Directives <%@ %> --%>
<%@page import="java.io.IOException,java.sql.*"%>
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery.min.js.css"></script>
<script src="bootstrap.min.js.css"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Employee id</title>
</head>
<body>

	<table class="table table-striped" align="center"
		style="width: 800px">
	
		<%
			try {				
				
				
				String employee = request.getParameter("emp_id");
				
				int EMP_ID = Integer.parseInt(employee);
							
				Class.forName("oracle.jdbc.driver.OracleDriver");
		
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
						"scott", "rbs");
				
				
					Statement statement = connection.createStatement();
					ResultSet rs1 = statement.executeQuery("select * from USER_TABLE where EMP_ID =" + EMP_ID);
					if(rs1.next())
					{
					
					if (rs1.getInt(8) == 1) {
				ResultSet rs2=statement.executeQuery("UPDATE USER_TABLE SET ACTIVE=0 WHERE EMP_ID="+ EMP_ID);
				 
				
				
					String msg = "User Successfully Deleted";
					request.setAttribute("msg", msg);
						
					RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
					dispatcher.forward(request, response);
					
					}

					else {

						String msg = "Unsuccessful!!!";
						request.setAttribute("msg", msg);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
						dispatcher.forward(request, response);
						
						} 
					}		
					
					else
					{
						String msg = "Employee ID Does not Exist!!";
						request.setAttribute("msg", msg);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
						dispatcher.forward(request, response);
					}
					
				connection.close();
				
			}
		
		catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			return;
		} catch (SQLException s) {
			s.printStackTrace();
			return;
		}
	

			      
		
 %>
		
	</table>
</body>

</html>