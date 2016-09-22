﻿var mainapp = angular.module('mainapp', ['ngRoute', '720kb.datepicker']);
console.log(this.location);
var deskID="";
var empID="";
var isAOAllowed = false;
var isTLMAllowed = false;
var isTMTDAllowed = false;
var isTMSAAllowed = false;
var transData = [
                 ['Transaction Type', 'Transaction Amount']
                 
               ];
var options = {
        width: 800,
        height: 480,
        title: 'Transaction Type',
        colors: ['#878BB6', '#4ACAB4', '#FF8153', '#FFEA88', '#f6c7b6', '#543543'],

        is3D: true,
      };



function $_GET(param) {
	var vars = {};
	this.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if ( param ) {
		return vars[param] ? vars[param] : null;	
	}
	return vars;
}

mainapp.config(function ($routeProvider) {
    $routeProvider
    .when('/',
    {
        templateUrl: 'home.html'
    })
    .when('/accountStatements/:dateOrType/:dateType',
    {
        controller: 'statementsController',
        templateUrl: 'AccountStatements.html'
    })
    .when('/transactionDetails/:dateOrType/:dateType',
    {
        controller: 'transactionsController',
        templateUrl: 'TransactionDetails.html'
    })
    .when('/accountDetails/:dateOrType/:dateType',
    {
        controller: 'accountsDetailController',
        templateUrl: 'AccountDetails.html'
    })
    .when('/home',
    {
    	templateUrl: 'home.html'
    })
    .otherwise({redirectTo:'/'});

});

mainapp.factory('Appservice', ['$http', function ($http) {
    var Appservice = {};
    
    Appservice.getBasics = function () {
        return $http.get('test');
    };
    
    /*Appservice.getTransactionbyAccNo = function () {
        return $http.get('http://192.168.1.124:8080/final/rest/RestService/getbyaccountnumber/1');
    };*/
    
    Appservice.getTransactionbyDate = function(inputDate1){
    	var inputDate=new Date(inputDate1);
    	return $http.get('http://103.62.238.195:8080/final/rest/RestService/getbydate/'+inputDate.getFullYear()+'-'+(inputDate.getMonth()+1)+'-'+inputDate.getDate());
    }
    
    Appservice.getTransactionbyDateRange = function(inputDate1, inputDate2){
    	var inputDate1 = new Date(inputDate1);
    	var inputDate2 = new Date(inputDate2);
    	return $http.get('http://103.62.238.195:8080/final/rest/RestService/getbetweendates/'+inputDate1.getFullYear()+'-'+(inputDate1.getMonth()+1)+'-'+inputDate1.getDate()+'/'+inputDate2.getFullYear()+'-'+(inputDate2.getMonth()+1)+'-'+inputDate2.getDate());
    }
    
    Appservice.getTransactionbyType = function (type) {
        return $http.get('http://103.62.238.195:8080/final/rest/RestService/getbyaccounttype/' + type);
    };
    
    Appservice.getAccountData = function (accNo) {
        return $http.get('http://103.62.238.195:8080/final/rest/RestService/getbyaccountnumber/' + accNo);
    };
    
    Appservice.getAccountDetailsbyType = function (type) {
        return $http.get('http://103.62.238.195:8080/UIprogram/rest/rest_app/getSearchDetails/' + type);
    };
    
    Appservice.getAccountDetailsByDate = function (date1, date2) {
    	var inputDate1 = new Date(date1);
    	var inputDate2 = new Date(date2);
        return $http.get('http://103.62.238.195:8080/UIprogram/rest/rest_app/getSearchDetails1/' + inputDate1.getDate() + '-' + (inputDate1.getMonth() + 1) + '-' + (inputDate1.getYear() - 100) + '/' + inputDate2.getDate() + '-' + (inputDate2.getMonth() + 1) + '-' + (inputDate2.getYear() - 100));
    };
    
    Appservice.getAccountDetailsByDate1 = function (date1, date2) {
    	var inputDate1 = new Date(date1);
    	var inputDate2 = new Date(date2);
        return $http.get('http://103.62.238.195:8080/UIprogram/rest/rest_app/getSearchDetails1/' + inputDate1.getDate() + '-' + (inputDate1.getMonth() + 1) + '-' + (inputDate1.getYear() - 100) + '/' + (inputDate2.getDate() + 1) + '-' + (inputDate2.getMonth() + 1) + '-' + (inputDate2.getYear() - 100));
    };
    
    Appservice.getAccountNomineeName = function (acc_no) {
        return $http.get('http://103.62.238.195:8080/UIprogram/rest/rest_app/getSearchDetails/' + acc_no + '/0');
    };
    
    
    
      
    Appservice.todaydate_Intermediate= new Date();
    Appservice.todaydate= (Appservice.todaydate_Intermediate.getMonth()+1) + '/' + Appservice.todaydate_Intermediate.getDate() + '/' +  Appservice.todaydate_Intermediate.getFullYear();
    Appservice.addMonth= function(inDate)
    {
    	var date2s=new Date(inDate);
		var middleDate_1 = new Date(date2s.setMonth(date2s.getMonth()+1));
		console.log(middleDate_1);
		var middleDate_2 = new Date(middleDate_1.setDate(middleDate_1.getDate()-1));
		return (middleDate_2.getMonth() + 1) + '/' + middleDate_2.getDate() + '/' +  middleDate_2.getFullYear();
		
    };
    
    Appservice.addWeek = function(inDate)
    {
    	var date2s=new Date(inDate);
    	var middleDate = new Date(date2s.setDate(date2s.getDate()+6));
    	return (middleDate.getMonth()+1) + '/' + middleDate.getDate() + '/' +  middleDate.getFullYear();
    };
    
    Appservice.getdeskID = function (empid) {
        return $http.get('http://103.62.238.195:8080/BankStructServices/rest/ModuleService/getModule', {params:{emp_id:empid}});
    };
    Appservice.fetchGetPermissions = function (mod) {
        return $http.get('http://103.62.238.195:8080/BankStructServices/rest/RightsService/getRights', {params:{desk_id:deskID, mod:mod}});
    };
    
    Appservice.generateTransPieChart = function (data) {
    	var td = 0;
		var fx = 0;
		var sav = 0;
		var dmat = 0;
		var loan = 0;
    	
    	for(i = 0; i< data.length; i++) {
    		if(data[i].accountType == "SAVINGS") {
    			sav = sav + data[i].amount; 
    		} else if (data[i].accountType == "TERM_DEPOSIT"){
    			td = td + data[i].amount;
    		} else if (data[i].accountType == "FX"){
    			fx = fx + data[i].amount;
    		} else if (data[i].accountType == "DEMAT"){
    			dmat = dmat + data[i].amount;
    		} else {
    			loan = loan + data[i].amount;
    		}
    	}
    	var tdArray = ['Term Deposit',  td];
    	var fxArray = ['FX',  fx];
    	var loanArray = ['Loan',  loan];
    	var savArray = ['Savings', sav];
    	var dmatArray = ['Demat', dmat];
    	transData=[
                   ['Transaction Type', 'Transaction Amount']
                   
                   ];
    	transData[1] = tdArray;
    	transData[2] = fxArray;
    	transData[3] = loanArray;
    	transData[4] = savArray;
    	transData[5] = dmatArray;
    	
    	MYFUNC1();
    }
    
    return Appservice;
}]);

mainapp.controller('statementsController', function($scope, Appservice, $routeParams) {
	$scope.isDisabled=null;
	if($routeParams.dateType=="M")
		$scope.isDisabled=true;
	else
		$scope.isDisabled=false;
	$scope.returnValue=false;
	$scope.tableData="";
	$scope.tableData=[
	                  {"transactionId":1.0,"transactionTo":2.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":1.0,"transactionDate":"18-08-2016","transactionToType":"Savings"},
	                  {"transactionId":2.0,"transactionTo":1.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":2.0,"transactionDate":"20-08-2016","transactionToType":"Savings"},
	                  {"transactionId":3.0,"transactionTo":1.0,"amount":50000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"},
	                  {"transactionId":1000.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1003.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1004.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1007.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1005.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1006.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1008.0,"transactionTo":0.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"SB","transactionFrom":1.0,"transactionDate":"15-09-2016","transactionToType":"null"},
	                  {"transactionId":1002.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1009.0,"transactionTo":1.0,"amount":5000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"}
	                  ];
	
	$scope.isType=false;
	$scope.isRange=true;
	if($routeParams.dateOrType=='T') {
		$scope.isType=true;
	} else {
		if($routeParams.dateType == 'D') {
			$scope.isRange = false;
		}
	}
    $scope.fetchTableData = function() {
    	a = $scope.accNo;
    	if($scope.accNo=="" ||  $scope.accNo==null || $scope.date1M == null || $scope.date2 == null || isNaN(a)) {
        	swal({
        		  title: "Are you sure?",
        		  text: "Some input fields seem out of place",
        		  type: "warning"
        		});
        	return;
        }
        Appservice.getAccountData($scope.accNo)
//        Appservice.getBasics()
        .success(function (data) {
      	$scope.tableData=data;
        	data=$scope.tableData;
        	var crCount=0;
        	var drCount=0;
        	initialDate = new Date($scope.date1M);
        	finalDate = new Date($scope.date2);
        	finalTableData=[];
        	k=0;
        	for( l=0; l<$scope.tableData.length;l++) {
        		year = $scope.tableData[l].transactionDate.substring(6);
        		month = $scope.tableData[l].transactionDate.substring(3,5);
        		date = $scope.tableData[l].transactionDate.substring(0,2);
        		form_TransDatefinaldate = month + "/" + date + "/" + year;
        		transDate = new Date(form_TransDatefinaldate);
        	console.log(transDate);
        		if ( initialDate <= transDate && transDate <= finalDate){
        			finalTableData[k]=$scope.tableData[l];
        			k++;
        		}
        		}
        		$scope.tableData=finalTableData;
        		console.log(finalTableData);
        	for(i = 0; i< finalTableData.length; i++) {
        		if(data[i].transactionFrom == $scope.accNo) {
        			$scope.tableData[i].facingAccount = data[i].transactionTo;
        			$scope.tableData[i].facingAccountType = data[i].transactionToType;
        			$scope.tableData[i].crdr = "Debit";
        			drCount = drCount + $scope.tableData[i].amount; 
        		} else {
        			$scope.tableData[i].facingAccount = data[i].transactionFrom;
        			$scope.tableData[i].facingAccountType = data[i].transactionFromType;
        			$scope.tableData[i].crdr = "Credit";
        			crCount = crCount + $scope.tableData[i].amount;
        		}
        	}
        	
        	var crArray = ['Credit',  crCount];
        	var drArray = ['Debit',  drCount];
        	transData=[
                       ['Transaction Type', 'Transaction Amount']
                       
                       ];
        	transData[1] = crArray;
        	transData[2] = drArray;
        	
        	MYFUNC1();
        	
        	Appservice.getAccountNomineeName($scope.accNo)
        	.success(function (data) {
			        	$scope.holderName = data[0].nominee_NAME;
			        	$scope.currBalance = data[0].balance;
			        })	        	        
			      .error(function (data) {
			        	
			    	  	sweetAlert("Oops...", "Something went wrong!", "error");
			            $scope.returnValue=false;
			        })
        	
            $scope.returnValue=true;
        }).error(function (data) {
        	sweetAlert("Oops...", "Something went wrong!", "error");
            $scope.returnValue=false;
        })};
     
	$scope.date2s="";
	$scope.todaydatefinal="";
	$scope.todaydateinitial=Appservice.todaydate;
	if($routeParams.dateType=="R")
	$scope.todaydatefinal=Appservice.todaydate;
    /*Setting a date 1month ahead of the selected date into variable finaldate*/
	$scope.changeFinalDate = function() {
		if($routeParams.dateType=="M")
			$scope.finalDate=Appservice.addMonth($scope.date1M);
	}
	
	
	
	/*FINDING THE SELECTED PAGE (RANGE OR TYPE)*/
	if($routeParams.dateType=="R") {
		$scope.isRange = true;
		
	} else {
		$scope.isRange = false;
	}
});



mainapp.controller('transactionsController', function($scope, Appservice, $routeParams) {
	$scope.isType=false;
	$scope.isRange=true;
	
	$scope.selectionChanged = function() {
		$scope.returnValue=false;
	}
	
	if($routeParams.dateOrType=='T') {
		$scope.isType=true;
	} else {
		if($routeParams.dateType == 'D') {
			$scope.isRange = false;
		}
	}
	
	$scope.changeFinalDate = function() {
		if($routeParams.dateType=="M")
			$scope.date2=Appservice.addMonth($scope.date1R);
		else
			if($routeParams.dateType=="W")
				$scope.date2=Appservice.addWeek($scope.date1R);
	}
	
	$scope.tableData=[
	 {"loanId":1.0,"transactionId":3.0,"transactionDesc":"SUCCESS","transactionTo":1.0,"amount":50000.0,"accountType":"LOAN","transactionFrom":0.0,"transactionFromType":"Bank","transactionToType":"Savings","transactionDate":"16-09-2016"},
	 {"loanId":2.0,"transactionId":4.0,"transactionDesc":"Success","transactionTo":3.0,"amount":5000.0,"accountType":"FX","transactionFrom":4.0,"transactionFromType":"Savings","transactionToType":"Savings","transactionDate":"16-09-2016"},
	 {"loanId":1.0,"transactionId":1009.0,"transactionDesc":"Give Loan","transactionTo":1.0,"amount":5000.0,"accountType":"LOAN","transactionFrom":0.0,"transactionFromType":"Bank","transactionToType":"Savings","transactionDate":"16-09-2016"}
    ];
	
	/*$scope.tableData=[
	                  {"transactionId":1.0,"transactionTo":2.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":1.0,"transactionDate":"18-08-2016","transactionToType":"Savings"},
	                  {"transactionId":2.0,"transactionTo":1.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":2.0,"transactionDate":"20-08-2016","transactionToType":"Savings"},
	                  {"transactionId":3.0,"transactionTo":1.0,"amount":50000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"},
	                  {"transactionId":1000.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1003.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1004.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1007.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1005.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1006.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1008.0,"transactionTo":0.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"SB","transactionFrom":1.0,"transactionDate":"15-09-2016","transactionToType":"null"},
	                  {"transactionId":1002.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1009.0,"transactionTo":1.0,"amount":5000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"}
	                  ];*/
	
	$scope.todaydate=Appservice.todaydate;
	
	$scope.fetchTableData = function() {
		if($routeParams.dateOrType=='T') {
			
			if($scope.accType==null) {
	        	swal({
	        		  title: "Are you sure?",
	        		  text: "Some input fields seem out of place",
	        		  type: "warning"
	        		});
	        	return;
	        }
			
			if($scope.accType == 'TERM DEPOSIT'){
				if(isTMTDAllowed) {
			        Appservice.getTransactionbyType($scope.accType)
			        .success(function (data) {
			        	$scope.tableData=data;
			            $scope.returnValue=true;
			            
			        })	        	        
			      .error(function (data) {
			        	
			    	  	sweetAlert("Oops...", "Something went wrong!", "error");
			            $scope.returnValue=false;
			        })
			    }
				else {
					sweetAlert("Sorry", "You do not have premission", "error");
				}
			} else if($scope.accType == 'SAVINGS'){
				if(isTMSAAllowed) {
			        Appservice.getTransactionbyType($scope.accType)
			        .success(function (data) {
			        	$scope.tableData=data;
			            $scope.returnValue=true;
			            
			        }).error(function (data) {
			        	sweetAlert("Oops...", "Something went wrong!", "error");
			            $scope.returnValue=false;
			        })
			    }
				else {
					sweetAlert("Sorry", "You do not have premission", "error");
				}
			} else if($scope.accType == 'LOAN'){
				if(isTLMAllowed) {
			        Appservice.getTransactionbyType($scope.accType)
			        .success(function (data) {
			        	$scope.tableData=data;
			            $scope.returnValue=true;
			            
			        }).error(function (data) {
			        	sweetAlert("Oops...", "Something went wrong!", "error");
			            $scope.returnValue=false;
			        })
			    }
				else {
					sweetAlert("Sorry", "You do not have premission", "error");
				}
			} else if($scope.accType == 'DEMAT'){
				Appservice.getTransactionbyType($scope.accType)
		        .success(function (data) {
		        	$scope.tableData=data;
		            $scope.returnValue=true;
		            
		        }).error(function (data) {
		        	sweetAlert("Oops...", "Something went wrong!", "error");
		            $scope.returnValue=false;
		        });
			} else if($scope.accType == 'FX'){
				Appservice.getTransactionbyType($scope.accType)
		        .success(function (data) {
		        	$scope.tableData=data;
		            $scope.returnValue=true;
		            
		        }).error(function (data) {
		        	sweetAlert("Oops...", "Something went wrong!", "error");
		            $scope.returnValue=false;
		        });
			}
			
		} else {
			
			if ($routeParams.dateType == 'D') {
				
				if($scope.date1R==null) {
		        	swal({
		        		  title: "Are you sure?",
		        		  text: "Some input fields seem out of place",
		        		  type: "warning"
		        		});
		        	return;
		        }
				
				
				Appservice.getTransactionbyDate($scope.date1R)
		        .success(function (data) {
		        	console.log(data);
		        	$scope.tableData=data;
		        	Appservice.generateTransPieChart(data);
		        	$scope.returnValue=true;
		            
		        }).error(function (data) {
		        	sweetAlert("Oops...", "Something went wrong!", "error");
		            $scope.returnValue=false;
		        });
			}
			else {
				
				if($scope.date1R==null || $scope.date2==null) {
		        	swal({
		        		  title: "Are you sure?",
		        		  text: "Some input fields seem out of place",
		        		  type: "warning"
		        		});
		        	return;
		        }
				
				Appservice.getTransactionbyDateRange($scope.date1R, $scope.date2)
		        .success(function (data) {
		        	console.log(data);
		        	$scope.tableData=data;
		        	Appservice.generateTransPieChart(data);
		        	$scope.returnValue=true;
		            
		        }).error(function (data) {
		        	sweetAlert("Oops...", "Something went wrong!", "error");
		            $scope.returnValue=false;
		        });
			}
	        
		}
        
	};
	
});

mainapp.controller('accountsDetailController', function($scope, Appservice, $routeParams) {
	$scope.isType=false;
	$scope.isRange=true;
	if($routeParams.dateOrType=="T") {
		$scope.isType = true;
		
	} else {
		if($routeParams.dateType=="D")
			$scope.isRange=false;
	}
    
	$scope.changeFinalDate = function() {
		if($routeParams.dateType=="M")
			$scope.date2=Appservice.addMonth($scope.date1R);
		else
			if($routeParams.dateType=="W")
				$scope.date2=Appservice.addWeek($scope.date1R);
	}
	
	$scope.selectionChanged = function() {
		$scope.returnValue=false;
	}
	
	/*$scope.tableData=[
	                  {"transactionId":1.0,"transactionTo":2.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":1.0,"transactionDate":"18-08-2016","transactionToType":"Savings"},
	                  {"transactionId":2.0,"transactionTo":1.0,"amount":100.0,"accountType":"DEPOSIT","transactionFromType":"Savings","transactionFrom":2.0,"transactionDate":"20-08-2016","transactionToType":"Savings"},
	                  {"transactionId":3.0,"transactionTo":1.0,"amount":50000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"},
	                  {"transactionId":1000.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1003.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1004.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1007.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1005.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1006.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1008.0,"transactionTo":0.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"SB","transactionFrom":1.0,"transactionDate":"15-09-2016","transactionToType":"null"},
	                  {"transactionId":1002.0,"transactionTo":1.0,"amount":1000.0,"accountType":"Deposit","transactionFromType":"null","transactionFrom":0.0,"transactionDate":"15-09-2016","transactionToType":"SB"},
	                  {"transactionId":1009.0,"transactionTo":1.0,"amount":5000.0,"accountType":"LOAN","transactionFromType":"Bank","transactionFrom":0.0,"transactionDate":"16-09-2016","transactionToType":"Savings"}
	                  ];*/
	

	$scope.todaydate=Appservice.todaydate;
	
	if($routeParams.dateOrType=="T") {
		$scope.fetchTableData = function() {
			if(isAOAllowed) {
				
			if($scope.accountType==null) {
	        	swal({
	        		  title: "Are you sure?",
	        		  text: "Some input fields seem out of place",
	        		  type: "warning"
	        		});
	        	return;
	        }
				
	        Appservice.getAccountDetailsbyType($scope.accountType)
	        .success(function (data) {
	        	$scope.tableData = data;
	            $scope.returnValue=true;
	            
	        }).error(function (data) {
	        	sweetAlert("Oops...", "Something went wrong!", "error");
	            $scope.returnValue=false;
	        })}
			else {
				sweetAlert("Sorry", "You do not have premission", "error");
			}
			};
		}
		
	else {
		$scope.fetchTableData = function() {
			if(isAOAllowed) {
				if($routeParams.dateType=="D") {
					if($scope.date1R==null) {
			        	swal({
			        		  title: "Are you sure?",
			        		  text: "Some input fields seem out of place",
			        		  type: "warning"
			        		});
			        	return;
			        }
						
			        Appservice.getAccountDetailsByDate1($scope.date1R, $scope.date1R)
				        .success(function (data) {
				        	$scope.tableData = data;
				            $scope.returnValue=true;
				            
				        }).error(function (data) {
				        	sweetAlert("Oops...", "Something went wrong!", "error");
				            $scope.returnValue=false;
				        });
			        } else {
			        	if($scope.date1R==null || $scope.date2==null) {
				        	swal({
				        		  title: "Are you sure?",
				        		  text: "Some input fields seem out of place",
				        		  type: "warning"
				        		});
				        	return;
				        }
							
				        Appservice.getAccountDetailsByDate($scope.date1R, $scope.date2)
				        .success(function (data) {
				        	$scope.tableData = data;
				            $scope.returnValue=true;
				            
				        }).error(function (data) {
				        	sweetAlert("Oops...", "Something went wrong!", "error");
				            $scope.returnValue=false;
				        })
			        }
				}
			else {
				sweetAlert("Sorry", "You do not have premission", "error");
			}
			};
		}
	}
	
	

);

mainapp.controller('mainController', function($scope, Appservice) {
	empID=$_GET('emp_id');
	
	console.log(empID);
	if(empID==null){
		empID=13;
	}
	console.log(empID);
	$scope.trans='';
	$scope.add='';
	$scope.ast='';
	$scope.isAllowed=false;
	$scope.isTMSAAllowed = false;
	$scope.isTLMAllowed = false;
	$scope.home='active';
	$scope.isTMTDAllowed = false;
	$scope.clickedMe = function(type) {
		
		$scope.trans='';
		$scope.add='';
		$scope.ast='';
		$scope.home='';
		
		if(type == 'trans') {
			$scope.trans='active';
		} else if (type == 'ast') {
			$scope.ast='active';
		} else if(type == 'add') {
			$scope.add='active';
		} else if(type == 'home') {
			$scope.home='active';
		}
	};

    Appservice.getdeskID(empID)
    .success(function (data) {
    	deskID=data.desk_id;
    	if(data.ao=='1') {
    		$scope.isAllowed=true;
    	}
    	Appservice.fetchGetPermissions('TMSA')
        .success(function (data) {
        	if(data.get=='1') {   
        		$scope.isTMSAAllowed = true;
        		isTMSAAllowed = true;
        	}
        }).error(function (data) {
            alert("Something Went Wrong"); 
        	sweetAlert("Oops...", "Something went wrong!", "error");
        });
    	
    	Appservice.fetchGetPermissions('AO')
        .success(function (data) {
        	if(data.get=='1') {
        		isAOAllowed = true;
        	}
        }).error(function (data) {
        	sweetAlert("Oops...", "Something went wrong!", "error");
        });
    	
    	Appservice.fetchGetPermissions('TML')
        .success(function (data) {
        	if(data.get=='1') {
        		$scope.isTLMAllowed = true;
        		isTLMAllowed = true;
        	}
        }).error(function (data) {
        	sweetAlert("Oops...", "Something went wrong!", "error");
        });
    	
    	Appservice.fetchGetPermissions('TMTD')
        .success(function (data) {
        	if(data.get=='1') {
        		$scope.isTMTDAllowed = true;
        		isTMTDAllowed = true;
        	}
        }).error(function (data) {
        	sweetAlert("Oops...", "Something went wrong!", "error");
        });
    	
    }).error(function (data) {
    	sweetAlert("Oops...", "Something went wrong!", "error");
    });
});