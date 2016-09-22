package com.catalog.dao.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepositsDao {
	public ArrayList<Integer> getAllDepId();
	public List<Map<String, String>> getAllData();
	public List<Map<String, String>> getInterest();
	public void insertDeposit(String depositType, double interestRate, String description,
			int maximumDuration);
	public void updateDeposit(int depositId, String depositType, double interestRate, String description,
			int maximumDuration);
}
