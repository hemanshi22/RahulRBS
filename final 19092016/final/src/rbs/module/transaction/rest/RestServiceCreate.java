package rbs.module.transaction.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.model.LoanTransaction;

@Path("/RestServiceCreate")
public class RestServiceCreate {
	
	DaoImplementation daoImplementation =new DaoImplementation();
	
//	@GET
//	@Path("/CreateLoanTransaction/{lt}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String CreateTransactions(@PathParam("lt")LoanTransaction lt)
//	{
//		String s=daoImplementation.CreateTransactions(lt);
//		return s;
//	}
	
	@GET
	@Path("/CreateFDTransaction/{amount}/{type}/{account_no}/{description}/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String CreateTransactions(@PathParam("amount")int amount,@PathParam("type")String type,
		@PathParam("account_no")int account_no,@PathParam("description") String description,@PathParam("emp_id")int emp_id)
	{
		String s=daoImplementation.CreateTransactions(amount,type,account_no, description, emp_id);
		return s;
	}
	
	
	@GET
	@Path("/CreateSavingsTransaction/{amount}/{account_no}/{description}/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String CreateTransactions(@PathParam("amount")int amount,@PathParam("account_no")int account_no,
			@PathParam("description") String description,@PathParam("emp_id")int emp_id)
	{
		String s=daoImplementation.CreateTransactions(amount,account_no, description, emp_id);
		return s;
		
	}
}
