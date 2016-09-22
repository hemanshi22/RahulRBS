package com.j2ee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j2ee.model.LoginDao1;

@WebServlet("/Home")
public class Home extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		String n = request.getParameter("Login");
		String p = request.getParameter("Password");

		if (LoginDao1.validate(n, p)) {
			int emp = LoginDao1.getEmpid(n, p);
			String Name = LoginDao1.getEmpName(n, p);
			HttpSession session = request.getSession();

			session.setAttribute("name", n);
			session.setAttribute("emp", emp);
			session.setAttribute("Name", Name);



			RequestDispatcher rd = request.getRequestDispatcher("Landingpage.html");
			rd.include(request, response);



		} else {
			response.sendRedirect("Login.html?wp=true");
		}


	}
}

