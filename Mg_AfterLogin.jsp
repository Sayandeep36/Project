<%@page import="com.human_resources.model.MGInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%! MGInfo cobj1;%>

<%
    cobj1 = (MGInfo)session.getAttribute("userinfo");

%>

</br>
</br>
<div class = "container" align="center" style="background-image: url('cont_back3.jpg');padding:10px;width:150
            px;height:500px;border:1px white;">
         
         <h2> WELCOME <%=cobj1.getMgname()%></h2>   
            
<p>



  <form action="MGDisplayAllEmpServlet" method="get">
  <hr class="colorgraph"><br>
<div align="center">	
<div class="col-xs-5 col-md-offset-4" >
 	 <button class="btn btn-lg btn-success btn-block" type="submit" value="Show">DISPLAY ALL EMPLOYEE DETAILS</button>
 </div>
 </div>
 </form> 



<form action="ShowHrProfServlet">
 <hr class="colorgraph"><br>
<div align="center">	
<div class="col-xs-5 col-md-offset-4" >
 <br><h3><a href="EditMgEmp.jsp" >EDIT EMPLOYEE PROFILE</a></h3>
 </div>
 </div>
 </form>
 
  <hr class="colorgraph"><br>
<div align="center">	
<div class="col-xs-5 col-md-offset-4" >
 <br><h3><a href="ShowProjWise.jsp" >SHOW PROJECT DETAILS</a></h3>
 </div>
 </div>
 
 
 
 <form action="MG_logout.jsp">
 <hr class="colorgraph"><br>
<div align="center">	
<div class="col-xs-5 col-md-offset-4" >
  	<br>  <button class="btn btn-lg btn-warning btn-block" type="submit" value="Update">LOGOUT</button>
  	<h3><a href="Mg_Login.jsp" >BACK</a></h3>
  	</div>
  	</div>
  </form>
 
</div>
</body>
</html>