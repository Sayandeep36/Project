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
 <form action="UpdateStatusServlet" method="get">
<table width="100%">

  
  <%
 try{
      for(EmpInfo cobj : f)
      {
  %>
  
  <tr>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">NAME</u></td><td><input type="text" name="empname" value= "<%= cobj.getEmpname()%>" readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">EMPLOYEE ID</td><td></u><input type="text" name="empid" value="<%=cobj.getEmpid()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DOB</u></td><td><input type="text"  name="dob"value= "<%= cobj.getDob()%>" readonly></td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DEPARTMENT</u></td><td><input type="text" name="dept" value= "<%= cobj.getDept()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">GENDER</u></td><td><input type="text" name="gender" value= "<%= cobj.getGender()%>"readonly> </td>
     </tr>
    <tr>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">PHONE NO</u></td><td><input type="text" name="phnno" value= "<%= cobj.getPhnno()%>" readonly></td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DESIGNATION</u></td><td><input type="text" name="desig" value= "<%= cobj.getDesig()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">COUNTRY</u></td><td><input type="text" name="country" value= "<%= cobj.getCountry()%>"readonly ></td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">CITY</u> </td><td><input type="text" name="city" value="<%= cobj.getCity()%>" readonly></td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">CURRENT ADDRESS</u></td><td><input type="text"  name="caddress" value= "<%=cobj.getCaddress()%>"readonly> </td>
     </tr>
    <tr>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">PERMANENT ADDRESS</u></td><td><input type="text" name="paddress" value= "<%= cobj.getPaddress()%>"readonly> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">EMAIL</u></td><td><input type="text" name="email" value= "<%= cobj.getEmail()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">SALARY</u></td><td><input type="text" name="salary" value= "<%= cobj.getSalary()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">CASUAL LEAVE</u></td><td><input type="text" name="cl" value= "<%= cobj.getCl()%>"> </td>
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">PRIVILEGED LEAVE</u></td><td><input type="text" name="pl" value= "<%= cobj.getPl()%>"> </td>
    </tr>
    <tr>
    
    <td><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">STATUS</u></td><td><input type="text" name="empstatus" value= "<%= cobj.getEmpstatus()%>"> </td>
            </tr>
            
            
            <a href="DeleteEmpServlet?empid=<%=cobj.getEmpid() %>" style="text-decoration: none"><u style="font-family: 'Agency FB';font-style: normal; font-size: large;text-decoration: blink">DELETE</u></a>
            
  <% 
      } 
  }catch(IllegalStateException e){e.printStackTrace();}
  %>
  
</table>
<button type="submit" value="Update"><u style="font-family: 'Agency FB';  color: 1; font-style: normal; font-size: x-large;text-decoration: blink">UPDATE</u></button>

</form>
<A HREF="EditEmp.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">BACK</u></A>
 <A HREF="Welcome.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">GO TO HOMEPAGE</u></A>
</center>
</body>
</html>