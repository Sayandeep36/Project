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

import com.human_resources.dao.FeedbackDAO;
import com.human_resources.model.FeedbackInfo;


@WebServlet("/FeedbackQueryServlet")
public class FeedbackQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FeedbackQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
FeedbackInfo custobj=new FeedbackInfo();

		
		custobj.setUid(request.getParameter("uid"));
		custobj.setQuery(request.getParameter("query"));
		FeedbackDAO cdao=new FeedbackDAO();
		boolean f=cdao.insertQUERY(custobj);
	
		//reply back to user
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(f)
		{   
           	//HttpSession session = request.getSession(true);
			//response.sendRedirect("EmpReqOut.jsp");
			out.println("Submitted");
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
