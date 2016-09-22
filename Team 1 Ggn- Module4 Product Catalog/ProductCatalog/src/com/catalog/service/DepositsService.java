package com.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.catalog.dao.implement.DepositsDaoImpl;

@Path("/Deposits")
public class DepositsService {
	
	@GET
	@Path("/getDepositsId")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Integer> getAccountNumList() {
		DepositsDaoImpl dep = new DepositsDaoImpl();
		return dep.getAllDepId();	
    }
	
	@GET
	@Path("/getAllData")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Map<String , String>> getAllDetails(){
		DepositsDaoImpl dep = new DepositsDaoImpl();
		return dep.getAllData();
	}
	
	@GET
	@Path("/getDurationBal")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Map<String , String>> getInterestRate(){
		DepositsDaoImpl dep = new DepositsDaoImpl();
		return dep.getInterest();
	}
}
