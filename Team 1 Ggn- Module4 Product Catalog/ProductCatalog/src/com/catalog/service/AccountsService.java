package com.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.catalog.dao.implement.AccountDaoImpl;
import com.catalog.dao.implement.DepositsDaoImpl;

@Path("/Accounts")
public class AccountsService {
	
	
	@GET
	@Path("/getAccountNum")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Integer> getAccountNumList() {
		AccountDaoImpl acc = new AccountDaoImpl();
		return acc.getAllAccountNum();	
    }
	
	@GET
	@Path("/getAllData")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Map<String , String>> getAllDetails(){
		AccountDaoImpl acc = new AccountDaoImpl();
		return acc.getAllData();
	}
	
	@GET
	@Path("/getDurationBal")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Map<String , String>> getInterestRate(){
		AccountDaoImpl acc = new AccountDaoImpl();
		return acc.getInterest();
	}
}
