<%@page import="com.human_resources.model.EmpInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE PORTAL</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body background="slide-3.jpg" >

<%! EmpInfo cobj1;%>

<%
    cobj1 = (EmpInfo)session.getAttribute("userinfo");

%>
</br>
</br>
<div class = "container" align="center" style="background-image: url('cont_back3.jpg');padding:10px;width:150
            px;height:500px;border:1px white;">
   			<h2>   WELCOME  <%= cobj1.getEmpname() %> ! </h2>
 			<a href="ShowEmpProfServlet?empid=<%=cobj1.getEmpid() %>"><p class="small"><h3>VIEW YOUR PROFILE</h3></p></a>
			<form action="Update_Emp_Prof.jsp">
				<hr class="colorgraph"><br>
				<div align="center">	
				<div class="col-xs-5 col-md-offset-4" >
  					<br>   <button class="btn btn-lg btn-success btn-block" type="submit"  value="Search & Update">EDIT PROFILE</button>
 		    	</div>
 		    	</div>
 			</form>
  
    			<%
      				EmpInfo eobj=(EmpInfo)session.getAttribute("userinfo");
       
      			%>
 
  			<form action="FeedbackQueryServlet" method="get"> 
  				<hr class="colorgraph"><br>
				<div align="center">
       				<input type="hidden" name="uid" value="<%=eobj.getEmpid()%>" readonly="readonly">
       				<div class="col-xs-5 col-md-offset-4" >
       					<input type="text" class="form-control input-lg" id="inputlg" name="query" placeholder="Query" align="middle" required="" autofocus="" />
       					<button  class="btn btn-lg btn-success btn-block" type="submit" value="Request">REQUEST</button>
   					 </div>
   				</div>
 			 </form>
 			 
 			 
   			<form action="SeeReplyServlet" method="get"> 
   				<hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
   						<input type="hidden" name="uid" value="<%=eobj.getEmpid()%>" readonly="readonly">
    					<button class="btn btn-lg btn-success btn-block" type="submit" value="See reply">SEE REPLY</button>
    				</div>
   				</div>
    		</form>
    		
    		<form action="Emp_logout.jsp">
    			<hr class="colorgraph"><br>
				<div align="center">
					<div class="col-xs-5 col-md-offset-4" >
  						<button class="btn btn-lg btn-warning btn-block" type="submit" value="Update">LOGOUT</button>
  						<h2><A HREF="Emp_login.jsp"><p class="medium">BACK</A></h2>
  					</div>
  				</div>
  			</form>
  
 </div>
</body>
</html>