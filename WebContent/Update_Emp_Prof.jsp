<%@page import="com.human_resources.model.EmpInfo"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Your Profile</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="emp_reg.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="artistsPageBackground2.jpg">
<center>
<%! EmpInfo cobj1;%>

<%
    cobj1 = (EmpInfo)session.getAttribute("userinfo");

%>



<div class="container">
            
            <form action="UpdateEmpProfServlet"  method="get" class="form-horizontal" role="form">
            <div align="center">
                <h2>Update Your Profile</h2>
                
                
                         
                <div class="form-group">
                    <label for="id" class="col-sm-3 control-label">ID</label>
                    <div class="col-sm-9">
                        <input type="text" name="empid" value="<%=cobj1.getEmpid()%>" readonly="readonly" class="form-control">
                    </div>
                </div>   
                <br/>                        
                
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">PASSWORD</label>
                    <div class="col-sm-9">
                        <input type="password" name="emppass" value=<%=cobj1.getEmppass() %> required placeholder="PASSWORD" class="form-control">
                    </div>
                </div>
                
                                <br/>                        
                
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">EMAIL</label>
                    <div class="col-sm-9">
                        <input type="email" name="email" required placeholder="EMAIL" class="form-control">
                    </div>
                </div>
                
                                <br/>                        
                
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">DATE OF BIRTH</label>
                    <div class="col-sm-9">
                        <input type="date" name="dob" required placeholder=" DOB" class="form-control">
                    </div>
                </div>
                
                                <br/>                        
                
                
                 <div class="form-group">
                    <label class="control-label col-sm-3">Gender</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="male">Male
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" value="female" name="gender">Female
                                </label>
                            </div>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                
                <br/>
                
                
                 <div class="form-group">
                    <label for="phoneNo" class="col-sm-3 control-label">PHONE NO</label>
                    <div class="col-sm-9">
                        <input type="text" name="phnno" required placeholder=" PHONE NO" class="form-control">
                    </div>
                </div>
                
                
                                <br/>                        
                
                <div class="form-group">
                    <label for="country" class="col-sm-3 control-label">COUNTRY</label>
                    <div class="col-sm-9">
                        <select name="country" class="form-control">                         
                            <option>Bahamas</option>
                            <option>Cambodia</option>
                            <option>Denmark</option>
                            <option>Ecuador</option>
                            <option>Fiji</option>
                            <option>Gabon</option>
                            <option>Haiti</option>
                            <option selected>India</option>
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                
                
                                <br/>                        
                
                 <div class="form-group">
                    <label for="city" class="col-sm-3 control-label">CITY</label>
                    <div class="col-sm-9">
                        <input type="text" name="city" required placeholder="CITY" class="form-control" >
                    </div>
                </div>
                
                                <br/>                        
                
                
                <div class="form-group">
                    <label for="currentAddress" class="col-sm-3 control-label">CURRENT ADDRESS</label>
                    <div class="col-sm-9">
                        <input type="text" name="caddress" required placeholder=" CURRENT ADDRESS" class="form-control" >
                       
                    </div>
                </div>
                
                                  <br/>                        
                  
                  
                  <div class="form-group">
                    <label for="permanentAddress" class="col-sm-3 control-label">PERMANENT ADDRESS</label>
                    <div class="col-sm-9">
                        <input type="text" name="paddress" required placeholder=" PERMANENT ADDRESS" class="form-control" >
                       
                    </div>
                </div>
              
              
              
                              <br/>                        
              
              
              
              
                
                             
                               
            
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" value="Update" class="btn btn-primary btn-block"></button>
                        <input type="reset" value="Clear" class="btn btn-primary btn-block"></button>
                        
                    </div>
                </div>
                </div>
            </form> <!-- /form -->
            </div>

<A HREF="Emp_login.jsp" style="text-decoration: none"><br><u style="font-family: 'Agency FB';font-style: normal; font-size: x-large;text-decoration: blink">BACK</u></A>
</center>
</body>
</html>