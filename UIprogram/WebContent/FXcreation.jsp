<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FX Creation</title>
</head>
<body>
<form name="FX" method="get">
<div>
CIF of Customer:<%=request.getAttribute("CIF") %> <input class='form-control' type="hidden" name="cif" value=<%=request.getAttribute("CIF")%>>
</div>
<div>
Date of Opening:<input type="date" name="date" class='form-control' >
</div>
<div>
Currency Given:<select name="selectgivingcurrency" id="sel" onchange="jsFunction(this.value);">
 <option value="brn0">Select</option>
  <option value="EUR">EUR</option>
  <option value="USD">USD</option>
  <option value="GBP">GBP</option>
  <option value="INR">INR</option>
  </select>
  
  <script type="text/javascript">
  function jsFunction(value)
  {
      alert('In Currency Customer pays ' + value);
     
      document.getElementById('sel').innerHTML=theValue;
      document.getElementById('my_textbox').value=theValue;
  }
  </script>

</div>
<div>
Amount paid in selected Currency:<input type="text" name="amount" class='form-control'>
</div>
<div>
Currency Returned:<select class='form-control' name="selectreturningcurrency" onchange="jsFunction1(this.value);">
 <option value="brn0">Select</option>
  <option value="EUR">EUR</option>
  <option value="USD">USD</option>
  <option value="GBP">GBP</option>
  <option value="INR">INR</option>
  </select>
</div>


<script type="text/javascript">
function jsFunction1(value)
{
    alert('Out Currency Bank pays ' + value);
}
</script>
<input type="submit" class='form-control' value="Submit" onclick="form.action='ForexServlet';">
</form>
</body>
</html>