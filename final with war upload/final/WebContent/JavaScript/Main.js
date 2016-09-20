
function getdate(){$.get('http://103.62.238.195:8080/final/rest/RestService/getbydate/',function(data1){
	   return data1;} );}     	
 	
function getaccno(){$.get('http://103.62.238.195:8080/final/rest/RestService/getbyaccountnumber/',function(data2){
	   return data2;} );}    

function getbetweendate(){$.get('http://103.62.238.195:8080/final/rest/RestService/getbetweendates/',function(data3){
	   return data3;} );}    

function getacctype(){$.get('http://103.62.238.195:8080/final/rest/RestService/getaccounttype/',function(data4){
	   return data4;} );}    