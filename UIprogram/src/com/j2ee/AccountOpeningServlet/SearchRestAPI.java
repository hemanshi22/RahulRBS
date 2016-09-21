package com.j2ee.AccountOpeningServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.account.dao.*;
import org.json.simple.JSONObject;


@Path("/rest_app")
public class SearchRestAPI {

	@GET
	@Path("/getSearchDetails/{ACC_NO}/{C1}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<AccountSearch> getSearchDetails(@PathParam("ACC_NO") String ACC_NO,@PathParam("C1") String c1) {
		ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
		
		searchDaoImplementation sdi =new searchDaoImplementation();
		accountDetails=sdi.getSearchDetails(Integer.parseInt(ACC_NO),Integer.parseInt(c1));
		return accountDetails;  		
	}
	
	@GET
	@Path("/getSearchDetails/{ACC_TYPE}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<AccountSearch> getSearchDetails(@PathParam("ACC_TYPE") String ACC_TYPE) {
	       ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
	       //System.out.println(ACC_TYPE);
	       searchDaoImplementation sdi =new searchDaoImplementation();
		   accountDetails=sdi.getSearchDetails(ACC_TYPE);		   
		   return accountDetails;
	}
	
	
	@GET
	@Path("/getSearchDetails1/{DATE1}/{DATE2}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<AccountSearch> getSearchDetails1(@PathParam("DATE1") String DATE1,@PathParam("DATE2") String DATE2) {
	       ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
	       searchDaoImplementation sdi =new searchDaoImplementation();
		   accountDetails=sdi.getSearchDetails1(DATE1,DATE2);
	       return accountDetails;
	}
	
	@POST
	@Path("/pass_cif")
	@Consumes("application/json")
	public Response passcif(JSONObject jsonobject)
	{
		//int result=(int)jsonobject.get("CIF");
		int cif_to_be_stored=(int)jsonobject.get("CIF");
		System.out.println(cif_to_be_stored);
		String result="Success";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb","scott", "rbs");
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:8080:rbsdb","admin", "rbs");		
			Statement stmt=connection.createStatement();
			//stmt.executeUpdate("INSERT INTO")
			//int cif=Integer.parseInt(cif_to_be_stored);
			int cif=cif_to_be_stored;
			ResultSet rs=stmt.executeQuery("Insert into acc_create_pending(cust_id) values(" + cif +")");
			System.out.println("YESSSSSSS");
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(201).entity(result).build();
	}
	@POST
	@Path("/delete_cust")
	@Consumes("application/json")
	public Response deletecust(JSONObject jsonobject)
	{
		int cif_to_be_deleted=(int)jsonobject.get("CIF");
		String result="Success";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb","scott", "rbs");
					
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:8080:rbsdb","admin", "rbs");		
			
			Statement stmt=connection.createStatement();
			//stmt.executeUpdate("DELETE FROM CUSTOMER")
			int cif=cif_to_be_deleted;
			ResultSet rs=stmt.executeQuery("update ACCOUNT_DETAILS set archived_status=1 where CUST_ID="+cif);			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(201).entity(result).build();
	}
	
//	@POST
//	@Path("/update_balance")
//	@Consumes("application/json")
//	public Response updatebalance(JSONObject jsonobject)
//	{
//		String Type=(String)jsonobject.get("description");
//		int amount=(int)jsonobject.get("amount");
//		//int amt=Integer.parseInt(amount);
//		int account_no=(int)jsonobject.get("account_no");
//		//int accno=Integer.parseInt(account_no);
//		try
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb",
//					"scott", "rbs");
//			Statement stmt=connection.createStatement();
//			//stmt.executeUpdate("DELETE FROM CUSTOMER")
//			ResultSet rs=null;
//			if(Type.equals("-"))
//				rs=stmt.executeQuery("update account_details set balance=balance-"+amount+" where acc_no="+account_no);
//			if(Type.equals("+"))
//				rs=stmt.executeQuery("update account_details set balance=balance+"+amount+" where acc_no="+account_no);
//									
//			connection.close();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return Response.status(201).entity(Type).build();
//	}
	@POST
	@Path("/update_balance")
	public Response CreateTransactions(@FormParam("amount") int amount,@FormParam("account_no") int account_no,@FormParam("description") String description)
	{

		String Type=description;
		int amt=amount;
		
		int account_no1=account_no;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb","scott", "rbs");
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:8080:rbsdb","admin", "rbs");			
			Statement stmt=connection.createStatement();
			//stmt.executeUpdate("DELETE FROM CUSTOMER")
			ResultSet rs=null;
			if(Type.equals("-"))
				rs=stmt.executeQuery("update account_details set balance=balance-"+amt+" where acc_no="+account_no1);
			if(Type.equals("+"))
				rs=stmt.executeQuery("update account_details set balance=balance+"+amt+" where acc_no="+account_no1);
									
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(201).entity(Type).build();

	

	}
	}
	
	

	
	

