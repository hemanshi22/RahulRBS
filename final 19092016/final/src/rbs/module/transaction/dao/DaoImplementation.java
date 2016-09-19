package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;

import rbs.module.transaction.model.DematTransaction;
import rbs.module.transaction.model.FxTransaction;
import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.SavingsTransaction;
import rbs.module.transaction.model.TermDepositTransaction;
import rbs.module.transaction.model.Transaction;

public class DaoImplementation implements DaoGet,DaoPost {

	@Override
	public ArrayList<Transaction> getTransactions(Date date) {

		ArrayList<Transaction> transaction = new ArrayList<Transaction>();

		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date= to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(date));
			ResultSet result  =  query.executeQuery();
=
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
				transaction.add(t);
			} 		
			c.close();
		}
		catch (Exception e) {
			System.out.println(e);	
		}
		return transaction;
	}		
	public ArrayList<Transaction> getTransactions(double accountnumber) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{        
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where account_from=? or account_to=?");     
			query.setDouble(1, accountnumber);
			query.setDouble(2, accountnumber);
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
	ResultSet getTransactionUtility(String accountType){
		ResultSet result=null; 
		try{        
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction join "+accountType+" using(trans_id)");     
			result = query.executeQuery();
		}
		catch (Exception e) {
			System.out.println("Failure");        
		}
		return result;
	}	
	@Override
	public ArrayList<Transaction> getTransactions(Date start, Date end) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date between to_date(?,'dd-mm-yyyy') and to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(start));
			query.setString(2, dateToString(end));
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
			System.out.println("failure");	
		}
		return transactions;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList getTransactions(String accountType) {
		ArrayList transactions = new ArrayList();
		if(accountType.equals("LOAN")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					LoanTransaction t=new LoanTransaction();
					t.setTransactionId(result.getDouble(1));

					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setTransactionDesc(result.getString(9));
					t.setLoanId(result.getInt(10));

					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}

		else if(accountType.equals("DEPOSIT")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					TermDepositTransaction t=new TermDepositTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setTransactionDesc(result.getString(9));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}

		else if(accountType.equals("FX")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					FxTransaction t=new FxTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setCurrencyFrom(result.getString(9));
					t.setCurrencyTo(result.getString(10));
					t.setRate(result.getDouble(11));
					transactions.add(t);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 		
		}

		else if(accountType.equals("DEMAT")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					DematTransaction t=new DematTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setScript(result.getString(9));
					t.setUnits(result.getDouble(10));
					t.setUnitCost(result.getDouble(11));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}

		return transactions;
	}

	@Override
	public String CreateTransactions(LoanTransaction lt) {
		String out = null;
		Date date = new Date(Calendar.getInstance().getTime().getTime());

		boolean valid = true;

		//Check for holiday for today's date

		//Check Approval
		Connection c;
		PreparedStatement query;
		ResultSet result;
		try {
			c = DatabaseConnection.getConnection();
			query = c.prepareStatement("select status from loan_approval where loan_id=?");
			query.setDouble(1, lt.getLoanId());
			result = query.executeQuery();
			result.next();
			if(!(result.getString(1)).equals("Y"))
				valid = false;
			c.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Check Permissions and update valid

		//Create Transaction
		if(valid){

			try {
				//Creating Transaction Id
				c = DatabaseConnection.getConnection();
				query = c.prepareStatement("select MAX(TRANS_ID) from TRANSACTION");
				result = query.executeQuery();
				result.next();
				lt.setTransactionId(result.getDouble(1) + 1);

				//Creating Transaction


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}
		else
			out = "Failure";

		return out;
	}
	
	@Override
	public String CreateTransactions(int amount,String type, int account_no, String description,int emp_id) {
		try {
			LocalDate ldt = LocalDate.now();
			String mydate = ldt.toString();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date date = format1.parse(mydate);
			String newdate = format2.format(date);
			//boolean isvalid = callAPI(mydate,country);
			//if(isvalid){}
			//else{return "Is not a valid date"
			//}
			boolean isvalid = true;
			if (isvalid){
				//JSONObject obj3 = new JSONObject();
				//obj3 = bankstructuresAPI(emp_id);
				//String permissions = obj3.getString(create_permissions);
				//int amount_allowed = obj3.getInt(amount_allowed);
				String permissions = "allowed"; 
				int amount_allowed = 100000;
				if(permissions.equalsIgnoreCase("allowed")&&amount_allowed>=amount&&amount>=0)
				{
					// TODO Auto-generated method stub
					//JSONObject obj = new JSONObject();
					//obj = callAPI(account_no);
					//int length = obj.length()
					int length = 10;
					if(length!=0)
					{
						
						//**************
						//Changed from DepositTransaction to SavingsTransaction as table name has changed
						//**************
						SavingsTransaction dep = new SavingsTransaction();			
						//will refer to accounts team API to get account details

						Connection c = DatabaseConnection.getConnection();
						//transaction id should be auto incremented and assigned from DB
						String statement = "select MAX(TRANS_ID) from TRANSACTION";
						PreparedStatement query3 = c.prepareStatement(statement);
						ResultSet result_2 = query3.executeQuery();
						result_2.next();
						int trans = result_2.getInt(1) + 1;

						dep.setTransactionDate(mydate);
						if(type.equals("deposit"))
						{
							dep.setTransactionTo(account_no);
							dep.setTransactionToType("SB");
							dep.setAmount(amount);
							dep.setAccountType("Deposit");
							dep.setTransactionDesc("Deposit");

							//boolean happened = updatebalance(account_no,amount);
							String stmt = "BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES("+trans+",'"+newdate+"',"+dep.getTransactionFrom()+",'"+dep.getTransactionFromType()+"',"+dep.getTransactionTo()+",'"+dep.getTransactionToType()+"',"+dep.getAmount()+",'"+dep.getAccountType()+"');\n INSERT INTO DEPOSIT VALUES("+trans+",'"+dep.getTransactionDesc()+"');\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;";

							//String stmt2 = "INSERT INTO TRANSACTION VALUES("+dep.getTransactionId()+","+dep.getTransactionDesc();
							PreparedStatement query = c.prepareStatement(stmt);
							System.out.println(stmt);
							//PreparedStatement query2 = c.prepareStatement(stmt2);
							query.executeQuery();
							//ResultSet result2 = query2.executeQuery();
						}
						else if (type.equals("withdrawal"))
						{
							dep.setTransactionFrom(account_no);
							dep.setTransactionFromType("SB");
							dep.setAmount(amount);
							dep.setAccountType("Deposit");
							dep.setTransactionDesc("Withdrawal");
							String stmt = "BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES("+trans+",'"+newdate+"',"+dep.getTransactionFrom()+",'"+dep.getTransactionFromType()+"',"+dep.getTransactionTo()+",'"+dep.getTransactionToType()+"',"+dep.getAmount()+",'"+dep.getAccountType()+"');\n INSERT INTO DEPOSIT VALUES("+trans+",'"+dep.getTransactionDesc()+"');\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;";
							//boolean happened = updatebalance(account_no,(-amount));
							//String stmt = "insert into Transaction values("+dep.getTransactionId()+","+dep.getTransactionDate()+","+dep.getTransactionFrom()+","+dep.getTransactionFromType()+","+dep.getTransactionTo()+","+dep.getTransactionToType()+","+dep.getAmount()+","+dep.getAccountType();
							//String stmt2 = "insert into Deposit values("+dep.getTransactionId()+","+dep.getTransactionDesc();
							PreparedStatement query = c.prepareStatement(stmt);
							//PreparedStatement query2 = c.prepareStatement(stmt2);
							System.out.println(stmt);

							ResultSet result = query.executeQuery();
							//ResultSet result2 = query2.executeQuery();
						}
						c.close();
						return "create successful";
					}
					else{
						return "Account number doesn't exist";
					}
				}
				else{
					return "You don't have the required permissions";
				}

			}
			else{
				return "The date is not correct";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String CreateTransactions(int amount, int account_no, String description, int empid) {
		try {

			//Obtain today's date

			LocalDate ldt = LocalDate.now();
			String mydate = ldt.toString();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date date = format1.parse(mydate);
			String newdate = format2.format(date);

			//Is today a holiday

			//boolean isvalid = callAPI(mydate,country);
			//if(isvalid){}
			//else{return "Is not a valid date"
			//}
			boolean isvalid = true;
			if (isvalid){

				//DO YOU HAVE THE REQUIRED PERMISSIONS TO CREATE THIS TRANSACTION

				//JSONObject obj3 = new JSONObject();
				//obj3 = bankstructuresAPI(emp_id);
				//String permissions = obj3.getString(create_permissions);
				//int amount_allowed = obj3.getInt(amount_allowed);
				String permissions = "allowed"; 
				int amount_allowed = 10000;
				if(permissions.equalsIgnoreCase("allowed")&&amount_allowed>=amount&&amount>=0)
				{
					//DOES THE ENTERED BANK ACCOUNT EXIST

					//JSONObject obj = new JSONObject();
					//obj = callAPI(account_no);
					//int length = obj.length()
					int length = 10;
					if(length!=0)
					{
						//CREATE A DEPOSIT TRANSACTION CLASS METHOD

						SavingsTransaction dep = new SavingsTransaction();
						//will refer to accounts team API to get account details

						Connection c = DatabaseConnection.getConnection();

						String statement = "select MAX(TRANS_ID) from TRANSACTION";
						PreparedStatement query3 = c.prepareStatement(statement);
						ResultSet result_2 = query3.executeQuery();
						result_2.next();
						int trans = result_2.getInt(1) + 1;
						//transaction id should be auto incremented and assigned from DB


						dep.setTransactionDate(newdate);	
						dep.setTransactionTo(account_no);
						dep.setTransactionToType("SB");
						dep.setTransactionFrom(0);
						dep.setTransactionFromType("SB");
						dep.setAmount(amount);
						dep.setAccountType("Deposit");
						dep.setTransactionDesc("Deposit");

						//boolean happened = updatebalance(account_no,amount);
						String stmt = "BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES("+trans+",'"+newdate+"',"+dep.getTransactionFrom()+",'"+dep.getTransactionFromType()+"',"+dep.getTransactionTo()+",'"+dep.getTransactionToType()+"',"+dep.getAmount()+",'"+dep.getAccountType()+"');\n INSERT INTO DEPOSIT VALUES("+trans+",'"+dep.getTransactionDesc()+"');\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;";

						//String stmt2 = "INSERT INTO TRANSACTION VALUES("+dep.getTransactionId()+","+dep.getTransactionDesc();
						PreparedStatement query = c.prepareStatement(stmt);
						System.out.println(stmt);
						//PreparedStatement query2 = c.prepareStatement(stmt2);
						query.executeQuery();
						//ResultSet result2 = query2.executeQuery();
						c.close();
						return "create successful";

					}
					else{
						return "Account number doesn't exist";
					}
				}
				else{
					return "You don't have the required permissions";
				}

			}
			else{
				return "The date is not correct";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	String dateToString(java.sql.Date d){
		return new Formatter().format("%td-%tm-%tY",d,d,d).toString();
	}	
}
