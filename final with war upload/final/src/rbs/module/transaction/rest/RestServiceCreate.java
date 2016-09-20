package rbs.module.transaction.rest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.dao.DatabaseConnection;
import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.SavingsTransaction;
import rbs.module.transaction.model.TermDepositTransaction;
import rbs.module.transaction.model.Transaction;

@Path("/RestServiceCreate")
public class RestServiceCreate {

	DaoImplementation daoImplementation =new DaoImplementation();

	//	@POST
	//	@Path("/CreateLoanTransaction/{lt}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public String CreateTransactions(@PathParam("lt")LoanTransaction lt)
	//	{
	//		String s=daoImplementation.CreateTransactions(lt);
	//		return s;
	//	}

	@POST
	@Path("/CreateSavingsTransaction")
	public String CreateTransactions(@FormParam("amount") int amount,@FormParam("type") String type,
			@FormParam("account_no") int account_no,@FormParam("description") String description,@FormParam("acc_type") String acc_type)
	{

		System.out.println(acc_type);
		SavingsTransaction st = new SavingsTransaction();
		st.setAmount(amount);
		st.setAccountType("SAVINGS");
		st.setTransactionDesc(type);

		if(description.equalsIgnoreCase("deposit")){
			st.setTransactionTo(account_no);
			st.setTransactionFrom(0);
			st.setTransactionFromType("Bank");
			st.setTransactionToType(acc_type);
		}
		else if(description.equalsIgnoreCase("withdrawal")){
			st.setTransactionFrom(account_no);
			st.setTransactionTo(0);
			st.setTransactionFromType(acc_type);
			st.setTransactionToType("Person");
		}
		String s=daoImplementation.CreateTransactions(st);

		return s;

	}

	@POST
	@Path("/CreateFDTransaction")
	public String CreateTransactions(@FormParam("amount")int amount,@FormParam("account_no")int account_no,
			@FormParam("description") String description)
	{
		TermDepositTransaction st = new TermDepositTransaction();
		st.setAmount(amount);
		st.setAccountType("TERM_DEPOSIT");
		st.setTransactionDesc(description);
		st.setTransactionTo(account_no);
		st.setTransactionFrom(0);
		st.setTransactionFromType("Bank");
		st.setTransactionToType("Savings");
		st.setRate(4);
		String s=daoImplementation.CreateTransactions(st);

		return s;

	}

	@POST
	@Path("/CreateLoanTransaction")
	public String CreateTransactions(@FormParam("loan_id")int loan_id) throws Exception
	{
		System.out.println("enter");
		LoanTransaction lt= new LoanTransaction();
		lt.setLoanId(-1);
		Connection c = DatabaseConnection.getConnection();
		//transaction id should be auto incremented and assigned from DB



		PreparedStatement query = c.prepareStatement("select * from loan where loan_id=?");
		query.setDouble(1, loan_id);
		ResultSet result = query.executeQuery();
		if(result.next()){
			return "Loan Already Exists from the same Loan id";
		}
		else{
			query = c.prepareStatement("select * from loan_approval where loan_id=? and status='N'");
			query.setDouble(1, loan_id);
			result = query.executeQuery();
			if(result.next()){
				return "Approval is Pending"; 
			}
			else{
				query = c.prepareStatement("select * from loan_approval where loan_id=? and status='Y'");
				query.setDouble(1, loan_id);
				result = query.executeQuery();
				if(result.next())
				{
					lt.setLoanId(result.getInt(1));
					lt.setAmount(result.getDouble(4));
					lt.setTransactionTo(result.getDouble(3));
					lt.setTransactionToType("Savings");
					lt.setTransactionFrom(0);
					lt.setTransactionFromType("Bank");
					lt.setAccountType("LOAN");
					lt.setTransactionDesc("Approved");

					DaoImplementation d = new DaoImplementation();
					d.CreateTransactions(lt);
					return "transaction created";
				}
				else{
					return "Loan doesn't exist, please apply";
				}
			}

		}

		//		PreparedStatement query2 = c.prepareStatement("select * from loan_approval where loan_id=? and status='N'");
		//		query2.setDouble(1, loan_id);
		//		ResultSet result2 = query.executeQuery();
		//		if(result1.next())
		//		{
		//			return "Loan Already Exists from the same Loan id";
		//		}
		//		else
		//		{
		//			if(result2.next()){
		//				return "Loan Request Pending";
		//			}
		//			else if(result.next()){
		//
		//					lt.setLoanId(result.getInt(1));
		//					lt.setAmount(result.getDouble(4));
		//					lt.setTransactionTo(result.getDouble(3));
		//					lt.setTransactionToType("Savings");
		//					lt.setTransactionFrom(0);
		//					lt.setTransactionFromType("Bank");
		//					lt.setAccountType("LOAN");
		//					lt.setTransactionDesc("Approved");
		//
		//				DaoImplementation d = new DaoImplementation();
		//				if(lt.getLoanId()==-1)
		//					return "failure";
		//				else
		//					d.CreateTransactions(lt);
		//				return "transaction created";
		//			}
		//			else{
		//				return "apply for a loan";
		//			}

	}

public ArrayList<Transaction> LoanDetails(int loan_id)
{
	ArrayList<Transaction> arr =new ArrayList<Transaction>();


	return null;

}

}



