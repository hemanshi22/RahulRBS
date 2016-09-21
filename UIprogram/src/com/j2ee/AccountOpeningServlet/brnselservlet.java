package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/brnselservlet")
public class brnselservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String value1=null;
		if(request.getParameter("selectbranch").equals("brn1")){
			 value1="10";
			 
			/* response.setContentType("text/plain");  
				  response.setCharacterEncoding("UTF-8"); 
				  response.getWriter().write(value); }*/
		
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/SA.jsp");
		 request.setAttribute("Name", "10");
		 dispatcher.forward(request, response);
		}
		      
			/*//RequestDispatcher dispatcher = request.getRequestDispatcher("/SA.jsp");
			// // set your String value in the attribute
			//dispatcher.forward( request, response );*/
	
		/*if(request.getParameter("selectbranch").equals("brn2")){}
		if(request.getParameter("selectbranch").equals("brn3")){}
		if(request.getParameter("selectbranch").equals("brn4")){}*/
	

	}
}
