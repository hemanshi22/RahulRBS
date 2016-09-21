package com.j2ee.AccountOpeningServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c;
		
		try
		{
			
		PrintWriter out=response.getWriter();

out.println("<html>");
out.println("<head>");
out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");  
out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");

out.println("</head>");	  
out.println("<body>");
out.println("<div align= \"center\"><h1><b>Welcome to RBS</b></h1>");
out.print("<table class=\"table table-bordered\" align= \"center\" style=\"width:900px\">");	
out.print("<tr class= 'success'>");
out.print("<td align= \"center\">");
out.print("<b>CUST_ID</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>ACC_NO</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>ACC_TYPE</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>DOO</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>INITIAL_DEPOSIT</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>NOMINEE_NAME</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>BRANCH_CODE</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>BALANCE</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>INTEREST_RATE</b>");
out.print("</td>");
out.print("<td align= \"center\">");
out.print("<b>DATE_OF_MATURITY</b>");
out.print("</td>");
out.print("</tr>");
		String accounttype=request.getParameter("accounttype");
		String accountnumber =request.getParameter("accountsearch");
		
		
		String date1=request.getParameter("d1");
		String date2=request.getParameter("d2");
	
		ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
		String arcStatus =request.getParameter("c1");
		
		
		
		SearchRestAPI sra=new SearchRestAPI();
		
		
		
		if(accounttype.isEmpty() && date1.isEmpty() && date2.isEmpty()){
			if(arcStatus==null)	{ c="0";}	
			else c="1";
			//int acc_no=Integer.parseInt(accountnumber);
			
			//int c1=Integer.parseInt(arcStatus);
			accountDetails=sra.getSearchDetails(accountnumber,c); }
		else if(accountnumber.isEmpty() && date1.isEmpty() && date2.isEmpty()){
			accountDetails=sra.getSearchDetails(accounttype); }
		else
			accountDetails=sra.getSearchDetails1(date1,date2);
		
//		for(AccountSearch var : accountDetails)
//		{
//			out.println(var.getACC_NO());
//			out.println(var.getCUST_ID());
//			out.println(var.getACC_TYPE());
//			out.println(var.getDOO());
//		}
		
		//out.println(accountDetails.size());
		
		int i=0;
		//AccountSearch ac;
		
		HttpSession session= request.getSession();
		String per= (String)session.getAttribute("per");
		for(i=0;i<accountDetails.size();i++)
		{ 
			out.println("<tr>");
			out.println("<td>");
			out.println(accountDetails.get(i).getCUST_ID());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getACC_NO());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getACC_TYPE());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getDOO());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getINITIAL_DEPOSIT());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getNOMINEE_NAME());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getBRANCH_CODE());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getBALANCE());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getINTEREST_RATE());
			out.println("</td><td>");
			out.println(accountDetails.get(i).getDATE_OF_MATURITY());
			out.println("</td></tr>");
		}
		out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

	//	System.out.println(accountDetails);
//		int i;
//		Object[] ob = accountDetails.toArray();
//		
//		for(i=0;i<accountDetails.size();i++)
//		{
//			out.println(ob[i].getACC_NO());
//			out.println(ob[i].getCUST_ID());
//			out.println(ob[i].getACC_TYPE());
//			out.println(ob[i].getDOO());
//		}		
//		
		
		

			
		} catch (Exception e)
		
		{
			System.out.println(e);
			return;
		} 
		
		
	}

}
//long acc_no=Integer.parseInt(accountnumber);

