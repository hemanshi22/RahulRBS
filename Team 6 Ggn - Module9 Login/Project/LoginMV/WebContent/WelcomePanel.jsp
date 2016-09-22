<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSP Directives -->
<%-- Writing Directives <%@ %> --%>
<%@page import="java.io.IOException,java.sql.*"%>
<html>
<body>
<head>
<title>Welcome to ABC Bank</title>

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>





<!-- <link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery.min.js.css"></script>
<script src="bootstrap.min.js.css"></script> -->
</head>
<body>

<div class="row" style="width:100%; height:100%">
<div class="col-sm-3">
	<%-- Writing Scriptlets: <% %> You can write JAVA code within a scriptlet --%>
	</br>
	</br>
	</br>
	</br>
	
		 <%
	int emp = (int) session.getAttribute("emp");
	 
	String Name = (String) session.getAttribute("Name");
	
	out.print("<h4>Name: "+Name+" "+"Employee ID: "+emp+" </h4>" );
	%>
	
	
	
	 </div>
	
	
	
  <div class="col-sm-5" >
<figure>
		<center>
            <img class="img-responsive" src="Photo/ABC_logo.jpg" width="300" height="100" >
        </center>
	</figure>

 </div>
	
		<!-- <table class="table table-hover table-bordered" style="width: 100px; position:absolute;right:0;"> -->
	
       <div class="col-sm-3" style="position:absolute;right:0;">
      
       
		<a class="btn btn-hover btn-info" href="Logout?emp_id=<%= emp %>" target="_top" style="position:absolute;right:0;">
		Logout</a>
		</div>
		
		</div>
	
</body>
</html>
