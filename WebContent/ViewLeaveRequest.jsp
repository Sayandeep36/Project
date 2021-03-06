<%@page import="com.human_resources.model.LeaveInfo"%>
<%@page import="com.human_resources.model.EmpInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ViewLeave</title>
</head>
<body background="slide-1.jpg">
<center>
	<form action="DisplayAllLeaveServlet" method="get">
<%!  //DECLARATION TAG
     // ALL VERIABLE SHOULD BE WRITTEN HERE
 	ArrayList<LeaveInfo> custlist;
  
%>

<%
    //SCRIPLET TAG
    //U CAN WRITE YOUR LOGIC HERE
    custlist = (ArrayList<LeaveInfo>)request.getAttribute("clist");
%>


<br>
</br>

<div class="container">
<div class="table-responsive">          
  <table class="table">
 <thead>
      <tr bgcolor="#50D3E3">
    <th>LEAVE ID</th>
    <th>EMP ID</th>
    <th>LEAVE TYPE</th>
    <th>NO OF DAYS</th>
    <th>DATE OF START</th>
    <th>STATUS</th>
    
  </tr>
  </thead>
  
  <%try{
      for(LeaveInfo cobj1 : custlist)
      {
  %>
  
    <tbody>
   <tr bgcolor="#FFFFFF">
    <td><%= cobj1.getLid() %></td>
    <td> <%= cobj1.getUid()%> </td>
    <td> <%= cobj1.getLeaves()%> </td>
    <td><%= cobj1.getDays()%> </td>
    <td><%= cobj1.getDos()%> </td>
    <td> <%= cobj1.getLstatus()%> </td>
	<td> <a href="AcceptServlet?lid=<%=cobj1.getLid()%>&uid=<%=cobj1.getUid()%>&leaves=<%=cobj1.getLeaves()%>&days=<%=cobj1.getDays()%>">ACCEPT</a> </td>
    <td> <a href="RejectServlet?lid=<%=cobj1.getLid()%>">REJECT</a> </td>
  </tr>
  </tbody>
  
  <%
      }
  }catch(NullPointerException e){e.printStackTrace();}
  %>
  
</table>
</div>
</div>
</form>
<A HREF="HR_AfterLogin.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">BACK</u></A> 
  <A HREF="Welcome.jsp"  style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">GO TO HOMEPAGE</u></A>

</center>
</body>
</html>