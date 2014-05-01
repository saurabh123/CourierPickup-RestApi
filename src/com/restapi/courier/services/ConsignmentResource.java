package com.restapi.courier.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restapi.courier.dto.Consignment;

@Path("/consign")
public interface ConsignmentResource {


	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createConsignment(String msg) ;
		
	
	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsignmentDetails(@PathParam("userid") String userId) ;

	@GET
	@Path("status/{consignid}/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsignmentStatus(@PathParam("consignid") int consignid,@PathParam("userId") String userid) ;

	
	@GET
	@Path("/admin/timeframe-{timeframe}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsignmentDetailsAdmin(@PathParam("timeframe") String timeFrame) ;
	
	@GET
	@Path("/admin/status-{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsignmentDetailsAdmin(@PathParam("status") int status) ;
	
	
	
	
}
