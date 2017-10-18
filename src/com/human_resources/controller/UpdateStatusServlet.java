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

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateStatusServlet() {
        super();
       
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfo custobj=new EmpInfo();
		String ename=request.getParameter("empname");
		String eid = request.getParameter("empid");
		
		String edob=request.getParameter("dob");
		String dpt=request.getParameter("dept");
		String egender=request.getParameter("gender");
		String ephnno=request.getParameter("phnno");
		String dsg=request.getParameter("desig");
		String ecoun=request.getParameter("country");
		String ect=request.getParameter("city");
		String ecad=request.getParameter("caddress");
		String epadd=request.getParameter("paddress");
		String em=request.getParameter("email");
		String slry=request.getParameter("salary");
		String c=request.getParameter("cl");
		String p=request.getParameter("pl");
		String dj=request.getParameter("doj");
		String stus=request.getParameter("empstatus");
		String dd=request.getParameter("did");
	
		EmpDAO cdao=new EmpDAO();
		
		System.out.println(eid);
		boolean f=cdao.UpdateEmp(ename, edob,dpt, egender, ephnno,dsg, ecoun, ect, ecad, epadd, em,slry,c,p,dj,stus,dd,eid);
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