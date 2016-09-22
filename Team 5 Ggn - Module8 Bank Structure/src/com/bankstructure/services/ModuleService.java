package com.bankstructure.services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/ModuleService")

public class ModuleService {

	public ModuleService() {
	super();
	}

	@GET
	@Path("getModule")
	@Produces(MediaType.APPLICATION_JSON)
	public Module getModule(@QueryParam("emp_id") int emp_id ) throws SQLException{
	ModuleDao moduleDao = new ModuleDao();
	
	return moduleDao.getModulePermissions(emp_id);
   }	
}