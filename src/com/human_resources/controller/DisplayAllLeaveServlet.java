package com.human_resources.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human_resources.dao.EmpDAO;
import com.human_resources.dao.LeaveDAO;
import com.human_resources.model.EmpInfo;
import com.human_resources.model.LeaveInfo;


@WebServlet("/DisplayAllLeaveServlet")
public class DisplayAllLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayAllLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//CREATE OBJECT OF DAO CLASS
				LeaveDAO cdao = new LeaveDAO();
				
							
				//CALL DAO METHOD & RECEIVE ARRAYLIST OBJECT
				ArrayList<LeaveInfo> custlist = cdao.displayLeaveRequests();
							
				//CREATE LINK BETWEEN SEVLET TO JSP FILE
				RequestDispatcher rd = request.getRequestDispatcher("ViewLeaveRequest.jsp");
				
				//PUT ARRAYLIST OBJECT INSIDE REQUEST OBJECT(key-Value)
				request.setAttribute("clist", custlist);		
				
				//FORWARD TO JSP PAGE
				rd.forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
