<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>

<script src="jQuery/jquery.min.js"></script>
  <script src="jQuery/jquery-ui.min.js"></script>
    
    <script>
       $(document).ready(function() 
       {
          function disableBack() { window.history.forward() }

          window.onload = disableBack();
          window.onpageshow = function(evt) 
                              { if (evt.persisted) disableBack() }
        });
   </script>
   
</head>
<body background="slide-3.jpg">
	<% session.invalidate(); %>
	<center>
	<form action="HR_login.jsp">
		<h1><u style="margin: 19px; padding: 12px; border: thin ridge #C0C0C0; font-family: 'Agency FB'; color: #990033; font-style: normal; font-size: 50px; text-decoration: none; font-weight: bold;">DO YOU WANT TO REALLY LOGOUT?</u></h1>
		<br>  <button type="submit" value="Update"><u style="font-family: 'Agency FB'; color: 1; font-style: normal; font-size: x-large; text-decoration: blink">YES</u></button>
	</form>
	</center>
</body>
</html>