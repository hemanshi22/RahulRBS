<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.account.model.Article" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Fixed Deposit Creation Page</title>
</head>
<body>
<form name="form" method="get">
<div>
Account Number of the Savings Account:${articles.id} <input class='form-control' type="hidden" value=${articles.id} name="id">
</div>
<div>
 FD interest rate: ${articles.title}<input type="hidden" class='form-control' value= ${articles.title} name="title">
</div>
<div>
Deposit Amount:<input class='form-control' type="text" name="Deposit"  placeholder="Only numeric values">
</div>
<div>
Period of Deposit:<input class='form-control' type="text" name="period"  placeholder="Enter in months"> 
</div>
<div>
Nominee Name:<input type="text" class='form-control' name="nominee">
</div>

<div align="center"><p><input type="submit" class='btn btn-primary' name="commit" value="Submit" onclick="form.action='FD2Servlet';" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-primary' type="submit" name="commit" value="Cancel" onclick="creationFailed();" ></div> 


</form>
</body>
</html>