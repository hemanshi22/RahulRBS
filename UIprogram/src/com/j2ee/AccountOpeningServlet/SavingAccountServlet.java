package com.j2ee.AccountOpeningServlet;
import com.account.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.dao.*;

@WebServlet("/SavingAccountServlet")
public class SavingAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		//ArrayList<Account> account=new ArrayList<Account>();
		out.println("<html><body>");
    	out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
    	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
    	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		Account acc=new Account();
		acc.setCIF(Integer.parseInt(request.getParameter("CIF")));
		
		
		 String deposit=request.getParameter("Deposit");
		 acc.setInitial_deposit(Integer.parseInt(deposit));
		 String nominee=request.getParameter("Nominee");
		 acc.setNominee(nominee);
		 HttpSession session= request.getSession();
			String per= (String)session.getAttribute("per");
		 
		 String branch =request.getParameter("selectbranch");
		 acc.setBranch_code(Integer.parseInt(branch));
		 //System.out.println(acc.getAcc_type());
		DaoImplementation dao=new DaoImplementation();
		int status=dao.getCIF(acc);
		
		if(status!=0)
		{
		   int acc_no=dao.CreateSavingAccount(acc);
		    if(acc_no!=0)
		   {		
			out.println("Account Created Successfully");
			out.println("Account Number is:" + acc_no);
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		  }
		
		   else
		    {
			out.println("Account Creation Failed");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");
		     }
		}
		else
		{
			out.println("Either the customer is already having Account or he is not a valid customer");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");
		}
		
	}
		}

	
