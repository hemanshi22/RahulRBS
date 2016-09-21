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
import com.account.model.Account;

@WebServlet("/ForexAccountServlet")
public class ForexAccountServlet extends HttpServlet {
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
		String cif= request.getParameter("cif");
		int CIF= Integer.parseInt(cif);
		DaoImplementation dao= new DaoImplementation();
		int status=dao.searchCIF(CIF);
		if(status!=0)
		{
			out.println("Customer is valid. Procced for Account Creation");
			request.setAttribute("CIF", CIF);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/FXcreation.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			out.println("CIF is not valid");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		}
		}
	}


