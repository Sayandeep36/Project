<%@page import="java.util.List"%>
<%@page import="com.human_resources.model.FeedbackInfo"%>
<%@page import="java.util.ArrayList"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Reply</title>
</head>
<body background="slide-4.jpg">
<center>
<form action="SeeReplyServlet">
<%!  //DECLARATION TAG
     // ALL VERIABLE SHOULD BE WRITTEN HERE
   ArrayList<FeedbackInfo> custlist;
   
%>

<%
    //SCRIPLET TAG
    //U CAN WRITE YOUR LOGIC HERE
    custlist = (ArrayList<FeedbackInfo>)request.getAttribute("clist");
%>

<br>
</br>

<div class="container">
<div class="table-responsive">          
  <table class="table">
 <thead>
      <tr bgcolor="#50D3E3">
    <th>ID</th>
    <th>YOUR QUERY</th>
    <th>HR REPLY</th>
  </tr>
  </thead>
  
  <%try{
      for(FeedbackInfo cobj1 : custlist)
      {
  %>
  
  <tbody>
   <tr bgcolor="#FFFFFF">
    <td><%=cobj1.getUid()%></td>
    <td><%=cobj1.getQuery()%></td>
    <td><%=cobj1.getReply()%></td>    
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