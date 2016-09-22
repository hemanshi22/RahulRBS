package com.j2ee.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2ee.model.LoginModel;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object loginModelObject=request.getAttribute("LM");//upcasting
		LoginModel loginModel =(LoginModel)loginModelObject;//downcasting
		
		PrintWriter out=response.getWriter();
		out.println(loginModel.getLogin());
		out.println(loginModel.getPassword());
		
		

	}

}
