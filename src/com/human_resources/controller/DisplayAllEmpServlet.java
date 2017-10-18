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
import com.human_resources.model.EmpInfo;

@WebServlet("/DisplayAllEmpServlet")
public class DisplayAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayAllEmpServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//CREATE OBJECT OF DAO CLASS
		EmpDAO cdao = new EmpDAO();
		
					
		//CALL DAO METHOD & RECEIVE ARRAYLIST OBJECT
		ArrayList<EmpInfo> custlist = cdao.displayAllEmp();
					
		//CREATE LINK BETWEEN SEVLET TO JSP FILE
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllEmp.jsp");
		
		//PUT ARRAYLIST OBJECT INSIDE REQUEST OBJECT(key-Value)
		request.setAttribute("clist", custlist);		
		
		//FORWARD TO JSP PAGE
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
