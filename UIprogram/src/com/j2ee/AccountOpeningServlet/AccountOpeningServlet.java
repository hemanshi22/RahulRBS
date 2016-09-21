package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AccountOpeningServlet")
public class AccountOpeningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		System.out.println("");
		System.out.println(request.getParameter("vName"));
		if(request.getParameter("vName").equals("SA"))
		{
			//request.setAttribute(arg0, arg1);
		RequestDispatcher dispatcher= request.getRequestDispatcher("SA.jsp");
		dispatcher.forward(request, response);
		
	}
		if(request.getParameter("vName").equals("CA"))
		{
			//request.setAttribute(arg0, arg1);
		RequestDispatcher dispatcher= request.getRequestDispatcher("CA.jsp");
		dispatcher.forward(request, response);
		
	}
		if(request.getParameter("vName").equals("FD"))
		{
			//request.setAttribute(arg0, arg1);
		RequestDispatcher dispatcher= request.getRequestDispatcher("FD.jsp");
		dispatcher.forward(request, response);
		
	}
		if(request.getParameter("vName").equals("RT"))
		{
			//request.setAttribute(arg0, arg1);
		RequestDispatcher dispatcher= request.getRequestDispatcher("basic.html");
		dispatcher.forward(request, response);
		
	}
		if(request.getParameter("vName").equals("FXD"))
		{ System.out.println("Atanu");
			//request.setAttribute(arg0, arg1);
		RequestDispatcher dispatcher= request.getRequestDispatcher("FX.jsp");
		dispatcher.forward(request, response);
		System.out.println("Atanuasa");
		
	}
		 
	 	 
		
		}}
   


