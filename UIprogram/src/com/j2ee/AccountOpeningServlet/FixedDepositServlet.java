package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.dao.DaoImplementation;
import com.account.dao.DatabaseConnection1;
import com.account.model.Account;
import com.account.model.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



@WebServlet("/FixedDepositServlet")
public class FixedDepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
    	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
    	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
	
		HttpSession session= request.getSession();
		String per= (String)session.getAttribute("per");
		
		Article articles = new Article();
		String accountNumber=null;
		int acc_no=0;
		
	accountNumber=request.getParameter("ACC_NO");
	 acc_no=Integer.parseInt(accountNumber);
	 DaoImplementation dao=new DaoImplementation();
	 int status=dao.SearchAccount(acc_no);
	 System.out.println(status);
	 String interest_rate=dao.fetchInterestRate();
	 articles.setId(acc_no);
		articles.setTitle(interest_rate);	
	  System.out.println(interest_rate);
	 if(status!=0)
		{	

		
			out.println("Saving Account Present.Directing to the FD creation page");
			request.setAttribute("articles", articles);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/FD1.jsp");
			dispatcher.forward(request, response);
			}
		
		else
		{
			out.println("Account Creation Failed");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		}
	 
	 }
		
}

   


