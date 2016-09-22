<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.rbs.login.UserDetails, java.io.IOException, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%
		UserDetails update = (UserDetails) request.getAttribute("update");
	%>


	<div class="panel-body">
	
	<h1 class="display-4 " style="text-align: left; margin-left: 125px; ">User Updation Form</h1>
		

		<form class="form-horizontal" action="UpdateUser" method="post">
			<div class="form-group">
				<label for="userEmpid" class="control-label col-xs-2">User
					Employee ID</label>
				<div class="col-xs-10">
					<input type="number" class="form-control" name="userEmpid"
						style="width: 30%" id="userEmpid" readonly required
						value=<%=update.getuserEmpid()%>>
				</div>
			</div>


			<div class="form-group">
				<label for="userName" class="control-label col-xs-2">User
					Name</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="userName"
						style="width: 30%" id="userName" required
						value=<%=update.getuserName()%>>
				</div>
			</div>

			<div class="form-group">
				<label for="userPhone" class="control-label col-xs-2">Phone
					Number</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="userPhone"
						style="width: 30%" id="userPhone" required
						value=<%=update.getuserPhone()%>>
				</div>
			</div>

			<div class="form-group">
				<label for="userActive" class="control-label col-xs-2">User
					Active</label>
				<div class="col-xs-10">
					<input type="number" class="form-control" name="userActive"
						style="width: 30%" id="userActive" required min="0" max="1"
						value=<%=update.getuserActive()%>>
				</div>
			</div>


			<div class="form-group">
				<label for="userEmail" class="control-label col-xs-2">Email</label>
				<div class="col-xs-10">
					<input type="email" class="form-control" name="userEmail"
						style="width: 30%" id="userEmail" required
						value=<%=update.getuserEmail()%>>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">Area</label>
				<div class="col-xs-10">
					<select name="area_id" class="form-control" style="width: 30%">
						<option value="0">Head Office</option>
						<option value="1">Zone 1</option>
						<option value="2">Zone 2</option>

					</select>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-xs-2">Branch</label>
				<div class="col-xs-10">
					<select name="branch_id" class="form-control" style="width: 30%">
						<option value="0">Head Office</option>
						<option value="1">Branch 1</option>
						<option value="2">Branch 2</option>
						<option value="3">Central Processing Center</option>

					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">Desk</label>
				<div class="col-xs-10">
					<select name="desk_id" class="form-control" style="width: 30%">
						<option value="1">Teller</option>
						<option value="2">Sales</option>
						<option value="3">Service</option>
						<option value="4">Manager</option>
						<option value="5">Loan Maker</option>
						<option value="6">Loan checker</option>
						<option value="7">Liabilities Maker</option>
						<option value="8">Liabilities checker</option>
						<option value="9">Record Management Maker</option>
						<option value="10">Record Management Checker</option>
						<option value="11">Reporting</option>
						<option value="12">Country Reporting</option>
						<option value="13">Country Admin Maker</option>
						<option value="14">Country Admin Checker</option>

					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<button type="submit" class="btn btn-primary">Update
						details</button>


				</div>
			</div>



		</form>
		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">

				<form action="User_Home.jsp" method="get">
					<input name="Home" type="submit" value="Home"
						class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
</body>
</html>