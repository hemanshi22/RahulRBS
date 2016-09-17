package rbs.module.transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import rbs.module.transaction.rest.RestService;
@SuppressWarnings("serial")
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	//	static Date stringToDate(String value){
	//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	//		java.util.Date date = null;
	//		try {
	//			date = format.parse(value);
	//		} catch (ParseException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return new Date(date.getTime());
	//	}

	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 URL url = new URL("http://localhost:8080/Final/rest/RestService/getbyaccountnumber/1");
		 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		 connection.setRequestMethod("GET");
		
		
		
/*		PrintWriter out =response.getWriter();
		RestService d = new RestService();

		if(request.getParameter("select").equals("criteria1"))
		{
			ArrayList arr=null;
			if( request.getParameter("criteria_value")!=null)
			{
				String username = request.getParameter("criteria_value");
				int y = Integer.parseInt(username);
				ArrayList arr1 =d.getTransactions(y);
				request.setAttribute("resultSet", arr1); 
				getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
			}
			else{
				getServletConfig().getServletContext().getRequestDispatcher("/Error.html").forward(request,response);
			}
		}

		else if(request.getParameter("select").equals("criteria2"))
		{
			String username = request.getParameter("criteria_value");
			ArrayList arr =d.getTransactions(username);
			request.setAttribute("resultSet", arr); 
			getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
		}

		else if(request.getParameter("select").equals("criteria3"))
		{
			String username = request.getParameter("criteria_value");
			Date x = stringToDate(username);
			ArrayList arr =d.getTransactions(x);
			request.setAttribute("resultSet", arr); 
			getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);
		}

		else if(request.getParameter("select").equals("criteria4"))
		{   String username = request.getParameter("criteria_value");
		String username1 = request.getParameter("criteria_value1");
		Date x = stringToDate(username);
		Date y = stringToDate(username1);
		ArrayList arr =d.getTransactions(x, y);
		request.setAttribute("resultSet", arr); 
		getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);		}
*/
	}

}
