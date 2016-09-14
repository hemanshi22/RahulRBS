<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="rbs.module.transaction.model.Transaction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body align="center">
	<div class='well'>

		<%
			ArrayList<Transaction> resultSet = (ArrayList<Transaction>) request.getAttribute("resultSet");
			if (resultSet != null) {
				out.println("<table border=1>");
				for (Transaction arr : resultSet) {
					out.println("<tr><td>" + arr.getTransactionId() + "</td><td> " + arr.getTransactionDate()
							+ "</td><td> " + arr.getTransactionFrom() + "</td><td> " + arr.getTransactionFromType()
							+ "</td><td> " + arr.getTransactionTo() + "</td><td> " + arr.getTransactionToType()
							+ "</td><td> " + arr.getAmount() + "</td><td> " + arr.getAccountType() + "</td></tr>");

				}
				out.println("</table>");
			}
		%>
	</div>
</body>
</html>