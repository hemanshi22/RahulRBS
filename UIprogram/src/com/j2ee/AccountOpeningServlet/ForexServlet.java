package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.dao.DaoImplementation;
import com.account.model.Account;


@WebServlet("/ForexServlet")
public class ForexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
    	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
    	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		Account acc=new Account();
		
		HttpSession session= request.getSession();
		String per= (String)session.getAttribute("per");
		
		String cif=request.getParameter("cif");
		int CIF=Integer.parseInt(cif);
		String date= request.getParameter("date");
		String rec_cur=request.getParameter("selectgivingcurrency");
		System.out.println(rec_cur);
		String amt=request.getParameter("amount");
		int Amount=Integer.parseInt(amt);
		String giv_cur=request.getParameter("selectreturningcurrency");
		DaoImplementation dao=new DaoImplementation();
		int status=0;
		if(request.getParameter("selectgivingcurrency").equals("INR")){
			System.out.println(rec_cur);
			 status=dao.getSellingRate(rec_cur,giv_cur);
			 if(status!=0)
			 {    double amount=Amount/status;
				 int acc_gen=dao.ForexAccountCreated(amount, CIF, giv_cur);
				 if(acc_gen!=0)
				 {
					 out.println("FX account created successfully and the Account No is "+acc_gen);
						out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

				 }
				 else
				 {
					 out.println("Account creation failed");
						out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

				 }
			 }
		}
		else{
			status=dao.getBuyingRate(rec_cur,giv_cur);
			if(status!=0)
			 {    double amount=Amount*status;
				 int acc_gen=dao.ForexAccountCreated(amount, CIF, giv_cur);
				 if(acc_gen!=0)
				 {
					 out.println("FX account created successfully and the Account No is "+acc_gen);
						out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

				 }
				 else
				 {
					 out.println("Account creation failed");
						out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

				 }
			 }
		}
	}
}
		
		
	


