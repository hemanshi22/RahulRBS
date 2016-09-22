package com.bankstructure.services;

import java.sql.SQLException;

//import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/RightsService")

public class RightsService {


	public RightsService() {
	super();
	}

	@GET
	@Path("getRights")
	@Produces(MediaType.APPLICATION_JSON)
	public Rights getModule(@QueryParam("desk_id") int desk_id, @QueryParam("mod") String mod ) throws SQLException{
	RightsDao rightsDao = new RightsDao();
	return rightsDao.getRightsPermissions(desk_id, mod);
   }	
}