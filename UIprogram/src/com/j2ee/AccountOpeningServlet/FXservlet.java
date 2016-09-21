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

@WebServlet("/FXservlet")
public class FXservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
    	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
    	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		Account acc=new Account();
		HttpSession session= request.getSession();
		String per= (String)session.getAttribute("per");
		
		acc.setCIF(Integer.parseInt(request.getParameter("CIF")));

		String deposit = request.getParameter("Deposit");
		acc.setInitial_deposit(Integer.parseInt(deposit));
		String nominee = request.getParameter("Nominee");
		acc.setNominee(nominee);

		String branch = request.getParameter("selectbranch");
		acc.setBranch_code(Integer.parseInt(branch));
		DaoImplementation dao = new DaoImplementation();

		int validcif = dao.getCIF(acc);
		if (validcif != 0) {

			int status = dao.addForexAccount(acc);
			if (status != 0) {
				out.println("Forex Account has been Created Successfully and the Account Number is" + status);
				out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

			}

		} else {
			out.println("Account creation failed");
			out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

		}

	}
}
