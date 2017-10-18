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
<title>Show Project</title>
</head>
<body background="slide-1.jpg">
<center>
<form action="SearchMgProjServlet">
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
</br>

<div class="container">
<div class="table-responsive">          
  <table class="table">
 <thead>
      <tr bgcolor="#50D3E3">
    <th>NAME</th>
    <th>ID</th>
    <th>DEPARTMENT</th>
    <th>DESIGNATION</th>
    <th>EMAIL</th>

  </tr>
  </thead>
  
  <%try{
      for(EmpInfo cobj1 : custlist)
      {
  %>
  
  <tbody>
   <tr bgcolor="#FFFFFF">
    <td><%= cobj1.getEmpname() %></td>
    <td> <%= cobj1.getEmpid()%> </td>
    <td><%= cobj1.getDept()%> </td>
    <td> <%= cobj1.getDesig()%> </td>
    <td> <%= cobj1.getEmail()%></td>
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
<P>

  </center>
</body>
</html>