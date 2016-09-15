package rbs.module.transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.PrintWriter;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.model.Transaction;
import rbs.module.transaction.rest.rest_app;
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	
//	static Date stringToDate(String value){
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//		java.util.Date date = null;
//		try {
//			date = format.parse(value);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new Date(date.getTime());
//	}
	
	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		rest_app d = new rest_app();
		
		if(request.getParameter("select").equals("criteria1"))
		{
			ArrayList arr=null;
			if( request.getParameter("criteria_value")!=null)
			{
			String username = request.getParameter("criteria_value");
			double y = Double.parseDouble(username);
			 arr =d.getTransactions(y);
			 request.setAttribute("resultSet", arr); 
			 getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
			}
			else{
				getServletConfig().getServletContext().getRequestDispatcher("/Error.html").forward(request,response);
			}
		}
		
		else if(request.getParameter("select").equals("criteria2"))
		{
		String username = request.getParameter("criteria_value");
		ArrayList arr =d.getTransactions(username);
		request.setAttribute("resultSet", arr); 
		getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
		}
		
		else if(request.getParameter("select").equals("criteria3"))
		{
			String username = request.getParameter("criteria_value");
			Date x = stringToDate(username);
			ArrayList arr =d.getTransactions(x);
			request.setAttribute("resultSet", arr); 
			getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
		}
		
		else if(request.getParameter("select").equals("criteria4"))
		{   String username = request.getParameter("criteria_value");
			String username1 = request.getParameter("criteria_value1");
			Date x = stringToDate(username);
			Date y = stringToDate(username1);
			ArrayList arr =d.getTransactions(x, y);
			request.setAttribute("resultSet", arr); 
			getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);		}
	
		}

}
