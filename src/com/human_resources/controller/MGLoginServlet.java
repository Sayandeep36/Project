package com.human_resources.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human_resources.dao.HrDAO;
import com.human_resources.dao.MgDAO;
import com.human_resources.model.HRInfo;
import com.human_resources.model.MGInfo;

@WebServlet("/MGLoginServlet")
public class MGLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MGLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mgid");
		String mpass = request.getParameter("mgpass");
		
		MgDAO cdao = new MgDAO();
		MGInfo cobj = cdao.loginMg(mid, mpass);
		
		
		if(cobj != null)
		{   
			//CREATE A NEW SESSION OBJECT 
           	HttpSession session = request.getSession(true);
			
           	//STORE INFORMATION WITHIN SESSION OBJECT
           	session.setAttribute("userinfo", cobj);
           	
           	session.setMaxInactiveInterval(5);           	
           
			response.sendRedirect("Mg_AfterLogin.jsp");
	   	}
		else
		{
			request.setAttribute("ERRORMSG", "INVALID USERID OR PASSWORD");
						
			RequestDispatcher rd= request.getRequestDispatcher("Mg_Login.jsp");
			rd.forward(request, response);
				
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
