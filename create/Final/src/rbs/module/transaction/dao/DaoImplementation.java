package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;

import rbs.module.transaction.model.DematTransaction;
import rbs.module.transaction.model.DepositTransaction;
import rbs.module.transaction.model.FxTransaction;
import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.Transaction;

public class DaoImplementation implements Dao,DaoCreateTransaction {

	@Override
	public ArrayList<Transaction> getTransactions(Date date) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date= to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(date));
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
                System.out.println("Failure");        
        }
        return transactions;
}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	public ArrayList getTransactions(String accountType) {
//		ArrayList transactions = new ArrayList();
//		if(accountType.equals("LOAN")){
//			ResultSet result = getTransactionutility(accountType);
//			try {
//				while(result.next()){
//					LoanTransaction lt = new LoanTransaction();
//					lt.setTransactionId(result.getDouble(1));
//                    lt.setTransactionDate(dateToString(result.getDate(2)));
//                    lt.setTransactionType(result.getString(3));
//                    lt.setAmount(result.getDouble(4));
//                    lt.setAccountNumber(result.getDouble(5));
//                    lt.setAccountType(result.getString(6));
//                    lt.setTransactionFrom(result.getDouble(7));
//                    lt.setTransactionFromType(result.getString(8));
//                    lt.setTransactionTo(result.getDouble(10));
//                    lt.setTransactionToType(result.getString(9));
//                    lt.setTransactionDescription(result.getString(11));
//                    
//                    transactions.add(lt);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//			
//		}
//		return transactions;*/
//		return null;
//	}
	
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
	
	String dateToString(java.sql.Date d){
		return new Formatter().format("%td-%tm-%tY",d,d,d).toString();
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
					DepositTransaction t=new DepositTransaction();
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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

	public String createTransaction(LoanTransaction lt) {
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
		} catch (Exception e) {
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
				query = c.prepareStatement("BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES(?,?,?,?,?,?,?,?);\n INSERT INTO LOAN VALUES(?,?,?);\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;");
				query.setDouble(1, lt.getTransactionId());
				query.setDate(2,date);
				query.setDouble(3, lt.getTransactionFrom());
				query.setString(4, lt.getTransactionFromType());
				query.setDouble(5, lt.getTransactionTo());
				query.setString(6, lt.getTransactionToType());
				query.setDouble(7, lt.getAmount());
				query.setString(8, lt.getAccountType());
				query.setDouble(9, lt.getTransactionId());
				query.setString(10, lt.getTransactionDesc());
				query.setDouble(11, lt.getLoanId());
				query.execute();
				c.close();
				out = "Success";
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
	public String CreateTransactions(LoanTransaction lt) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String CreateTransactions(int amount, String type, int account_no, String description, int empid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String CreateTransactions(int amount, int account_no, String description, int empid) {
		// TODO Auto-generated method stub
		return null;
	}
}

