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
<title>Show Employee</title>
</head>
<body background="slide-1.jpg">
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
    <th>NAME</th>
    <th>ID</th>
    <th>PASSWORD</th>
    <th>DOB</th>
    <th>DEPARTMENT</th>
    <th>GENDER</th>
    <th>PHONE NO</th>
    <th>DESIGNATION</th>
    <th>COUNTRY</th>
    <th>CITY</th>
    <th>CURRENT ADDRESS</th>
    <th>PERMANENT ADDRESS</th>
    <th>EMAIL</th>
    <th>SALARY</th>
    <th>CASUAL LEAVE</th>
    <th>PRIVILEGED LEAVE</th>
    <th>DATE OF JOINT</th>
    <th>PROJECT</th>
    <th>STATUS</th>
    
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
    <td> <%= cobj1.getEmppass()%> </td>
    <td><%= cobj1.getDob()%> </td>
    <td><%= cobj1.getDept()%> </td>
    <td> <%= cobj1.getGender()%> </td>
    <td> <%= cobj1.getPhnno()%> </td>
    <td> <%= cobj1.getDesig()%> </td>
    <td> <%= cobj1.getCountry()%></td>
    <td><%= cobj1.getCity()%> </td>
    <td> <%= cobj1.getCaddress()%> </td>
    <td><%= cobj1.getPaddress()%></td>
    <td> <%= cobj1.getEmail()%></td>
    <td><%= cobj1.getSalary()%> </td>
    <td> <%= cobj1.getCl()%> </td>
    <td> <%= cobj1.getPl()%> </td>
    <td> <%= cobj1.getDoj()%></td>
    <td> <%= cobj1.getEmpproject()%></td>
    <td><%= cobj1.getEmpstatus()%> </td>
    
    
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
 <% if((Integer.parseInt(custlist.get(0).getCl())>0)|| (Integer.parseInt(custlist.get(0).getPl())>0))
 {
 
 %>
 <form action="Request_Leave.jsp">
   <div class="col-xs-4 col-md-offset-4" >
  <br>  <button class="btn btn-lg btn-success btn-block" type="submit" value="Login"><u style="font-family: 'Agency FB';font-style: normal; font-size: x-large;text-decoration: blink">REQUEST FOR LEAVE</u></button>
  </div>
  </form>
  
  
  <%
 }
  %>
  </center>
</body>
</html>