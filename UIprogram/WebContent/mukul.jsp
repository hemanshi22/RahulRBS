<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
form{
display: inline-block;
}
</style>
</head>
<body style="margin-top:100px;">
<center>
<div class="page-header" style="margin-top:-75px;" >
<h1>Account Module</h1>
</div>
<%
String var=(String)request.getAttribute("case");
int per=Integer.parseInt(request.getParameter("per"));
System.out.println(per);
if(per==1111){
out.println("<form method='type' action='Create.html' >");
out.println("<input type='submit' name='b1' value='create' class='btn btn-primary''><p>");
out.println("</form>");
out.println("<form method='type' action='Update.html'>");
out.println("<input type='submit' name='b1' value='update' class='btn btn-primary'><p>");
out.println("</form>");
out.println("<form method='type' action='Delete.html'>");
out.println("<input type='submit' name='b1' value='delete' class='btn btn-primary'><p>");
out.println("</form>");
out.println("<form method='type' action='Search.html'>");
out.println("<input type='submit' name='b1' value='search' class='btn btn-primary'><p>");
out.println("</form>");}
else if(per==1000){
	out.println("<form method='type' action='Create.html'>");
out.println("<input type='submit' name='b1' value='create' class='btn btn-primary'><p>");
out.println("</form>");
out.println("<form method='type' action='Update.html'>");
out.println("<input type='submit' name='b1' value='update' disabled='disabled' class='btn btn-primary'><p>");
out.println("</form>");
out.println("<form method='type' action='Delete.html'>");
out.println("<input type='submit' name='b1' value='delete' disabled='disabled' class='btn btn-primary'><p>");
out.println("</form>");
out.println("<form method='type' action='Search.html'>");
out.println("<input type='submit' name='b1' value='search' disabled='disabled' class='btn btn-primary'><p>");
out.println("</form>");}
else
{
	out.println("<form method='type' action='Create.html'>");
	out.println("<input type='submit' name='b1' value='create' disabled='disabled' class='btn btn-primary'><p>");
	out.println("</form>");
	out.println("<form method='type' action='Update.html'>");
	out.println("<input type='submit' name='b1' value='update' disabled='disabled' class='btn btn-primary'><p>");
	out.println("</form>");
	out.println("<form method='type' action='Delete.html'>");
	out.println("<input type='submit' name='b1' value='delete' disabled='disabled' class='btn btn-primary'><p>");
	out.println("</form>");
	out.println("<form method='type' action='Search.html'>");
	out.println("<input type='submit' name='b1' value='search' disabled='disabled' class='btn btn-primary'><p>");
	out.println("</form>");
}
%>
</center>
</body>
</html>