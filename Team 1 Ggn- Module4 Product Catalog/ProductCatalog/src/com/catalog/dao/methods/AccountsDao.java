package com.catalog.dao.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.catalog.model.User;

public interface AccountsDao {
	public ArrayList<Integer> getAllAccountNum();
	public List<Map<String, String>> getAllData();
	public List<Map<String, String>> getInterest();
	public void insertAccount(String accountType, double interestRate, String description,
			double minimumBalance);
	public void updateAccount(int accountId, String accountType, double interestRate, String description,
			double minimumBalance) ;
	public User getModuleAcess(User user);
	public User getModuleServiceAcess(User user);
}
