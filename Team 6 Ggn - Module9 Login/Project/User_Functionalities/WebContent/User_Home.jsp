<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User Management</title>
</head>
<body>

	<div class="container">


		<h1 style="text-align: center">User Management</h1>
		<p></p>



		<div class="container">
			<ul class="nav nav-pills" style="margin-top: 25px">
				<li class="active"><a data-toggle="pill" href="#home"
					onclick="document.getElementById('msgid').innerHTML = ''">Home</a></li>
				<li><a data-toggle="pill" href="#menu1">Search</a></li>
				<li><a data-toggle="pill" href="#menu2">Create</a></li>
				<li><a data-toggle="pill" href="#menu3">Update</a></li>
				<li><a data-toggle="pill" href="#menu4">Delete</a></li>
			</ul>
			<div class="tab-content" style="margin-top: 30px">
				<div id="home" class="tab-pane fade in active">
					<h3>Home</h3>
					<hr>
					<p class="lead">Welcome to User Management. It enables you to
						Search for Users, Create and enable new Users and update, edit and
						Archive User Information.</p>

					<span id="msgid"><p class="lead text-danger">${msg}</p></span>

				</div>

				<div id="menu1" class="tab-pane fade">
					<h3>User Search</h3>
					<hr>

					<p >Search For an User in the User Database based
						on the Employee ID, User Type or Branch Type.</p>
					<p >You can choose to include Archived (Inactive)
						employees as well as the Active ones.</p>


					<div class="panel-group" id="accordion" style="margin-top: 20px">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1">Search By Employee ID</a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse">
								<div class="panel-body">

									

									<form class="form-horizontal" action="SearchEmployeeID.jsp"
										method="post">

										<div class="form-group">
											<label for="emp_id" class="control-label col-xs-2">Employee
												ID:</label>
											<div class="col-xs-10">
												<input type="number" class="form-control" name="emp_id"
													style="width: 30%" id="emp_id" required>
											</div>
										</div>


										<label for="c1" class="control-label col-xs-2">Include
											Archived Records:</label>
										<div class="checkbox-primary">
											<input type="checkbox" name="c1" id="c1"
												style="margin-left: 6px;" value=1>

										</div>


										<div class="form-group">
											<div class="col-xs-offset-2 col-xs-10">
												<button name="searchsubmit" type="submit"
													class="btn btn-primary" style="float: right;">Search</button>


											</div>
										</div>


									</form>
								</div>

							</div>
						</div>
						<div class="panel panel-danger">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse2">Search By Desk Type</a>
								</h4>
							</div>
							<div id="collapse2" class="panel-collapse collapse">
								<div class="panel-body">
									
									<form action="SearchDeskID.jsp" method="post">
										<div class="form-group">
											<label class="control-label col-xs-2">Desk</label>
											<div class="col-xs-10">
												<select name="desk_id" class="form-control"
													style="width: 30%">
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


										<label for="c2" class="control-label col-xs-2">Include
											Archived Records:</label>
										<div class="checkbox-primary">
											<input type="checkbox" name="c2" id="c2"
												style="margin-left: 15px;" value=1>

										</div>


										<div class="form-group">
											<div class="col-xs-offset-2 col-xs-10">
												<button name="searchsubmit" type="submit"
													class="btn btn-primary" style="float: right;">Search</button>


											</div>
										</div>

									</form>

								</div>

							</div>
						</div>
						<div class="panel panel-success">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3">Search By Branch Type</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse">
								<div class="panel-body">
									
									<form action="SearchBranchID.jsp" method="post">

										<div class="form-group">
											<label class="control-label col-xs-2">Branch</label>
											<div class="col-xs-10">
												<select name="branch_id" class="form-control"
													style="width: 30%">
													<option value="0">Head Office</option>
													<option value="1">Branch 1</option>
													<option value="2">Branch 2</option>
													<option value="3">Central Processing Center</option>

												</select>
											</div>
										</div>



										<label for="c3" class="control-label col-xs-2">Include
											Archived Records:</label>
										<div class="checkbox-primary">
											<input type="checkbox" name="c3" id="c3"
												style="margin-left: 15px;" value=1>

										</div>


										<div class="form-group">
											<div class="col-xs-offset-2 col-xs-10">
												<button name="searchsubmit" type="submit"
													class="btn btn-primary" style="float: right;">Search</button>


											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<br />
					</div>
				</div>


				<div id="menu2" class="tab-pane fade">
					<h3>User Creation:</h3>
					<hr>

					<p class="lead">Enter all the relevant User information to
						create and enable a new User.</p>


					<div class="panel-group" id="accordion1" style="margin-top: 20px">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion1"
										href="#collapse4">User Creation Form</a>
								</h4>
							</div>
							<div id="collapse4" class="panel-collapse collapse in">
								<div class="panel-body">





									<form class="form-horizontal" action="CreateUser" method="post">
										<div class="form-group">
											<label for="userID" class="control-label col-xs-2">User
												ID</label>
											<div class="col-xs-10">
												<input type="text" class="form-control" name="UserId"
													style="width: 30%" placeholder="Enter User ID" id="userID"
													required>
											</div>
										</div>


										<div class="form-group">
											<label for="UserName" class="control-label col-xs-2">User
												Name</label>
											<div class="col-xs-10">
												<input type="text" class="form-control" name="UserName"
													style="width: 30%" placeholder="Enter User Name"
													id="UserName" required>
											</div>
										</div>

										<div class="form-group">
											<label for="Phone" class="control-label col-xs-2">Phone
												Number</label>
											<div class="col-xs-10">
												<input type="text" class="form-control" name="Phone"
													style="width: 30%" placeholder="Enter phone number"
													id="Phone" required>
											</div>
										</div>



										<div class="form-group">
											<label for="password" class="control-label col-xs-2">Password</label>
											<div class="col-xs-10">
												<input type="password" class="form-control" name="password"
													style="width: 30%" id="password" placeholder="Password">
											</div>
										</div>

										<div class="form-group">
											<label for="email" class="control-label col-xs-2">Email</label>
											<div class="col-xs-10">
												<input type="email" class="form-control" name="email"
													style="width: 30%" placeholder="Enter Email" id="email"
													required>
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-xs-2">Area</label>
											<div class="col-xs-10">
												<select name="area_id" class="form-control"
													style="width: 30%">
													<option value="0">Head Office</option>
													<option value="1">Zone 1</option>
													<option value="2">Zone 2</option>

												</select>
											</div>
										</div>


										<div class="form-group">
											<label class="control-label col-xs-2">Branch</label>
											<div class="col-xs-10">
												<select name="branch_id" class="form-control"
													style="width: 30%">
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
												<select name="desk_id" class="form-control"
													style="width: 30%">
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
												<button type="submit" class="btn btn-primary">Add
													User</button>
											</div>
										</div>
									</form>

								</div>
							</div>
						</div>


					</div>
				</div>


				<div id="menu3" class="tab-pane fade">
					<h3>User Updation:</h3>
					<hr>

					<p class="lead">Here all User Information (barring the Employee
						ID) for any given user in the Organization can be modified.</p>


					<div class="panel-group" id="accordion2" style="margin-top: 20px">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion2"
										href="#collapse8"> Employee ID</a>
								</h4>
							</div>
							<div id="collapse8" class="panel-collapse collapse in">
								<div class="panel-body">
									<p style="margin-top: 20x">Enter Employee ID of user, whose
										information to be modified</p>


									<form class="form-horizontal" action="UpdateUser" method="get">

										<div class="form-group">
											<label for="emp_id" class="control-label col-xs-2">Employee
												ID:</label>
											<div class="col-xs-10">
												<input type="number" class="form-control" name="emp_id"
													style="width: 30%" id="emp_id" required>
											</div>
										</div>


										<div class="form-group">
											<div class="col-xs-offset-2 col-xs-10">
												<button name="updatesubmit" type="submit"
													class="btn btn-primary" style="float: right;">Update
													User</button>


											</div>
										</div>
									</form>

								</div>
							</div>
						</div>

						<br />
					</div>
				</div>


				<div id="menu4" class="tab-pane fade">
					<h3>User Deletion:</h3>
					<hr>

					<p class="lead">Deleting a user here, renders the user inactive
						and Archives all user information:</p>


					<div class="panel-group" id="accordion2" style="margin-top: 20px">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion3"
										href="#collapse9"> Employee ID</a>
								</h4>
							</div>
							<div id="collapse9" class="panel-collapse collapse in">
								<div class="panel-body">
									<p style="margin-top: 20x">Enter Employee ID of user to be
										deleted</p>



									<form class="form-horizontal" action="DeleteEmployeeID.jsp"
										method="post">

										<div class="form-group">
											<label for="emp_id" class="control-label col-xs-2">Employee
												ID:</label>
											<div class="col-xs-10">
												<input type="number" class="form-control" name="emp_id"
													style="width: 30%" id="emp_id" required>
											</div>
										</div>


										<div class="form-group">
											<div class="col-xs-offset-2 col-xs-10">
												<button name="updatesubmit" type="submit"
													class="btn btn-primary" style="float: right;">Delete
													User</button>


											</div>
										</div>
									</form>


								</div>
							</div>
						</div>

						<br />
					</div>
				</div>
</body>
</html>