package com.bankstructure.services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/EmpDetailsService")

public class EmpDetailsService {

	public EmpDetailsService() {
	super();
	}

	@GET
	@Path("getEmpDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpDetails getModule(@QueryParam("emp_id") int emp_id) throws SQLException{
	EmpDetailsDao EmpDetailsDao = new EmpDetailsDao();
	
	return EmpDetailsDao.getEmpDetailsPermissions(emp_id);
   }	
}