package com.restapi.courier.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/user")

public interface UserResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String msg) ;
		
		

}
