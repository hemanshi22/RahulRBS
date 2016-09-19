package rbs.module.transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.model.LoanTransaction;

@WebServlet("/CreateController")
public class CreateController extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		DaoImplementation d = new DaoImplementation();
		if(request.getParameter("select").equals("Loan_Disbursal"))
		{	
			//String username = request.getParameter("loan_id");
			LoanTransaction lt = new LoanTransaction();
			lt.setAccountType("LOAN");
			lt.setAmount(5000);
			lt.setLoanId(1);
			lt.setTransactionDesc("Give Loan");
			lt.setTransactionFrom(0);
			lt.setTransactionFromType("Bank");
			lt.setTransactionTo(1);
			lt.setTransactionToType("Savings");
			String output=d.CreateTransactions(lt);
			request.setAttribute("result", output); 
			getServletConfig().getServletContext().getRequestDispatcher("/CreateOutput.html").forward(request,response);
			
			
		}
		if(request.getParameter("select").equals("FD_Term"))
		{	
			String username = request.getParameter("amount");
			String username1 = request.getParameter("type");
			String username2 = request.getParameter("account_no");
			String username3 = request.getParameter("description");
			String username4 = request.getParameter("emp_id");
			int x = Integer.parseInt(username);
			int y = Integer.parseInt(username2);
			int z = Integer.parseInt(username4);
		//	out.println(d.CreateTransactions(x,username1,y,username3,z));
			String output=d.CreateTransactions(x,username1,y,username3,z);
			request.setAttribute("result", output); 
			getServletConfig().getServletContext().getRequestDispatcher("/CreateOutput.html").forward(request,response);
			
		}
		if(request.getParameter("select").equals("Saving_Transaction"))
		{	
			String username = request.getParameter("amount");
			String username1 = request.getParameter("account_no");
			String username2 = request.getParameter("description");
			String username3 = request.getParameter("empid");
			int x = Integer.parseInt(username);
			int y = Integer.parseInt(username1);
			int z = Integer.parseInt(username3);
			out.println(d.CreateTransactions(x,y,username2,z));
			String output=d.CreateTransactions(x,y,username2,z);
			request.setAttribute("result", output); 
			getServletConfig().getServletContext().getRequestDispatcher("/CreateOutput.html").forward(request,response);
			
			
		}
	}

}
