package com.human_resources.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human_resources.dao.EmpDAO;
import com.human_resources.dao.LeaveDAO;
import com.human_resources.model.EmpInfo;
import com.human_resources.model.LeaveInfo;

@WebServlet("/AcceptServlet")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String elid = request.getParameter("lid");
    	String eid = request.getParameter("uid");
    	String eleaves = request.getParameter("leaves");
    	String edays = request.getParameter("days");
    	

    

    		
    		
    		
    			LeaveDAO cdao=new LeaveDAO();
    			
    		 if(eleaves.equals("cl"))
    		 {
    			boolean f=cdao.updateLeaveStatus("ACCEPT", elid);
    			boolean f1=cdao.decrementCL(eid, edays);
    		
    			//reply back to user
    			
    			response.setContentType("text/html");
    			PrintWriter out=response.getWriter();
    					if(f)
    					{
    						out.println("CASUAL LEAVE IS ACCEPTED");
    						
    						
    					}
    					else
    					{
    						out.println("invalid user");
    					}
    		 }
    		 else{
    			 
    			 boolean f=cdao.updateLeaveStatus("ACCEPT", elid);
     			boolean f2=cdao.decrementPL(eid, edays);
     			response.setContentType("text/html");
    			PrintWriter out=response.getWriter();
    					if(f)
    					{
    						out.println("PRIVILEGED LEAVE IS ACCEPTED");
    						
    						
    					}
    					else
    					{
    						out.println("invalid user");
    					}
    			 
    		 }
    			
    		}

    		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		}

    	}


	

