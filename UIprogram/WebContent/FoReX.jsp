<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forex Account</title>
</head>
<body>
<form name="forex" method="get">
<div>
Enter CIF number: <input class='form-control' type="text" id="forex" name="cif"  placeholder="Enter valid CIF">
</div>
<div>
<input type="submit" value="Check" class='btn btn-primary'  onclick="form.action='ForexAccountServlet';">
</div>
</form>

</body>
</html>