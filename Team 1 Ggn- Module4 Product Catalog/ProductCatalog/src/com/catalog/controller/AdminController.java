package com.catalog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catalog.dao.implement.AccountDaoImpl;
import com.catalog.model.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user =  new User();
		String emp = request.getParameter("emp_id");
		
		if (emp != null && emp != ""){
			int empId=Integer.parseInt(request.getParameter("emp_id"));
			user.setEmpId(empId);
			user.setDeskId(0);
			user.setIsAdmin(0);
			
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			accountDaoImpl.getModuleAcess(user);
			accountDaoImpl.getModuleServiceAcess(user);
		} else {
			user.setEmpId(0);
			user.setDeskId(0);
			user.setIsAdmin(0);
		}
						
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);

	}
}
