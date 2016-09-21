package com.account.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.account.model.Account;

public interface Dao 
{
	ArrayList<Account> getResults(int accountNumber);
}
  
