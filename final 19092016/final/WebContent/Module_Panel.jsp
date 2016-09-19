<%@page import="java.io.PrintWriter"%>
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

	<%-- Writing Scriptlets: <% %> You can write JAVA code within a scriptlet --%>
	<%
		try {
			System.out.println("1");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
					"scott", "rbs");
			System.out.println("2");
			int desk = 1;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select*from MODULE_PERMISSION where DESK_ID =" + desk);
			System.out.println("3");
			System.out.println("INSIDE DB");
			int i = 0;
			System.out.println(desk);
			int cm, rd, rm, pc, ao, tml, tmtd, tmsa, r, la;

			resultSet.next();
			cm = resultSet.getInt(2);
			rd = resultSet.getInt(3);
			rm = resultSet.getInt(4);
			pc = resultSet.getInt(5);
			ao = resultSet.getInt(6);
			tml = resultSet.getInt(7);
			tmtd = resultSet.getInt(8);
			tmsa = resultSet.getInt(9);
			r = resultSet.getInt(10);
			la = resultSet.getInt(11);
			out.println(
					"<table class=\"table table-hover table-bordered\" align=\"center\"style=\"width: 800px\">");
			out.println("<div align=\"center\">");
			if (cm == 1) {
				out.println("<tr>");
				out.println("<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Customer Management</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}

			if (rd == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Reference Data</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (rm == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Record Management</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (pc == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Product Catalogue</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (ao == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Account Opening</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (tml == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Transaction Management (Loans)</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (tmtd == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Transaction Management (Term Deposit)</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (tmsa == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Transaction Management (Savings Account)</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (r == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>Reporting Tool</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}
			
			if (la == 1) {
				out.println("<tr>");
				out.println(
						"<button style=\"width:100%;height:10%;\" class=\"btn btn-hover btn-info\">");
				out.println("<div>User Management</div>");
				out.println("</button>");
				out.println("</tr>");
				out.println("<br>");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		}
	%>


	</div>
	</table>
</body>
</html>
