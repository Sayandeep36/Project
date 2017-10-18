package com.human_resources.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human_resources.dao.EmpDAO;
import com.human_resources.model.EmpInfo;

@WebServlet("/Emp_Reg_Servlet")
public class Emp_Reg_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Emp_Reg_Servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpInfo custobj=new EmpInfo();

		
		custobj.setEmpname(request.getParameter("empname"));
		custobj.setEmpid(request.getParameter("empid"));
		custobj.setEmppass(request.getParameter("emppass"));
		custobj.setDob(request.getParameter("dob"));
		custobj.setGender(request.getParameter("gender"));
		custobj.setPhnno(request.getParameter("phnno"));
		custobj.setCountry(request.getParameter("country"));
		custobj.setCity(request.getParameter("city"));
		custobj.setCaddress(request.getParameter("caddress"));
		custobj.setPaddress(request.getParameter("paddress"));
		custobj.setEmail(request.getParameter("email"));
		custobj.setEmpproject(request.getParameter("empproject"));

		custobj.setEmpstatus(request.getParameter("empstatus"));
		
		
		EmpDAO cdao=new EmpDAO();
		boolean f=cdao.insertRecord(custobj);
	
		//reply back to user
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(f)
		{   
			//CREATE A NEW SESSION OBJECT 
           	HttpSession session = request.getSession(true);
			
           	//STORE INFORMATION WITHIN SESSION OBJECT
           	
           
			response.sendRedirect("EmpReqOut.jsp");
	   	}
		else
		{
			request.setAttribute("ERRORMSG", "INVALID USERID OR PASSWORD");
						
			RequestDispatcher rd= request.getRequestDispatcher("InvalidUser.jsp");
				
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

}
}
