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

import com.human_resources.dao.LeaveDAO;
import com.human_resources.model.LeaveInfo;

@WebServlet("/Leave_Check")
public class Leave_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Leave_Check() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		    
		    	String lid = request.getParameter("lid");
				LeaveDAO cdao = new LeaveDAO();
				LeaveInfo cobj = cdao.checkLeave(lid);
				
				if(cobj != null)
				{   
					//CREATE A NEW SESSION OBJECT 
		           	HttpSession session = request.getSession(true);
					
		           	//STORE INFORMATION WITHIN SESSION OBJECT
		           	session.setAttribute("userinfo", cobj);
		     
					response.sendRedirect("ViewLeaveRequest.jsp");
			   	}
				else
				{
					request.setAttribute("ERRORMSG", "INVALID USERID OR PASSWORD");
								
					RequestDispatcher rd= request.getRequestDispatcher("ViewLeaveRequest.jsp");
					rd.forward(request, response);
						
					
				}
					
		 	}

			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
			  
			}
		}
	


