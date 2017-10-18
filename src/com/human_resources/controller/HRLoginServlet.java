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
import com.human_resources.dao.HrDAO;
import com.human_resources.model.EmpInfo;
import com.human_resources.model.HRInfo;

@WebServlet("/HRLoginServlet")
public class HRLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HRLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String hid = request.getParameter("hrid");
		String hpass = request.getParameter("hrpass");
		
		HrDAO cdao = new HrDAO();
		HRInfo cobj = cdao.loginHr(hid, hpass);
		
		
		if(cobj != null)
		{   
			//CREATE A NEW SESSION OBJECT 
           	HttpSession session = request.getSession(true);
			
           	//STORE INFORMATION WITHIN SESSION OBJECT
           	session.setAttribute("userinfo", cobj);
           	
           	session.setMaxInactiveInterval(5);           	
           
			response.sendRedirect("HR_AfterLogin.jsp");
	   	}
		else
		{
			request.setAttribute("ERRORMSG", "INVALID USERID OR PASSWORD");
						
			RequestDispatcher rd= request.getRequestDispatcher("HR_login.jsp");
			rd.forward(request, response);
				
			
		}
			
		
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}
}
