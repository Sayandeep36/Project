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

import com.human_resources.dao.EmpDAO;
import com.human_resources.model.EmpInfo;

@WebServlet("/SearchUpdateEmpServlet")
public class SearchUpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchUpdateEmpServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String eid = request.getParameter("empid");
		
		EmpDAO cdao = new EmpDAO();
		ArrayList<EmpInfo> f = cdao.searchRecord(eid);
		RequestDispatcher rs = request.getRequestDispatcher("UpdateStatus.jsp");
		request.setAttribute("clist", f);
		rs.forward(request, response);
				
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(f != null)
		{
			out.print("<h1>VALID USER</h1>");
			
	   	}
		else
		{
			request.setAttribute("ERRORMSG", "INVALID USERID OR PASSWORD");
						
			RequestDispatcher rd= request.getRequestDispatcher("EditEmp.jsp");
			rd.forward(request, response);
		
			
		}
			
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}
}