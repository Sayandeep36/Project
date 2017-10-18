<%@page import="com.human_resources.model.FeedbackInfo"%>
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
<title>Queries</title>
</head>
<body background="slide-4.jpg">
<center>
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
<br>

<div class="container">
<div class="table-responsive">          
  <table class="table">
 <thead>
      <tr bgcolor="#50D3E3">
    <th>EMP ID</th>
    <th>QUERY</th>
    <th>REPLY</th>
    
  </tr>
  </thead>
  
  
  <%try{
      for(FeedbackInfo cobj1 : custlist)
      {
  %>
  
  <tbody>
   <tr bgcolor="#FFFFFF">
    <td><%= cobj1.getUid() %></td>
    <td> <%= cobj1.getQuery()%> </td>
    <td> <%= cobj1.getReply()%> </td>
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

<form action="ReplyQueryServlet"  method="get" class="form-horizontal" role="form">
            <div align="center">
                        
                <div class="form-group">
                    <label for="id" class="col-sm-3 control-label">ENTER EMP ID</label>
                    <div class="col-sm-6">
                        <input type="text" name="uid" class="form-control">
                    </div>
                </div>   
                <br/>              
  
  				<div class="form-group">
                    <label for="id" class="col-sm-3 control-label">TYPE REPLY</label>
                    <div class="col-sm-6">
                        <input type="text" name="reply" class="form-control">
                    </div>
                </div>   
                <br/> 
                
                <div class="col-xs-4 col-md-offset-4" >
  					<br>  <button class="btn btn-lg btn-success btn-block" type="submit" value="Reply"><u style="font-family: 'Agency FB';font-style: normal; font-size: x-large;text-decoration: blink">REPLY</u></button>
  				</div> 
  			</div>
  		</form>
<A HREF="HR_AfterLogin.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">BACK</u></A> 
  <A HREF="Welcome.jsp"  style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">GO TO HOMEPAGE</u></A>
</center>
</body>
</html>