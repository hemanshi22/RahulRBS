package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.dao.DaoImplementation;
import com.account.model.Account;
import com.account.model.Article;


@WebServlet("/FD2Servlet")
public class FD2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		Account Acc=new Account();
		out.println("<html><body>");
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
    	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
    	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		Account acc=new Account();
		HttpSession session= request.getSession();
		String per= (String)session.getAttribute("per");
	       DaoImplementation dao=new DaoImplementation();
	    String deposit=request.getParameter("Deposit"); 
	    String date1=null;
	    String date=request.getParameter("date");
	 
	   String period=request.getParameter("period");
		int Period=Integer.parseInt(period);
		
		
		String nominee=request.getParameter("nominee");
		
		Acc.setNominee(nominee);
		int Deposit=Integer.parseInt(deposit);
		
		
		
		String int_rate=request.getParameter("title");
		String acc_nos=request.getParameter("id");
		int acc_no=Integer.parseInt(acc_nos);
		
		System.out.println(int_rate);
		System.out.println(acc_no);
		Acc.setInitial_deposit(Deposit);
		double Int_rate=Double.parseDouble(int_rate);
		Acc.setInt_rate(Int_rate);
		Acc.setAccountNumber(acc_no);
		
		int status1=dao.addFDaccount(Acc,Period);
		
		if(status1!=0){
			out.println("FD has been created successfully and the ACC_NO is"+status1+"");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		}
		else
		{
			out.println("Account Creation Failed");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		}
		
	}

}
