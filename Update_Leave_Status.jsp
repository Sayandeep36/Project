<%@page import="com.human_resources.model.LeaveInfo"%>
<%@ page import="com.human_resources.model.EmpInfo" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Status</title>
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
   ArrayList<LeaveInfo> f;
   
%>
<%
    f= (ArrayList<LeaveInfo>)request.getAttribute("clist");
%>
 
<table width="100%">

  
  <%
 try{
      for(LeaveInfo cobj : f)
      {
  %>
  
  <tr>
  <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">LEAVE ID</u><input type="text" name="lid" value="<%=cobj.getLid()%>" readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">EMPLOYEE ID</u><input type="text" name="uid" value="<%=cobj.getUid()%>"readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">TYPE OF LEAVE</u><input type="text"  name="leaves"value="<%=cobj.getLeaves()%>" readonly></td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">NO OF DAYS</u><input type="text" name="days" value= "<%=cobj.getDays()%>"readonly> </td>  
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DATE OF START</u><input type="text" name="dos" value= "<%=cobj.getDos()%>"readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">STATUS</u><input type="text" name="lstatus" value= "<%=cobj.getLstatus()%>" ></td>
  </tr>
  <% 
      } 
  }catch(NullPointerException e){e.printStackTrace();}
  %>
  
</table>
<form action="Update_Leave_Servlet" method="get">
<input type="submit" value="Update">

</form>
</center>
</body>
</html>