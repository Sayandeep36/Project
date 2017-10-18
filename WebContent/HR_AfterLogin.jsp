<%@page import="com.human_resources.model.HRInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="slide-3.jpg">

<%! HRInfo cobj1;%>

<%
    cobj1 = (HRInfo)session.getAttribute("userinfo");

%>
</br>
</br>
<div class = "container" align="center" style="background-image: url('cont_back3.jpg');padding:10px;width:150
            px;height:500px;border:1px white;">

<h2> WELCOME <%=cobj1.getHrname()%></h2>
<p>

<form action="ShowHrProfServlet">
<hr class="colorgraph"><br>
<div align="center">	
<div class="col-xs-5 col-md-offset-4" >
 <br><h3><a href="EditEmp.jsp">EDIT EMPLOYEE PROFILE</a></h3>
 </div>
 		    	</div>
 			</form>
 

 
 <form action="DisplayAllLeaveServlet" method="get">
 <hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
  <button class="btn btn-lg btn-success btn-block" type="submit" value="View leave">VIEW LEAVE DETAILS</button>
 </div>
 </div>
 </form>
 </br>
  <form action="DisplayAllEmpServlet" method="get">
  <hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
  
 	 <button class="btn btn-lg btn-success btn-block" type="submit" value="Show">DISPLAY ALL EMPLOYEE DETAILS</button>
 </div>
 </div>
 </form>
 
  <form action="DisplayAllQueryServlet" method="get">
  <hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
  
 	 <button class="btn btn-lg btn-success btn-block" type="submit" value="Update">DISPLAY ALL QUERIES</button>
 </div>
 </div>
 </form>
 
  <form action="HR_logout.jsp" style="text-decoration: none">
   <hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
  	  					<button class="btn btn-lg btn-warning btn-block" type="submit" value="Update">LOGOUT</button>
  	  					<h3><A HREF="HR_login.jsp">BACK</A></h3>
  					</div>
  				</div>
  </form>
  <br>
</div>
</body>
</html>