
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
<title>Search By Branch id</title>
</head>
<body>

	<table class="table table-hover" align="center" style="width: 800px">
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
				String branch = request.getParameter("branch_id");
				int data;
				String checked = request.getParameter("c3");
				if (checked == null) {
					data = 0;
				} else {
					data = Integer.parseInt(checked);
				}
			
				int BRANCH_ID = Integer.parseInt(branch);

				

				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
						"scott", "rbs");

				if (data == 1) {
					Statement statement1 = connection.createStatement();
					Statement statement2 = connection.createStatement();
					Statement statement3 = connection.createStatement();
					Statement statement4 = connection.createStatement();
					Statement statement5 = connection.createStatement();
					Statement statement6 = connection.createStatement();
					Statement statement7 = connection.createStatement();

					ResultSet rs1 = statement1.executeQuery("select * from USER_TABLE");

					
					String state, branchname, deskname, areaname;
					int desk1, branch1, area, employeeid,deskid;
					while (rs1.next()) {
						deskid = rs1.getInt("DESK_ID");
						deskid = deskid%1000;
						deskid = deskid/100;
						
						
						if(deskid==BRANCH_ID)
						{
							employeeid = rs1.getInt(1);
							
							ResultSet rs2 = statement2.executeQuery("select * from USER_TABLE where EMP_ID =" + employeeid);
							if (rs2.next()) {

								if (rs2.getInt(8) == 1) {
									state = "Active";
								}

								else {
									state = "Inactive";
								}
							} else {
								state = "null";
							}
							ResultSet rs3 = statement3
									.executeQuery("select DESK_ID from USER_TABLE where EMP_ID =" + employeeid);
							if (rs3.next()) {

								desk1 = rs3.getInt(1) % 100;
								branch1 = (rs3.getInt(1) % 1000) / 100;
								area = rs3.getInt(1) / 1000;

								if (branch1 == 0) {
									branchname = "Head Office";
								} else {
									ResultSet rs4 = statement4
											.executeQuery("select BRANCH_NAME from USER_BRANCH where BRANCH_ID =" + BRANCH_ID);
									if (rs4.next()) {
										branchname = rs4.getString(1);
									} else {
										branchname = "null";
									}
								}
							} else {
								desk1 = 12;
								area = 0;
								branchname = "null";
							}
							ResultSet rs5 = statement5.executeQuery("select DESK_NAME from USER_DESK where DESK_ID =" + desk1);
							if (rs5.next()) {
								deskname = rs5.getString(1);
							} else {
								deskname = "null";
							}
							ResultSet rs6 = statement6.executeQuery("select AREA_NAME from USER_AREA where AREA_ID =" + area);
							if (rs6.next()) {
								areaname = rs6.getString(1);
							} else {
								areaname = "null";
							}
							ResultSet rs7 = statement7.executeQuery("select * from USER_TABLE where EMP_ID =" + employeeid);
							if (rs7.next()) {
								
			%>

			<tr>
				<td><%=rs7.getInt(1)%></td>
				<td><%=rs7.getString(4)%></td>
				<td><%=rs7.getString(5)%></td>
				<td><%=rs7.getString(6)%></td>
				<td><%=rs7.getString(7)%></td>
				<%
					out.println("<td>" + deskname + "</td>");
									out.println("<td>" + branchname + "</td>");
									out.println("<td>" + areaname + "</td>");
									out.println("<td>" + state + "</td>");
									out.println("</tr>");
									
								}
						}
						
						

						}
					}
				
				else
				{
					
					
					Statement statement1 = connection.createStatement();
					Statement statement2 = connection.createStatement();
					Statement statement3 = connection.createStatement();
					Statement statement4 = connection.createStatement();
					Statement statement5 = connection.createStatement();
					Statement statement6 = connection.createStatement();
					Statement statement7 = connection.createStatement();

					ResultSet rs1 = statement1.executeQuery("select * from USER_TABLE");

					
					String state, branchname, deskname, areaname;
					int desk1, branch1, area, employeeid,deskid;
					while (rs1.next()) {

						deskid = rs1.getInt("DESK_ID");
						deskid = deskid%1000;
						deskid = deskid/100;
						
						if(deskid==BRANCH_ID)
						{
							employeeid = rs1.getInt(1);
							
							ResultSet rs2 = statement2.executeQuery("select * from USER_TABLE where EMP_ID =" + employeeid);
							if (rs2.next()) {

								if (rs2.getInt(8) == 1) {
									state = "Active";
								}

								else {
									state = "Inactive";
								}
							} else {
								state = "null";
							}
							
							if(state== "Active")
							{
								
								ResultSet rs3 = statement3
										.executeQuery("select DESK_ID from USER_TABLE where EMP_ID =" + employeeid);
								if (rs3.next()) {

									desk1 = rs3.getInt(1) % 100;
									branch1 = (rs3.getInt(1) % 1000) / 100;
									area = rs3.getInt(1) / 1000;

									if (branch1 == 0) {
										branchname = "Head Office";
									} else {
										ResultSet rs4 = statement4
												.executeQuery("select BRANCH_NAME from USER_BRANCH where BRANCH_ID =" + BRANCH_ID);
										if (rs4.next()) {
											branchname = rs4.getString(1);
										} else {
											branchname = "null";
										}
									}
								} else {
									desk1 = 12;
									area = 0;
									branchname = "null";
								}
								ResultSet rs5 = statement5.executeQuery("select DESK_NAME from USER_DESK where DESK_ID =" + desk1);
								if (rs5.next()) {
									deskname = rs5.getString(1);
								} else {
									deskname = "null";
								}
								ResultSet rs6 = statement6.executeQuery("select AREA_NAME from USER_AREA where AREA_ID =" + area);
								if (rs6.next()) {
									areaname = rs6.getString(1);
								} else {
									areaname = "null";
								}
								ResultSet rs7 = statement7.executeQuery("select * from USER_TABLE where EMP_ID =" + employeeid);
								if (rs7.next()) {
									
				%>

				<tr>
					<td><%=rs7.getInt(1)%></td>
					<td><%=rs7.getString(4)%></td>
					<td><%=rs7.getString(5)%></td>
					<td><%=rs7.getString(6)%></td>
					<td><%=rs7.getString(7)%></td>
					<%
						out.println("<td>" + deskname + "</td>");
										out.println("<td>" + branchname + "</td>");
										out.println("<td>" + areaname + "</td>");
										out.println("<td>" + state + "</td>");
										out.println("</tr>");
										
									}

		
							}
						}
						
	
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