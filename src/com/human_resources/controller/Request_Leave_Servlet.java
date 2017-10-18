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


@WebServlet("/Request_Leave_Servlet")
public class Request_Leave_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Request_Leave_Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		EmpInfo custobj=new EmpInfo();

		
		custobj.setLid(request.getParameter("lid"));
		custobj.setUid(request.getParameter("uid"));

		String leavetype= request.getParameter("leaves");
		custobj.setLeaves(leavetype);
		String days= request.getParameter("days");
		custobj.setDays(days);
		custobj.setDos(request.getParameter("dos"));

		if(leavetype.equals("cl"))
		{
			if(Integer.parseInt(days) > 3)
			{
				response.sendRedirect("cl.jsp");
			}
			
		}
		EmpDAO cdao=new EmpDAO();
		
		
		boolean f=cdao.insertrequest(custobj);
	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}
