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

@WebServlet("/UpdateEmpProfServlet")
public class UpdateEmpProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmpProfServlet() {
        super();
       
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfo custobj=new EmpInfo();

		
		String epass=request.getParameter("emppass");
		String edob=request.getParameter("dob");
		String egender=request.getParameter("gender");
		String ephnno=request.getParameter("phnno");
		String ecoun=request.getParameter("country");
		String ect=request.getParameter("city");
		String ecad=request.getParameter("caddress");
		String epadd=request.getParameter("paddress");
		String em=request.getParameter("email");
		String eid=request.getParameter("empid");
		
		EmpDAO cdao=new EmpDAO();
		boolean f=cdao.Update(epass, edob, egender, ephnno, ecoun, ect, ecad, epadd, em,eid);
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