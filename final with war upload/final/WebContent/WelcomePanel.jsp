<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSP Directives -->
<%-- Writing Directives <%@ %> --%>
<%@page import="java.io.IOException,java.sql.*"%>
<html>
<body>
<head>
<title>Welcome to ABC Bank</title>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery.min.js.css"></script>
<script src="bootstrap.min.js.css"></script>
</head>
<body>
<figure>
		<center>
            <img src="abc.png" width="100" height="100" />
        </center>
	</figure>

	<%-- Writing Scriptlets: <% %> You can write JAVA code within a scriptlet --%>
	<%
		try {	
			int emp=1;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
					"scott", "rbs");
			Statement statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("select NAME from USER_TABLE where EMP_ID =" + emp);
			rs1.next();
			String empname=rs1.getString(1);
			ResultSet rs2 = statement.executeQuery("select DESK_ID from BANK_STRUCTURE where EMP_ID =" + emp);
			rs2.next();
			int desk1=rs2.getInt(1)%100;
			ResultSet rs3 = statement.executeQuery("select DESK_NAME from DESK where DESK_ID =" + desk1);
			rs3.next();
			String deskname=rs3.getString(1);
			out.println("<center><h2>"+deskname+" Desk</h2></center>");
			out.println("<center><h3>Welcome "+empname+"</h3></center>");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		}
	%>
</body>
</html>
