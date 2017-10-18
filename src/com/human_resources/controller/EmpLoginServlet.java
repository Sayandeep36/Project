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

@WebServlet("/EmpLoginServlet")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String eid = request.getParameter("empid");
		String epass = request.getParameter("emppass");
		
		EmpDAO cdao = new EmpDAO();
		EmpInfo cobj = cdao.loginCheck(eid, epass);
		
		
		if(cobj != null)
		{   
			//CREATE A NEW SESSION OBJECT 
           	HttpSession session = request.getSession(true);
			
           	//STORE INFORMATION WITHIN SESSION OBJECT
           	session.setAttribute("userinfo", cobj);
           	
           
			response.sendRedirect("AfterLogin.jsp");
	   	}
		else
		{
			request.setAttribute("ERRORMSG", "<h3>INVALID USERID OR PASSWORD</h3>");
						
			RequestDispatcher rd= request.getRequestDispatcher("Emp_login.jsp");
			rd.forward(request, response);
				
		}
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}
}