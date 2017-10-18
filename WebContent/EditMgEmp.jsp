<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee details</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<body background="slide-1.jpg">
<center>
</br>
</br>
<form action="SearchUpdateMgEmpServlet"  method="get" class="form-horizontal" role="form">
            <div align="center">
                        
                <div class="form-group">
                    <label for="id" class="col-sm-3 control-label">ENTER EMPLOYEE ID</label>
                    <div class="col-sm-6">
                        <input type="text" name="empid" class="form-control">
                    </div>
                </div>   
                <br/>  
                
                <div class="col-xs-4 col-md-offset-4" >
  					<button class="btn btn-lg btn-success btn-block" type="submit" value="Search & Update"><u style="font-family: 'Agency FB';font-style: normal; font-size: x-large;text-decoration: blink">UPDATE</u></button>
  				</div> 
  				<br>
  			</div>
  			</form>
 
 </center>
</body>
</html>