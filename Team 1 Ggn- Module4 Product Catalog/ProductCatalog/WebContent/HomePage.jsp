<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Product Catalog</title>

</head>
<body ng-app="myApp" ng-controller="myCtrl">

	<div class="fluid-ontainer">
		

		<div class="jumbotron">
		<c:if test="${user.isAdmin==1}">

			<h3><span style="float:right; margin-right:30px" class="label label-default">Administrator Login</span></h3>
			</c:if>
		  <h1 style="margin-left:75px">Product Catalog</h1>
		  
		  <p style="margin-left:75px">All the services provided by the Bank are listed here.</p>
		</div>		
		
		<div class="container">
		<div id="tabs">
				<ul class="nav nav-tabs">
					<li ng-repeat="tab in tabs"
						ng-class="{active:isActiveTab(tab.url)}"
						ng-click="onClickTab(tab)"><a
							class="btn btn-link">{{tab.title}}</a></li>
				</ul>
				<div id="mainView">
					<div ng-include="currentTab"></div>
				</div>

			</div>

			<div class="tab-content" style="margin-top: 30px">

				<script type="text/ng-template" id="one.tpl.html">
		<div id="viewOne">
			<h1>Accounts</h1>
<hr>

<p>{{productDetails[2]["description"]}} </p>

<hr>

<div ng-repeat ="acc in accountDetails">

	  <div class="panel-group" id="accordion" style="margin-top:20px" >
	


    <div class="panel panel-primary" >
      <div class="panel-heading">
        <h4 class="panel-title">	
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse6-{{$index}}">{{acc.ACCOUNT_TYPE}}</a>
        </h4>
      </div>
      
      <div id="collapse6-{{$index}}" class="panel-collapse collapse">
        <div class="panel-body">
		<p style="margin-top:20x">{{acc.DESCRIPTION}}</p>
<c:if test="${user.isAdmin==1}">
<form action="EditAccount" method="get">
										<input name="{{acc.ACCOUNT_ID}}" type="submit" value="Edit"
											class="btn btn-danger" style="float: right;">
									</form>
									<form onsubmit="return confirm('Do you really want to Delete?');" action="DeleteAccount" method="get">
										<input name="{{acc.ACCOUNT_ID}}" type="submit" value="Delete"
											class="btn btn-info" style="float: right;  margin-right: 20px;"	>
									</form>
</c:if>
</div>
      </div>
      
      </div>
      
      
    
    </div>
    </div>
<c:if test="${user.isAdmin==1}">

<a href="AddAccount.html" class="btn btn-warning"
							style="float: right;">Add New</a>
</c:if>

		</div>
	</script>

				<script type="text/ng-template" id="two.tpl.html">
		<div id="viewTwo">
			<h1>Loans</h1>

<hr>

<p>{{productDetails[0]["description"]}} </p>

<hr>

		<div ng-repeat ="acc in loanDetails">
	  <div class="panel-group" id="accordion" style="margin-top:20px" >
    <div class="panel panel-primary" >
    
    
    
      <div class="panel-heading">
        <h4 class="panel-title">	
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5-{{$index}}">{{acc.loanType}}</a>
        </h4>
      </div>
      
      
      
      <div id="collapse5-{{$index}}" class="panel-collapse collapse">
        <div class="panel-body">
		<!-- <img src="C:\Users\admin\Desktop\Project\savings-account.jpg">
		 --><p style="margin-top:20x">{{acc.description}}</p>
<c:if test="${user.isAdmin==1}">

				<form action="EditLoan" method="get">
										<input name="{{acc.loanId}}" type="submit" value="Edit"
											class="btn btn-danger" style="float: right;">
									</form>
									<form onsubmit="return confirm('Do you really want to Delete?');" action="DeleteLoan" method="get">
										<input name="{{acc.loanId}}" type="submit" value="Delete"
											class="btn btn-info" style="float: right;  margin-right: 20px;"	>
									</form>
</c:if>
</div>

      </div>
      
      
      
      
    </div>
    </div>
    </div>
<c:if test="${user.isAdmin==1}">

<a href="AddLoan.html" class="btn btn-warning"
							style="float: right;">Add New</a>
</c:if>
</div>
	</script>

				<script type="text/ng-template" id="three.tpl.html">
		<div id="viewThree">
			<h1>Deposits</h1>

<hr>

<p>{{productDetails[1]["description"]}} </p>

<hr>

		<div ng-repeat ="acc in depositDetails">
	  <div class="panel-group" id="accordion" style="margin-top:20px" >
    <div class="panel panel-primary" >
    
    
    
      <div class="panel-heading">
        <h4 class="panel-title">	
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4-{{$index}}">{{acc.DEPOSIT_TYPE}}</a>
        </h4>
      </div>
      
      
      
      <div id="collapse4-{{$index}}" class="panel-collapse collapse">
        <div class="panel-body">
		<!-- <img src="C:\Users\admin\Desktop\Project\savings-account.jpg">
		 --><p style="margin-top:20x">{{acc.DESCRIPTION}}</p>
<c:if test="${user.isAdmin==1}">

<form action="EditDeposit" method="get">
										<input name="{{acc.DEPOSIT_ID}}" type="submit" value="Edit"
											class="btn btn-danger" style="float: right;">
									</form>
									<form onsubmit="return confirm('Do you really want to Delete?');" action="DeleteDeposit" method="get">
										<input name="{{acc.DEPOSIT_ID}}" type="submit" value="Delete"
											class="btn btn-info" style="float: right;  margin-right: 20px;"	>
									</form>
</c:if>
</div>
      </div>
      

      
      
      
    </div>


    </div>
    </div>
<c:if test="${user.isAdmin==1}">

<a href="AddDeposit.html" class="btn btn-warning"
							style="float: right;">Add New</a>

</c:if>
</div>
	</script>


				<script>
					var app = angular.module('myApp', []);
					app
							.controller(
									'myCtrl',
									function($scope, $http) {


										$scope.currentTab = 'one.tpl.html';

										$scope.onClickTab = function(tab) {
											$scope.currentTab = tab.url;
										}

										$scope.isActiveTab = function(tabUrl) {
											return tabUrl == $scope.currentTab;
										}

										$scope.tabs = [ {
											title : 'Accounts',
											url : 'one.tpl.html'
										}, {
											title : 'Loan',
											url : 'two.tpl.html'
										}, {
											title : 'Deposits',
											url : 'three.tpl.html'
										} ];

										$scope.getProductDetails = function() {

											$http
													.get(
															"/ProductCatalog/rest/Products/getAllData/")
													.then(
															function(response) {
																$scope.productDetails = response.data;

															});

										}

										$scope.getLoanDetails = function() {

											$http
													.get(
															"/ProductCatalog/rest/Loans/getAllData/")
													.then(
															function(response) {
																$scope.loanDetails = response.data;

															});

										}

										$scope.getAccountDetails = function() {

											$http
													.get(
															"/ProductCatalog/rest/Accounts/getAllData/")
													.then(
															function(response) {
																$scope.accountDetails = response.data;

															});

										}

										$scope.getDepositDetails = function() {

											$http
													.get(
															"/ProductCatalog/rest/Deposits/getAllData/")
													.then(
															function(response) {
																$scope.depositDetails = response.data;

															});

										}

										$scope.getProductDetails();
										$scope.getDepositDetails();
										$scope.getAccountDetails();
										$scope.getLoanDetails();

									});
				</script>
			</div>
		</div>
	</div>
</body>
</html>