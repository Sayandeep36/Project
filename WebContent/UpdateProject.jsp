<%@ page import="com.human_resources.model.EmpInfo" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Status</title>
</head>
<body background="laptop-wallpaper-1680x1050.jpg">
<center>
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



<%!  
   ArrayList<EmpInfo> f;
   
%>
<%
    f= (ArrayList<EmpInfo>)request.getAttribute("clist");
%>
	<form action="UpdateProjectServlet" method="get">
	<table width="100%">
 	<%
 	try{
      	for(EmpInfo cobj : f)
      	{
  	%>
  	<tr>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">NAME</u></td><td><input type="text" name="empname" value= "<%= cobj.getEmpname()%>" readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">EMPLOYEE ID</u></td><td></u><input type="text" name="empid" value="<%=cobj.getEmpid()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DOB</u></td><td><input type="text"  name="dob"value= "<%= cobj.getDob()%>" readonly></td>
     </tr>
    <tr>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DEPARTMENT</u></td><td><input type="text" name="dept" value= "<%= cobj.getDept()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DESIGNATION</u></td><td><input type="text" name="desig" value= "<%= cobj.getDesig()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">CITY</u> </td><td><input type="text" name="city" value="<%= cobj.getCity()%>" readonly></td>
     </tr>
    <tr>
   <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">EMAIL</u></td><td><input type="text" name="email" value= "<%= cobj.getEmail()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">PROJECT</u></td><td><input type="text" name="empproject" value= "<%=cobj.getEmpproject()%>"> </td>
    
    </tr>
     <% 
      } 
  }catch(IllegalStateException e){e.printStackTrace();}
  %>
</table>
<button type="submit" value="Update"><u style="font-family: 'Agency FB';  color: 1; font-style: normal; font-size: x-large;text-decoration: blink">UPDATE</u></button>

</form>

</center>
</body>
</html>