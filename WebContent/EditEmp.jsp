<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Edit Employee details</title>
</head>
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
<div class = "container" align="center" >
<form action="SearchUpdateEmpServlet" method="get">
<div align="center">
<div class="col-xs-4 col-md-offset-3" >
     <h3>Enter Employee Id</h3><input class="form-control input-lg" type="text" name="empid">
     <br/>
      <button class="btn btn-lg btn-success btn-block" type="submit" value="Search & Update">UPDATE</button>
    </div>
    </div>
 </form>
 <div align="center">
 <div class="col-xs-4 col-md-offset-3" >
<h3> <A HREF="HR_AfterLogin.jsp"><br>BACK</A></h3>
 <h3><A HREF="Weloome.jsp"><br>GO TO HOMEPAGE</A></h3>
 </div>
 </div>
 </div>
</body>
</html>