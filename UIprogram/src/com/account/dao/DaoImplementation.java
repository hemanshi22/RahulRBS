package com.account.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.account.model.Account;

import com.account.dao.DatabaseConnection;
import com.account.dao.DatabaseConnection1;



public class DaoImplementation implements Dao {

	@Override
	public ArrayList<Account> getResults(int accountNumber)
	{
		// TODO Auto-generated method stub
		ArrayList<Account> account = new ArrayList<Account>();
		return account;
	}
	public int getCIF(Account acc)
	{
		try
		{   
			 int acc_no=0;
			Connection c = DatabaseConnection.getConnection();
        Statement st=c.createStatement();
        ResultSet result=st.executeQuery("select *from Acc_create_pending where cust_id="+acc.getCIF());
        while(result.next())
        {
        	ResultSet r=st.executeQuery("delete from Acc_create_pending where  CUST_ID ="+acc.getCIF());
        	return 1;
        	
        }
        }catch (Exception e) {
            System.out.println(e);        
        }
        //System.out.println(accounts.get(0));
        		return 0;
        	}
        
	
	public int CreateSavingAccount(Account acc)
	{
		try
		{   System.out.println(acc.getCIF());
			 int acc_no=0;
			Connection c = DatabaseConnection.getConnection();
        Statement st=c.createStatement();
        
        
        ResultSet res = st.executeQuery("SELECT MAX(ACC_NO) FROM Account_Details");
		while (res.next()) {
			acc_no = res.getInt(1) + 1;
		}
		
        ResultSet result = st.executeQuery("INSERT INTO ACCOUNT_DETAILS (CUST_ID,ACC_NO,ACC_TYPE,DOO,INITIAL_DEPOSIT,NOMINEE_NAME,BRANCH_CODE,BALANCE,Interest_rate,ARCHIVED_STATUS) VALUES("+ acc.getCIF() + "," + acc_no +",'SAVINGS',sysdate,"+ acc.getInitial_deposit()+",'" + acc.getNominee() + "'," +acc.getBranch_code()+","+ acc.getInitial_deposit()+",4.0,0)" );
        //" + acc.CIF + "," + acc.acc_no +"," + acc.acc_type + "," + acc.date_of_open + "," + initial_deposit + "," + branch_code );
        
        if(result.next())
        {	
        	return acc_no;
        }
        
        
    c.close();
    
}
catch (Exception e) {
        System.out.println(e);        
}
//System.out.println(accounts.get(0));
		return 0;
	}
	
	public int CreateCurrentAccount(Account acc)
	{
		try
		{   
			 int acc_no=0;
			Connection c = DatabaseConnection.getConnection();
        Statement st=c.createStatement();
        
        
        ResultSet res = st.executeQuery("SELECT MAX(ACC_NO) FROM Account_Details");
		while (res.next()) {
			acc_no = res.getInt(1) + 1;
		}
		
        ResultSet result = st.executeQuery("INSERT INTO ACCOUNT_DETAILS (CUST_ID,ACC_NO,ACC_TYPE,DOO,INITIAL_DEPOSIT,NOMINEE_NAME,BRANCH_CODE,BALANCE,ARCHIVED_STATUS) VALUES("+ acc.getCIF() + "," + acc_no +",'CURRENT',sysdate," + acc.getInitial_deposit()+ ",'" + acc.getNominee() + "'," +acc.getBranch_code()+","+acc.getInitial_deposit()+",0)" );
        //" + acc.CIF + "," + acc.acc_no +"," + acc.acc_type + "," + acc.date_of_open + "," + initial_deposit + "," + branch_code );
        
        if(result.next())
        {	
        	return acc_no;
        }
        
        
    c.close();
    
}
catch (Exception e) {
        System.out.println(e);        
}
//System.out.println(accounts.get(0));
		return 0;
	}
	public int addFDaccount(Account acc, int Period)
	{
		try
		{   int cif=0;
		int brn_code=0;
			 int acc_no=0;
			 System.out.println(acc_no);
			Connection c = DatabaseConnection.getConnection();
        Statement st=c.createStatement();
        
        
        ResultSet res = st.executeQuery("SELECT MAX(ACC_NO) FROM Account_Details");
		while (res.next()) {
			acc_no = res.getInt(1) + 1;
			System.out.println(acc_no);
			
		}
		 ResultSet r= st.executeQuery("Select CUST_ID from Account_Details where ACC_NO="+acc.getAccountNumber()+"");
		 while(r.next())
		 {
			 cif=r.getInt(1);
			 System.out.println(cif);
		 }
		 
		 ResultSet r1= st.executeQuery("Select Branch_code from Account_details where ACC_NO="+acc.getAccountNumber()+"");
		 while(r1.next())
		 {
			 brn_code=r1.getInt(1);
			 System.out.println(brn_code);
		 }
		
		 String type="FD";
		ResultSet resultset= st.executeQuery("INSERT INTO ACCOUNT_DETAILS (CUST_ID,ACC_NO,ACC_TYPE,DOO,INITIAL_DEPOSIT,NOMINEE_NAME,BRANCH_CODE,BALANCE,Interest_rate,Date_of_maturity,Archived_status)values("+cif+","+acc_no+",'"+type+"',sysdate,"+ acc.getInitial_deposit()+",'" +acc.getNominee()+"',"+brn_code+","+ acc.getInitial_deposit()+","+acc.getInt_rate()+",sysdate+"+Period+",0)");
		 if(resultset.next())
	        {//	System.out.println(resultset.getString(3));
	        	return acc_no;
	        }
		c.close();
	    }
		catch (Exception e) {
	        System.out.println(e);        
		}
		//System.out.println(accounts.get(0));
				return 0;
			
		
	}
	
	public int SearchAccount(int ACC_NO)
	{
		try{
			Connection c = DatabaseConnection.getConnection();
	        Statement st=c.createStatement();
	        ResultSet resultset= st.executeQuery("select ACC_TYPE from Account_Details where ACC_NO= "+ACC_NO);
	        //System.out.println(ACC_NO);
	        while(resultset.next())
	        {
	        	System.out.println(resultset.getString(1));
	        	if(resultset.getString(1).equals("SAVINGS")){
	        		return 1;
	        	}
	        	else
	        	{
	        		return 0;
	        	}
	        }
			
			
		}catch (Exception e) {
	        System.out.println(e);        
		}
		return 0;
	}
	
	public String fetchInterestRate(){
		
		try{
			double int_rate=0;
			String fd_rate=null;
		Connection c= DatabaseConnection.getConnection();
		Statement st = c.createStatement();
		ResultSet resultset=st.executeQuery("Select Int_rate from Deposits where DEPOSIT_TYPE='Fixed Deposit'");
		while(resultset.next())
		{
			int_rate=resultset.getDouble(1);
			System.out.println(int_rate);
			fd_rate=Double.toString(int_rate);
			return fd_rate;
		}
		}catch (Exception e) {
	        System.out.println(e);        
		}
		return null;
		
	}
	
	public int searchCIF(int cif)
	{
		try
		{
			Connection c= DatabaseConnection.getConnection();
			Statement st = c.createStatement();
			ResultSet res=st.executeQuery("Select *FROM ACC_CREATE_PENDING where cust_id="+cif+"");
			while (res.next())
			{
				return cif;
			}
			
		
		}catch (Exception e) {
	        System.out.println(e);
		}
		return 0;
	}
	public int getSellingRate(String Curr_in,String Curr_out)
	{
		try
		{
			Connection c= DatabaseConnection1.getConnection();
			Statement st = c.createStatement();
			ResultSet res=st.executeQuery("Select Exchange_rate from Exchange_rate where In_cur='"+Curr_out+"'");
			while(res.next())
			{
				System.out.println(res.getInt(1));
				return res.getInt(1);
		    }
			}catch (Exception e) {
		        System.out.println(e);
			}
			return 0;
	}
	public int getBuyingRate(String Curr_in,String Curr_out){
		try
	     {
		Connection c= DatabaseConnection.getConnection();
		Statement st = c.createStatement();
		ResultSet res=st.executeQuery("Select Exchange_rate from Exchange_rate where In_cur='"+Curr_in+"'");
		while(res.next())
		{
			return res.getInt(1);
	    }
		}catch (Exception e) {
	        System.out.println(e);
		}
		return 0;
		}
	public int ForexAccountCreated(double amount,int cif, String curr)
	{
		try
	     {
			int acc_no=0;
			int acc_gen=0;
		Connection c= DatabaseConnection1.getConnection();
		Statement st = c.createStatement();
		 ResultSet res = st.executeQuery("SELECT MAX(ACC_NO) FROM Forex_account");
			while (res.next()) 
			{
		       acc_no=res.getInt(1)+1;
		       System.out.println(acc_no);
		       return acc_no;
		       
		    }
			
			ResultSet rs=st.executeQuery("Insert into Forex_Account(ACC_NO,AMOUNT,CURRENCY,CIF)values("+acc_no+","+amount+",'"+curr+"',"+cif+")");
			while(rs.next())
			{
				//acc_gen=rs.getInt(1);
				System.out.println(rs.getInt(1));
			//	return acc_gen;
				
				
			}
			
			}catch (Exception e) {
		        System.out.println(e);
			}
			return 0;
			}
	
	

	public int addForexAccount(Account acc)
	{
		try {
			int acc_no=0;
		
			Connection c = DatabaseConnection.getConnection();
			Statement st=c.createStatement();
			
			ResultSet res = st.executeQuery("SELECT MAX(ACC_NO) FROM Account_details");
			while (res.next()) 
			{
		       acc_no=res.getInt(1)+1;
			}
			
			 ResultSet r= st.executeQuery("Insert into Account_details(cust_id,Acc_no,Acc_type,Initial_deposit,balance,Branch_code,Nominee_name,Archived_status)values("+acc.getCIF()+","+acc_no+",'FX',"+acc.getInitial_deposit()+","+acc.getInitial_deposit()+","+acc.getBranch_code()+",'"+acc.getNominee()+"',0)");
			 
			 while(r.next())
			 {
				 return acc_no;
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	return 0;
	}
		
	}
	
	


