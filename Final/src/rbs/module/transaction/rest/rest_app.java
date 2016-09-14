package rbs.module.transaction.rest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import rbs.module.transaction.dao.DatabaseConnection;
import rbs.module.transaction.model.Transaction;

@Path("/rest_app")
public class rest_app {

	@GET
	@Path("/transactions")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Transaction> getTransactions() {
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction --where trans_date= to_date(?,'dd-mm-yyyy')");
			//query.setString(1, date);
    		ResultSet result = query.executeQuery();
    		
    		while(result.next()){
    			Transaction t=new Transaction();
    			
    			t.setTransactionId(result.getDouble(1));
    			t.setTransactionDate(dateToString(result.getDate(2)));	
    			t.setTransactionFrom(result.getDouble(3));
    			t.setTransactionFromType(result.getString(4));
    			t.setTransactionTo(result.getDouble(5));
    			t.setTransactionToType(result.getString(6));
    			t.setAmount(result.getDouble(7));
    			t.setAccountType(result.getString(8));
    			transactions.add(t);
    		} 		
    		c.close();
		}
		catch (Exception e) {
			System.out.println(e);	
		}
		return transactions;
	}

	private String dateToString(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
