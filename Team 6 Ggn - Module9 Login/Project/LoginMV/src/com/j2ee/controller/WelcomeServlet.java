package com.j2ee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");
			int emp = (int) session.getAttribute("emp");
			out.println("<html><head></head><body>");
			out.print("Hello, " + name + " " + emp + " Welcome to Profile");
			out.print("<a href=\"Logout\">Logout</a>");
			out.println("</body></html>");

		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}

		// String n = request.getParameter("Login");
		// out.print("Welcome " + n);

		// response.sendRedirect("apiconsume.html");
		// RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
		// rd.include(request, response);

		out.close();
	}

}