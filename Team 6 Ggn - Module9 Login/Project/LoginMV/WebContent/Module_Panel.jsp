<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body>
<% 
int emp = (int) session.getAttribute("emp");
String serviceBaseUrl="";
%> 
<div ng-app="myApp" ng-controller="myCtrl">
			
		<script>
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {
			$scope.showCM=false;
			$scope.showRD=false;
			$scope.showRM=false;
			$scope.showPC=false;
			$scope.showAO=false;
			$scope.showTML=false;
			$scope.showTMTD=false;
			$scope.showTMSA=false;
			$scope.showR=false;
			$scope.showLA=false;
				$http.get(
						"http://103.62.238.195:8080/BankStructServices/rest/ModuleService/getModule?emp_id="
								+ "<% out.print(emp); %>"
								).then(function(response) {
					$scope.PermDetails = response.data;
					if($scope.PermDetails.cm=='1') {
						$scope.showCM=true;
					}
					if($scope.PermDetails.rd=='1') {
						$scope.showRD=true;
					}
					if($scope.PermDetails.rm=='1') {
						$scope.showRM=true;
					}
					if($scope.PermDetails.pc=='1') {
						$scope.showPC=true;
					}
					if($scope.PermDetails.ao=='1') {
						$scope.showAO=true;
					}
					if($scope.PermDetails.tml=='1') {
						$scope.showTML=true;
					}
					if($scope.PermDetails.tmtd=='1') {
						$scope.showTMTD=true;
					}
					if($scope.PermDetails.tmsa=='1') {
						$scope.showTMSA=true;
					}
					if($scope.PermDetails.r=='1') {
						$scope.showR=true;
					}
					if($scope.PermDetails.la=='1') {
						$scope.showLA=true;
					}
					
					
				});
			
		});
	</script>
	

		
					<table class="table table-hover table-bordered" style="width: 650px">
			
			
			<tr>
				<td>
				<a style="width:265px;"class="btn btn-hover btn-info" href="/ProductCatalog/AdminController" target="bottomleft">
				Home</a>
				</td>
				</tr>
			
				<tr ng-show="showCM">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/abccbsclient/customerManagement/homepage.html?emp_id=<%= emp %>" target="bottomleft">
				Customer Management</a>
				</td>
				</tr>
				
			

			
				<tr ng-show="showRD">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/abccbsclient/reference_data/RefernceData.html?emp_id=<%= emp %>" target="bottomleft">
				Reference Data</a>
				</td>
				</tr>
				
			
			
			<tr ng-show="showRM">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/Success/RecordManagementHome.html?emp_id=<%= emp %>" target="bottomleft">
				Record Management</a>
				</td>
				</tr>
				
				
				
					
				
				<tr ng-show="showPC">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/ProductCatalog/AdminController?emp_id=<%= emp %>" target="bottomleft">
				Manage Product Catalog</a>
				</td>
				</tr>
				
			
			
			<tr ng-show="showAO">
			<td>
			<a  style="width:265px;" class="btn btn-hover btn-info" href="/UIprogram/Medium?emp_id=<%= emp %>" target="bottomleft">
				Account Opening</a>
				</td>
				</tr>
				
			
			
			<tr ng-show="showTML||showTMTD||showTMSA">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/final/Home.html?emp_id=<%= emp %>" target="bottomleft">
				Transaction Management</a>
				</td>
				</tr>
				
			
			
			
			
			
			
			 <tr  ng-show="showR">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/Reporting_RBS/Index.html?emp_id=<%= emp %>" target="bottomleft">
			    Reports</a>
			    </td>
			    </tr> 
			
			
			
			
			
			
			<tr ng-show="showLA">
				<td>
				<a  style="width:265px;" class="btn btn-hover btn-info" href="/User_Functionalities/User_Home.jsp" target="bottomleft">
				User Management</a>
				
				</td>
				</tr>				
	</table>
		</div>
</body>
</html>
