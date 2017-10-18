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

@WebServlet("/RejectServlet")
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String elid = request.getParameter("lid");
    	String eid = request.getParameter("uid");
    	String eleaves = request.getParameter("empid");
    	String edays = request.getParameter("days");
    			LeaveDAO cdao=new LeaveDAO();
    			
    			
    			boolean f=cdao.updateLeaveStatus("REJECT", elid);
    			

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
