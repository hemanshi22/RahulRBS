package com.j2ee.AccountOpeningServlet;
import  com.account.dao.*;
import java.sql.Connection;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;

public class searchDaoImplementation implements Searchdao {

	@Override
	public ArrayList<AccountSearch> getSearchDetails(int ACC_NO,int c1) {
	ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
		
	
	
		try{	
			Connection c = DatabaseConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet rs=null;
			//String data=request.getParameter("c1"); 
			if(c1!=1){
			rs = statement.executeQuery("select * from ACCOUNT_DETAILS where ACC_NO=" + ACC_NO + " and ARCHIVED_STATUS=0");
			}
			//}
			
			else if(c1==1){
			rs = statement.executeQuery("select * from ACCOUNT_DETAILS where ACC_NO="+ACC_NO);
			}
			AccountSearch as=new AccountSearch();
				if(rs.next())
				{
					
					as.setACC_NO(rs.getLong(2));
					as.setCUST_ID(rs.getLong(1));
					as.setACC_TYPE(rs.getString(3));
					as.setDOO(rs.getDate(4));
					as.setINITIAL_DEPOSIT(rs.getDouble(5));
					as.setNOMINEE_NAME(rs.getString(6));
					as.setBRANCH_CODE(rs.getInt(7));
					as.setBALANCE(rs.getDouble(8));
					as.setINTEREST_RATE(rs.getFloat(9));
					as.setDATE_OF_MATURITY(rs.getDate(10));
					as.setARCHIVED_STATUS(rs.getInt(11));
					accountDetails.add(as);
				}
				
		
			
		} catch (
		ClassNotFoundException e)
		{
			System.out.println(e);
			
		} catch (
		SQLException s)
		{
			System.out.println(s);
			
		}
	catch (Exception e) {
		System.out.println(e);	
	}
		return accountDetails;
	}
	public ArrayList<AccountSearch> getSearchDetails(String ACC_TYPE) {
       ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
      	try{	
		Connection c = DatabaseConnection.getConnection();
		Statement statement = c.createStatement();
		ResultSet rs=null;
		//System.out.println(ACC_TYPE);
		//String data=request.getParameter("c1"); 
		//if(data==null){
		rs = statement.executeQuery("select * from ACCOUNT_DETAILS where ACC_TYPE='" + ACC_TYPE +"'");
		//ResultSet rs1=rs;
		//}
		
		//else if(data.equals("1"))
		//{rs = statement.executeQuery("select * from ACCOUNT_DETAILS where ACC_NO="+acc_no);
		//int count=0;
		//while(rs1.next())
		//{++count;}
		
		//int i=0;
		AccountSearch as=null;
			while(rs.next())
			{   as=new AccountSearch();
//				System.out.println(i);
//				System.out.println("skdfhngisdnbf");
				as.setACC_NO(rs.getLong(2));
				as.setCUST_ID(rs.getLong(1));
				as.setACC_TYPE(rs.getString(3));
				as.setDOO(rs.getDate(4));
				as.setINITIAL_DEPOSIT(rs.getDouble(5));
				as.setNOMINEE_NAME(rs.getString(6));
				as.setBRANCH_CODE(rs.getInt(7));
				as.setBALANCE(rs.getDouble(8));
				as.setINTEREST_RATE(rs.getFloat(9));
				as.setDATE_OF_MATURITY(rs.getDate(10));
				as.setARCHIVED_STATUS(rs.getInt(11));
				//++i;
				System.out.println(as.getACC_NO());
				accountDetails.add(as);
			}
			
      	}
			
      catch (Exception e) {
                System.out.println(e);        
        }
        return accountDetails;
}
		public ArrayList<AccountSearch> getSearchDetails1(String DATE1,String DATE2) {
	       ArrayList<AccountSearch> accountDetails = new ArrayList<AccountSearch>();
	      	try{	
			Connection c = DatabaseConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet rs=null;
			
			//DATE1 DATE2
		
			//DateFormat format = new SimpleDateFormat("DD-MM-YY", Locale.ENGLISH);
			//Date date1 = format.parse(DATE1);
			//System.out.println(date1); // Sat Jan 02 00:00:00 GMT 2010
			
			//DateFormat format = new SimpleDateFormat("DD-MON-YY", Locale.ENGLISH);
			//Date date2 = format.parse(DATE2);
			//System.out.println(date2); // Sat Jan 02 00:00:00 GMT 2010
			
			rs = statement.executeQuery("select * from ACCOUNT_DETAILS where DOO>to_char(to_date('"+ DATE1 +"','DD-MM-YY'),'DD-Mon-YY') and DOO<to_char(to_date('"+ DATE2 +"','DD-MM-YY'),'DD-Mon-YY')");
			//rs = statement.executeQuery("select * from ACCOUNT_DETAILS where DOO > TO_DATE('"+ DATE1 +"','dd-MMM-yyyy') and DOO<TO_DATE('"+ DATE2 +"','dd-MMM-yyyy' ) ");
			ResultSet rs1=rs;
			
//			int count=0;
//			while(rs1.next())
//			{++count;}
			
			//int i=0;
			//AccountSearch[] as=new AccountSearch[count];
			AccountSearch as=null;
				while(rs.next())
				{
					 as=new AccountSearch();
//					as[i].setACC_NO(rs.getLong(2));
//					as[i].setCUST_ID(rs.getLong(1));
//					as[i].setACC_TYPE(rs.getString(3));
//					as[i].setDOO(rs.getDate(4));
//					as[i].setINITIAL_DEPOSIT(rs.getDouble(5));
//					as[i].setNOMINEE_NAME(rs.getString(6));
//					as[i].setBRANCH_CODE(rs.getInt(7));
//					as[i].setBALANCE(rs.getDouble(8));
//					as[i].setINTEREST_RATE(rs.getFloat(9));
//					as[i].setDATE_OF_MATURITY(rs.getDate(10));
//					as[i].setARCHIVED_STATUS(rs.getInt(11));
					
					as.setACC_NO(rs.getLong(2));
					as.setCUST_ID(rs.getLong(1));
					as.setACC_TYPE(rs.getString(3));
					as.setDOO(rs.getDate(4));
					as.setINITIAL_DEPOSIT(rs.getDouble(5));
					as.setNOMINEE_NAME(rs.getString(6));
					as.setBRANCH_CODE(rs.getInt(7));
					as.setBALANCE(rs.getDouble(8));
					as.setINTEREST_RATE(rs.getFloat(9));
					as.setDATE_OF_MATURITY(rs.getDate(10));
					as.setARCHIVED_STATUS(rs.getInt(11));
					
					
				//	++i;
					accountDetails.add(as);
				}}
				
	      catch (Exception e) {
	                System.out.println(e);        
	        }
	        return accountDetails;
}
}

