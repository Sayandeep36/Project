<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="slide-3.jpg" >

<div>
   <%
   	  if(request.getAttribute("ERRORMSG") != null)
   	  {
   		  out.println("<font color = red size=3>");
       	  out.println(request.getAttribute("ERRORMSG"));
       	  out.println("</font>");
       	  out.println("<br>");
      }
   %>
			
</div>

</br>
</br>
<div class = "container" align="center" style="background-image: url('cont_back3.jpg');padding:10px;width:150
            px;height:500px;border:1px white;">
	
		<form action="EmpLoginServlet" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading" >Welcome Back Employee! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  <div align="center">
			   <div class="col-xs-5 col-md-offset-4" >
			  
			  <input type="text" class="form-control input-lg" id="inputlg" name="empid" placeholder="Username" align="middle" required="" autofocus="" />
			 
			  <br/>
			   <br/>
			  <input type="password" class="form-control input-lg" id="inputlg"  name="emppass" placeholder="Password" align="middle" required=""/>     		  
			 <br/>
			  <br/>
			
			 
			  <button class="btn btn-lg btn-success btn-block"  type="submit">Login</button>  		
			  <br/>	
			  <br/>	
			  <A HREF="Emp_Reg.jsp"><p class="small"><h3>New Employee?Register Here</h3></p></a>
	 </div>
	 </div>
		</form>			
	</div>
	


</body>
</html>









