package com.j2ee.AccountOpeningServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class Medium
 */
@WebServlet("/Medium")
public class Medium extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		  {
			    int eid=Integer.parseInt(request.getParameter("emp_id"));
	    		Client client1=Client.create();
	    		WebResource webResource1 = client1.resource("http://103.62.238.195:8080/BankStructServices/rest/ModuleService/getModule?emp_id="+eid);
	    		//WebResource webResource1 = client1.resource("http://103.62.238.195:8080/BankStructServices/rest/ModuleService/getModule?emp_id="+eid);
	    		ClientResponse response3 = webResource1.accept("application/json").get(ClientResponse.class);
	    		String desk=response3.getEntity(String.class);
	    		JSONParser parser2=new JSONParser();
	    		Object obj2=parser2.parse(desk);
	    		JSONObject jsonobject2=(JSONObject)obj2;
	    		Long desk_id=(Long)jsonobject2.get("desk_id");
	    		System.out.println(desk_id);
	    		
	    		Client client2=Client.create();
	    		WebResource webResource2 = client2.resource("http://103.62.238.195:8080/BankStructServices/rest/RightsService/getRights?desk_id="+desk_id+"&mod=AO");
	    		//WebResource webResource2 = client2.resource("http://103.62.238.195:8080/BankStructServices/rest/RightsService/getRights?desk_id="+desk_id+"&mod=AO");
	    		ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
	    		String permissions_JSON = response2.getEntity(String.class);
	    		JSONParser parser1 = new JSONParser();
	            Object obj1 = parser1.parse(permissions_JSON);
	            JSONObject jsonObject1 = (JSONObject) obj1;
	            Long get_permissions = (Long) jsonObject1.get("get");
	            Long put_permissions = (Long) jsonObject1.get("put");
	            Long post_permissions = (Long) jsonObject1.get("post");
	            Long delete_permissions = (Long) jsonObject1.get("del");
			    /*Long get_permissions=(long) 1;
			    Long put_permissions=(long) 1;
			    Long post_permissions=(long) 1;
			    Long delete_permissions=(long) 1;*/
	            System.out.println(get_permissions);
	            
	            if(get_permissions==1&&put_permissions==0&&post_permissions==0&&delete_permissions==0)
	            {
	            	System.out.println("yeah");
	            	request.setAttribute("case", "1000");
	            	HttpSession session= request.getSession();
	            	session.setAttribute("per","1000");  
	    	        RequestDispatcher rd=request.getRequestDispatcher("Cond.jsp");
	    	        rd.forward(request, response);
	            }
	            else if(get_permissions==0&&put_permissions==0&&post_permissions==0&&delete_permissions==0)
	            {
	            	System.out.println("lol");
	            	request.setAttribute("case", "0000");
	            	HttpSession session= request.getSession();
	            	session.setAttribute("per","0000");
	    	        RequestDispatcher rd=request.getRequestDispatcher("Cond.jsp");
	    	        rd.forward(request, response);
	            }
	            else if(get_permissions==1&&put_permissions==1&&post_permissions==1&&delete_permissions==1)
	            {
	            	request.setAttribute("case", "1111");
	            	HttpSession session= request.getSession();
	            	session.setAttribute("per","1111");
	            	RequestDispatcher rd=request.getRequestDispatcher("Cond.jsp");
		    	    rd.forward(request, response);
	            }
		  }
		  catch (Exception e) 
		  {
		            e.printStackTrace();
		  }
	}

}
