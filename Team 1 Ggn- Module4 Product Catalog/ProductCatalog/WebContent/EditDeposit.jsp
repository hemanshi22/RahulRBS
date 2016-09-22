<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.catalog.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><title>Edit Loan</title>
</head>
<body>

	<%
		Deposits deposit = (Deposits) request.getAttribute("deposit");
	%>
	<div class="panel-body">
		<h3 style="margin-top: 20px; margin-left: 250px">Edit Deposit</h3>
		<br /> <br />

		<form class="form-horizontal" action="EditDeposit" method="post">
			<div class="form-group">
				<label for="depositId" class="control-label col-xs-2">Deposit ID</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="depositId"
						style="width: 30%" id="depositId"
						value=<%=deposit.getDepositId()%> readonly="readonly" required>
				</div>
			</div>
			
			<div class="form-group">
				<label for="depositType" class="control-label col-xs-2">Type
					of Loan</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="depositType"
						style="width: 30%" id="depositType"
						value="<%=deposit.getDepositType()%>" required>
				</div>
			</div>

			<div class="form-group">
				<label for="interestRate" class="control-label col-xs-2">Interest
					Rate</label>
				<div class="col-xs-10">
					<input type="number" step="0.01" class="form-control"
						name="interestRate" style="width: 30%" id="interestRate"
						value=<%=deposit.getInterestRate()%> required>
				</div>
			</div>

			<div class="form-group">
				<label for="description" class="control-label col-xs-2">Description</label>
				<div class="col-xs-10">
					<textarea rows="8" cols="50" class="form-control"
						name="description" style="width: 30%;vertical-align: middle" id="description" required> <%=deposit.getDescription() %></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="minimumBalance" class="control-label col-xs-2">Maximum
					Duration</label>
				<div class="col-xs-10">
					<input type="number" class="form-control" name="maximumDuration"
						style="width: 30%" id="maximumDuration" value=<%=deposit.getMaximumDuration() %> required>
				</div>
			</div>
			<div class="form-group">
				<span class="col-xs-3"></span>
				<div class="col-xs-9">
					<input name="Add" type="submit" value="Update"
						class="btn btn-primary " style="width: 10%">
				</div>
			</div>
	</div>
	</form>



	</div>
</body>
</html>