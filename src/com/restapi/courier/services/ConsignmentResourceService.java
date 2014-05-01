package com.restapi.courier.services;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.restapi.courier.dao.ConsignmentDAO;
import com.restapi.courier.dao.UserDAO;
import com.restapi.courier.dto.Consignment;
import com.restapi.courier.dto.User;

public class ConsignmentResourceService implements ConsignmentResource{
	
	

	public Response  createConsignment(String msg) {
 
		System.out.println("Json String Recieved" + msg);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Consignment consignment = null;
		
		ConsignmentDAO consignmentDAO = new ConsignmentDAO() ;
		
		int responsecode = 0 ;

		try {
			 consignment = mapper.readValue(msg, Consignment.class);
			 
			 responsecode =consignmentDAO.insertConsignment(consignment);
			 
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to Parse Json").build();

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(responsecode==200)
	return Response.status(200).entity("Consignment Sucessfully Created").build();
		else
		return Response.status(200).entity("Unable to Create Consignment").build();
		
			
		}
		
		

	public Response getConsignmentDetails(String userid)
	{
		String result = null ;
		
		
		ConsignmentDAO consignmentDAO = new ConsignmentDAO() ;
		
		JSONArray json = new JSONArray();
		
		try{
		
		json = consignmentDAO.getConsignmentsData(userid);
		
			
		result = json.toString();

	}
	catch (Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Server was not able to process your request").build();
	}

	return Response.ok(result).build();
}
	
	public Response getConsignmentDetailsAdmin(String timeFrame)
	{
		String result = null ;
		
		
		ConsignmentDAO consignmentDAO = new ConsignmentDAO() ;
		
		JSONArray json = new JSONArray();
		
		try{
		
		json = consignmentDAO.getConsignmentsDataAdmin(timeFrame);
		
			
		result = json.toString();

	}
	catch (Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Server was not able to process your request").build();
	}

	return Response.ok(result).build();
}


	@Override
	public Response getConsignmentStatus(int consignid,String userid) {
	String result = null ;
		
		
		ConsignmentDAO consignmentDAO = new ConsignmentDAO() ;
		
		JSONArray json = new JSONArray();
		
		try{
		
		json = consignmentDAO.getConsignmentStatus(consignid,userid);
		
			
		result = json.toString();

	}
	catch (Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Server was not able to process your request").build();
	}

	return Response.ok(result).build();
	}

	
	public Response getConsignmentDetailsAdmin(int status)
	{
		String result = null ;
		
		
		ConsignmentDAO consignmentDAO = new ConsignmentDAO() ;
		
		JSONArray json = new JSONArray();
		
		try{
		
		json = consignmentDAO.getConsignmentsDataAdmin(status);
		
			
		result = json.toString();

	}
	catch (Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Server was not able to process your request").build();
	}

	return Response.ok(result).build();
}

}