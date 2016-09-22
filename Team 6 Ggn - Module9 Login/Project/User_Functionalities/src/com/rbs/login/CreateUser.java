package com.rbs.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rbs.dao.DaoImplementation;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String UserId = request.getParameter("UserId");
		
		String UserName = request.getParameter("UserName");

		DaoImplementation dao3 = new DaoImplementation();
		int return3 = 0;
		try {
			return3 = dao3.useridduplicacy(UserId);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (return3 == 0) {
			
			String Phone = request.getParameter("Phone");
			

			String Email = request.getParameter("email");
			DaoImplementation dao2 = new DaoImplementation();
			int return2 = 0;
			try {
				return2 = dao2.emailduplicacy(Email);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (return2 == 0) {
				
				String password = request.getParameter("password");
				

				int area_id = Integer.parseInt(request.getParameter("area_id"));
				int branch_id = Integer.parseInt(request.getParameter("branch_id"));
				int desk_id = Integer.parseInt(request.getParameter("desk_id"));

				int finaldesk_id = area_id * 1000 + branch_id * 100 + desk_id;
				int return1 = 0;
				DaoImplementation dao = new DaoImplementation();

				try {
					return1 = dao.insertUSER_TABLE(UserId, UserName, Phone, password, Email, finaldesk_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // call insert method

				

				if (return1 == 1) {
					String msg = "User Successfully Created";
					request.setAttribute("msg", msg);
				} else {
					String msg = "Error in User Creation";
					request.setAttribute("msg", msg);

				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
				dispatcher.forward(request, response);
			} else {
				String msg = "Email ID already exists!!";
				request.setAttribute("msg", msg);

				RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			String msg = "User ID already exists!!";
			request.setAttribute("msg", msg);

			RequestDispatcher dispatcher = request.getRequestDispatcher("User_Home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
