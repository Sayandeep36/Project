<%@page import="com.human_resources.model.EmpInfo"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="emp_reg.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body background="artistsPageBackground2.jpg">
<center>

<div class="container">
            
      <form action="Request_Leave_Servlet"  method="get" class="form-horizontal" role="form">
      <div align="center">
      <h2>REQUEST FOR LEAVE</h2>

    
           <%
          Random r = new Random();
          int x = r.nextInt(95000);
          String lid ="L"+x;
          
       %>
       
       			<div class="form-group">
                    <label for="id" class="col-sm-3 control-label">ID</label>
                    <div class="col-sm-9">
                        <input type="text" name="lid" value="<%=lid%>" readonly="readonly" class="form-control">
                    </div>
                </div>   
                <br/>  
                <%
      				EmpInfo eobj=(EmpInfo)session.getAttribute("userinfo");
       
      			%>                      
                
                <div class="form-group">
                    <label for="userid" class="col-sm-3 control-label">USER ID</label>
                    <div class="col-sm-9">
                        <input type="text" name="uid" value=<%=eobj.getEmpid()%> required placeholder="PASSWORD" class="form-control">
                    </div>
                </div>
       			<br>
       			
       			<div class="form-group">
                    <label class="control-label col-sm-3">CHOOSE LEAVE TYPE</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" name="leaves" value="cl">CASUAL LEAVE
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" name="leaves" value="pl">PRIVILEGED LEAVE
                                </label>
                            </div>
                        </div>
                    </div>
                </div>              
                <br/>

				<div class="form-group">
                    <label for="days" class="col-sm-3 control-label">NO OF DAYS</label>
                    <div class="col-sm-9">
                        <input type="text" name="days" class="form-control">
                    </div>
                </div>   
                <br/> 

				<div class="form-group">
                    <label for="date" class="col-sm-3 control-label">DATE OF START FOR LEAVE</label>
                    <div class="col-sm-9">
                        <input type="date" name="dos" required placeholder=" DOS" class="form-control">
                    </div>
                </div>
				<br/>
          
           		<div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" value="Update" class="btn btn-primary btn-block"></button>
                        <input type="Reset" value="Reset" class="btn btn-primary btn-block"></button>        
                	</div>
                </div>
                <br/>
   			</div>
		</form>
		
		<form action="Show_Request_Servlet"  method="get" class="form-horizontal" role="form">
		<div align="center">
                <h2>HAVE ALREADY REQUESTED?</h2>                
                                        
                <div class="form-group">
                    <label for="id" class="col-sm-3 control-label">ENTER ID</label>
                    <div class="col-sm-9">
                        <input type="text" name="empid" class="form-control">
                    </div>
                </div>   
                <br/>                        
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" value="Check" class="btn btn-primary btn-block"></button>
                    </div>
                </div>
        </div>
        </form>
</div>


<A HREF="AfterLogin.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB';font-size: x-large;  color: #3399FF; font-style: normal; font-size: large; text-decoration: blink">BACK</u></A>
<A HREF="Welcome.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB'; color: #3399FF; font-style: normal; font-size: x-large; text-decoration: blink">GO TO HOMEPAGE</u></A>
</center>
</body>
</html>