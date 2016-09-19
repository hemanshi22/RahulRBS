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
<body align="center" height="100px">
<center>
	<div class='success'>
		<%
			ArrayList<Transaction> resultSet = (ArrayList<Transaction>) request.getAttribute("resultSet");
			if (resultSet != null) {
				out.println("<table border=1>");
				out.println("</br></br></br></br></br></br></br></br>");
				for (Transaction arr : resultSet) {
					out.println("  <tr>  <td width='100'>  " + arr.getTransactionId() + "</td>  <td width='100'>   " + arr.getTransactionDate()
							+ "  </td>  <td width='100'>  " + arr.getTransactionFrom() + "</td>  <td width='100'>   " + arr.getTransactionFromType()
							+ "  </td>  <td width='100'> " + arr.getTransactionTo() + "</td>  <td width='100'>   " + arr.getTransactionToType()
							+ "  </td>  <td width='100'> " + arr.getAmount() + "  </td>  <td width='100'> " + arr.getAccountType() + "  </td>  </tr>");
				}
				out.println("</table>");
			}
		%>
	</div>
	</center>
</body>
</html>