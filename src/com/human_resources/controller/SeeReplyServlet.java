package com.human_resources.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human_resources.dao.FeedbackDAO;
import com.human_resources.model.FeedbackInfo;

@WebServlet("/SeeReplyServlet")
public class SeeReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SeeReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FeedbackDAO cdao = new FeedbackDAO();
		String eid = request.getParameter("uid");
		
		//CALL DAO METHOD & RECEIVE ARRAYLIST OBJECT
		ArrayList<FeedbackInfo> custlist = cdao.searchFeedback(eid);
					
		//CREATE LINK BETWEEN SEVLET TO JSP FILE
		RequestDispatcher rd = request.getRequestDispatcher("Show_Reply.jsp");
		
		//PUT ARRAYLIST OBJECT INSIDE REQUEST OBJECT(key-Value)
		request.setAttribute("clist", custlist);		
		
		//FORWARD TO JSP PAGE
		rd.forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
