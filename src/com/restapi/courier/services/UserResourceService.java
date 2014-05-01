package com.restapi.courier.services;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.restapi.courier.dao.UserDAO;
import com.restapi.courier.dto.User;

public class UserResourceService implements UserResource {
	
	
	public Response createUser(String msg) 
	{
		String result = null ;
		int responsecode = 0 ;
		
		ObjectMapper mapper = new ObjectMapper();
		
		UserDAO userDAO = new UserDAO() ;
		
		 User user;
		try {
			user = mapper.readValue(msg, User.class);
			 responsecode =userDAO.createUser(user);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if(responsecode==200)
			return Response.status(200).entity("Consignment Sucessfully Created").build();
				else
				return Response.status(200).entity("Unable to Create Consignment").build();
				
	}

}
