<%@page import="com.human_resources.model.LeaveInfo"%>
<%@page import="java.util.List"%>
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
<title>Show Leave Request</title>
</head>
<body background="laptop-wallpaper-1680x1050.jpg">
<center>
<form action="ShowEmpProfServlet">
<%!  //DECLARATION TAG
     // ALL VERIABLE SHOULD BE WRITTEN HERE
   ArrayList<EmpInfo> custlist;
   
%>

<%
    //SCRIPLET TAG
    //U CAN WRITE YOUR LOGIC HERE
    custlist = (ArrayList<EmpInfo>)request.getAttribute("clist");
%>


<br>
<br>

<div class="container">
<div class="table-responsive">          
  <table class="table">
 <thead>
      <tr bgcolor="#50D3E3">
    <th>U ID</th>
    <th>LEAVE ID</th>
    <th>LEAVES</th>
    <th>DAYS</th>
    <th>DOS</th>
    <th>LEAVE STATUS</th>
  </tr>
  </thead>

  
  <%try{
      for(EmpInfo cobj1 : custlist)
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

</center>
</body>
</html>