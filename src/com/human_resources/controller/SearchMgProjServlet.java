package com.human_resources.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human_resources.dao.EmpDAO;
import com.human_resources.model.EmpInfo;

@WebServlet("/SearchMgProjServlet")
public class SearchMgProjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchMgProjServlet() {
        super();
       
        
    }
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CREATE OBJECT OF DAO CLASS
				EmpDAO cdao = new EmpDAO();
				String prj = request.getParameter("empproject");
							
				//CALL DAO METHOD & RECEIVE ARRAYLIST OBJECT
				ArrayList<EmpInfo> custlist = cdao.ShowProject(prj);
							
				//CREATE LINK BETWEEN SEVLET TO JSP FILE
				RequestDispatcher rd = request.getRequestDispatcher("Show_Emp_Proj.jsp");
				
				//PUT ARRAYLIST OBJECT INSIDE REQUEST OBJECT(key-Value)
				request.setAttribute("clist", custlist);		
				
				//FORWARD TO JSP PAGE
				rd.forward(request, response);		
	}

    

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfo custobj=new EmpInfo();
		String prj=request.getParameter("empproject");

		
		
	
	
		EmpDAO cdao=new EmpDAO();
		
		ArrayList<EmpInfo> f=cdao.ShowProject(prj);
		//reply back to user
		response.setContentType("text/html");
		
		
		
		
		
		
		
		
		
		PrintWriter out=response.getWriter();
		if(f != null)
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
	*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
}
}