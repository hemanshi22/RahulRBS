<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Delete Account </title>
</head>
<body>
<form method="post" action="DeleteController">
Account Number: <input type="text" name="accountdelete" class='form-control'><br>
<input type="submit" name="deletesubmit" value="Delete" class='btn btn-primary'>
</form>
<div id="result">
<%PrintWriter out1=response.getWriter(); 


if(request.getAttribute("error")!=null) out1.println(request.getAttribute("error"));
String per= (String)session.getAttribute("per");
out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");
%>

</div>
</body>
</html>
