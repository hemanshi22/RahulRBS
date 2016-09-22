package com.catalog.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.catalog.dao.implement.LoansDaoImpl;
import com.catalog.model.Loans;

@Path("/Loans")
public class LoansService {

	@GET
	@Path("/getAllData")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Loans> getAllLoans() {

		LoansDaoImpl loansDao = new LoansDaoImpl();
		return loansDao.getAllLoans();
	}
}
