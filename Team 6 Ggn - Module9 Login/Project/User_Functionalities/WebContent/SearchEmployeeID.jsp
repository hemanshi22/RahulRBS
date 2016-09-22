
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSP Directives -->
<%-- Writing Directives <%@ %> --%>
<%@page import="java.io.IOException,java.sql.*"%>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Employee id</title>
</head>
<body>

	<table class="table table-hover " align="center" style="width: 800px">
		<thead class="thead-default">
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>DOJ</th>
				<th>Desk</th>
				<th>Branch</th>
				<th>Area</th>
				<th>Status</th>
			</tr>
		</thead>
		<%
			try {				
				String employee = request.getParameter("emp_id");
				int data;
				String checked=request.getParameter("c1");
				if(checked==null)
				{
					data=0;
				}
				else
				{
					data=Integer.parseInt(checked);
				}
				
				int EMP_ID = Integer.parseInt(employee);
							
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
						"scott", "rbs");
				
				if(data==1)
				{
					Statement statement = connection.createStatement();
					ResultSet rs1 = statement.executeQuery("select * from USER_TABLE where EMP_ID =" + EMP_ID);
					if(rs1.next())
					{
						
						String state;
						if (rs1.getInt(8) == 1) {
							state = "Active";
						}

						else {
							state = "Inactive";
						}
						
						ResultSet rs2 = statement.executeQuery("select DESK_ID from USER_TABLE where EMP_ID =" + EMP_ID);
						rs2.next();
						
						int desk1 = rs2.getInt(1) % 100;
						
						
						int branch;
						int area;
						String branchname;
						branch = (rs2.getInt(1) % 1000) / 100;
						area = rs2.getInt(1) / 1000;
						

						if (branch == 0) {
							branchname = "Head Office";
						} else {
							ResultSet rs4 = statement.executeQuery("select BRANCH_NAME from USER_BRANCH where BRANCH_ID =" + branch);
							rs4.next();
							branchname = rs4.getString(1);
						}

						
						ResultSet rs3 = statement.executeQuery("select DESK_NAME from USER_DESK where DESK_ID =" + desk1);
						rs3.next();
						String deskname = rs3.getString(1);
						
						ResultSet rs5 = statement.executeQuery("select AREA_NAME from USER_AREA where AREA_ID =" + area);
						rs5.next();
						String areaname = rs5.getString(1);
						ResultSet rs6 = statement.executeQuery("select * from USER_TABLE where EMP_ID =" + EMP_ID);
						rs6.next();
				%>

			<tr>
				<td><%=rs6.getInt(1)%></td>
				<td><%=rs6.getString(4)%></td>
				<td><%=rs6.getString(5)%></td>
				<td><%=rs6.getString(6)%></td>
				<td><%=rs6.getString(7)%></td>
				<%
		 	out.println("<td>" + deskname + "</td>");
		 		out.println("<td>" + branchname + "</td>");
		 		out.println("<td>" + areaname + "</td>");
		 		out.println("<td>" + state + "</td>"); 
		 		out.println("</tr>");
						
					}
					
					else
					{
						String msg = "Employee ID Does not Exist!!";
						request.setAttribute("msg", msg);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
						dispatcher.forward(request, response);
					}
					
					
					
					
					
					
					
				}
				
				else
				{
					
					
					
					Statement statement = connection.createStatement();
					ResultSet rs1 = statement.executeQuery("select * from USER_TABLE where EMP_ID =" + EMP_ID);
					if(rs1.next())
					{
						
						String state;
						if (rs1.getInt(8) == 1) {
							state = "Active";
						}

						else {
							state = "Inactive";
						}
						
						if(state=="Active")
							
						{
						
						
						ResultSet rs2 = statement.executeQuery("select DESK_ID from USER_TABLE where EMP_ID =" + EMP_ID);
						rs2.next();
						
						int desk1 = rs2.getInt(1) % 100;
						int branch;
						int area;
						String branchname;
						branch = (rs2.getInt(1) % 1000) / 100;
						area = rs2.getInt(1) / 1000;
						

						if (branch == 0) {
							branchname = "Head Office";
						} else {
							ResultSet rs4 = statement.executeQuery("select BRANCH_NAME from USER_BRANCH where BRANCH_ID =" + branch);
							rs4.next();
							branchname = rs4.getString(1);
						}

						
						ResultSet rs3 = statement.executeQuery("select DESK_NAME from USER_DESK where DESK_ID =" + desk1);
						rs3.next();
						String deskname = rs3.getString(1);
						
						ResultSet rs5 = statement.executeQuery("select AREA_NAME from USER_AREA where AREA_ID =" + area);
						rs5.next();
						String areaname = rs5.getString(1);
						ResultSet rs6 = statement.executeQuery("select * from USER_TABLE where EMP_ID =" + EMP_ID );
						rs6.next();
				%>
			
			<tr>
				<td><%=rs6.getInt(1)%></td>
				<td><%=rs6.getString(4)%></td>
				<td><%=rs6.getString(5)%></td>
				<td><%=rs6.getString(6)%></td>
				<td><%=rs6.getString(7)%></td>
				<%
		 	out.println("<td>" + deskname + "</td>");
		 		out.println("<td>" + branchname + "</td>");
		 		out.println("<td>" + areaname + "</td>");
		 		out.println("<td>" + state + "</td>"); 
		 		out.println("</tr>");
						
		
						
						}
					}
					
					else
					{
						String msg = "Employee ID Does not Exist!!";
						request.setAttribute("msg", msg);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
						dispatcher.forward(request, response);
					}
					
				
				}
				
		connection.close();	
		
				
 	} catch (ClassNotFoundException e) {
 		System.out.println("Where is your Oracle JDBC Driver?");
 		return;
 	} catch (SQLException s) {
 		s.printStackTrace();
 		return;
 	}
 %>
		
	</table>
<div>
	<form action="User_Home.jsp" method="get">
		<input name="Home" type="submit" value="Home" class="btn btn-info"
			style="float: right; margin-right: 50%;">
	</form>
</div>
</body>

</html>