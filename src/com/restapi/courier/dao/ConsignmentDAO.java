package com.restapi.courier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.restapi.courier.dto.Address;
import com.restapi.courier.dto.Consignment;
import com.restapi.courier.utils.DButil;
import com.restapi.courier.utils.JsonUtil;

public class ConsignmentDAO extends DButil{
	

	
public JSONArray getConsignmentsData(String userid)
{
	
	PreparedStatement query = null;
	Connection conn = null;

	JSONArray json = new JSONArray();
	String jsonObject = null ;

	try {
		conn = oracleConnection();
		query = conn.prepareStatement("select c.CONSIGN_ID,c.CONSIGN_USER,c.CONSIGN_WEIGHT,c.CONSIGN_DATE,c.CONSIGN_SLOT,c.NO_OF_PACKAGE,c.COSG_TYPE,c.CONSIGN_PICUP_ADD_ID,c.CONSIGN_SCHEDULE_DATE,c.CONSIGN_STATUS,CONSIGN_RECIVER_NAME,c.DELIVERY_ADD1,c.DELIVERY_ADD2,c.DELIVERY_STATE,c.DELIVERY_COUNTRY,DELIVERY_CITY,DELIVERY_ZIP,DELIVERY_PHONENO" +
										"p.CONTACT_NAME,p.COMPANY,p.COUNTRY,p.CITY,p.ADDRESS_DETAILS_1,p.ADDRESS_DETAILS_2,p.STATE,p.STATE,p.ZIPCODE,p.PHONE_NO" +"from TL_CONSIGN_DETAILS c  INNER JOIN TL_PICKUP_ADDRESS p ON  c.CONSIGN_PICKUP_ADD_ID = P.PICKUP_ADD_ID" +
										"where c.CONSIGN_USER = ? ");

		query.setString(1, userid); //protect against sql injection
		ResultSet rs = query.executeQuery();

		
		ArrayList<Consignment> list=new ArrayList<Consignment>();
		
//		Map<String, String> map=new HashMap<String, String>();
	
		Consignment consignment=null;
		
		JsonUtil jsonutil = new JsonUtil();
		
		while (rs.next()) {
	    
		
		consignment=new Consignment();

		
		consignment.setId(rs.getInt("CONSIGN_ID"));
		
		consignment.setUser(rs.getString("CONSIGN_USER"));
		consignment.setCreatedDate(rs.getDate("CONSIGN_DATE"));
		consignment.setPackageCount(rs.getInt("NO_OF_PACKAGE"));
		consignment.setPickupSlot(rs.getString("CONSIGN_SLOT"));
		consignment.setStatus(rs.getInt("CONSIGN_STATUS"));
		consignment.setType(rs.getString("CONSIGN_TYPE"));
		consignment.setWeight(rs.getInt("CONSIGN_WEIGHT"));
		
		
		
		Address pickup = new Address();
		
		
		pickup.setAddress1(rs.getString("ADDRESS_DETAILS_1"));
		pickup.setAddress2(rs.getString("ADDRESS_DETAILS_2"));
		pickup.setCity(rs.getString("CITY"));
		pickup.setCompanyName(rs.getString("COMPANY"));
		pickup.setContactName(rs.getString("CONTACT"));
		pickup.setCountry(rs.getString("COUNTRY"));
		pickup.setPhoneNo(rs.getInt("PHONE_NO"));
		pickup.setState(rs.getString("STATE"));
		pickup.setZipcode(rs.getInt("ZIPCODE"));
		
		
		consignment.setPickupAddress(pickup);
		
		Address delivery = new Address();
		
		delivery.setAddress1(rs.getString("DELIVERY_ADD1"));
		delivery.setAddress2(rs.getString("DELIVERY_ADD1"));
		delivery.setCity(rs.getString("DELIVERY_CITY"));
		delivery.setCompanyName(rs.getString("DELIVERY_COMPANY"));
		delivery.setContactName(rs.getString("DELIVERY_CONTACT"));
		delivery.setCountry(rs.getString("DELIVERY_COUNTRY"));
		delivery.setPhoneNo(rs.getInt("DELIVERY_PHONE_NO"));
		delivery.setState(rs.getString("DELIVERY_STATE"));
		delivery.setZipcode(rs.getInt("DELIVERY_ZIPCODE"));
		
		
		
		consignment.setDeliveryAddress(pickup);
		
		jsonObject =jsonutil.createJsonString(consignment);
		
		json.put(jsonObject);
		}
		
	query.close(); //close connection
	}
	catch(SQLException sqlError) {
		sqlError.printStackTrace();
		
}
	catch(Exception e) {
		e.printStackTrace();
		
//		query.close();
	}
	finally {
//		if (conn != null) conn.close();
	}

	return json;
}


public JSONArray getConsignmentsDataAdmin(String timeframe)
{
	
	PreparedStatement query = null;
	Connection conn = null;

	JSONArray json = new JSONArray();
	String jsonObject = null ;

	try {
		conn = oracleConnection();
		

        Date date = new Date();
        java.sql.Date sqlDateTo = new java.sql.Date(date.getTime());

        Calendar cal = Calendar.getInstance();
        

		if(timeframe.equalsIgnoreCase("week"))
		      cal.add(Calendar.DATE, -7);
		else if ((timeframe.equalsIgnoreCase("day")))
		      cal.add(Calendar.DATE, -1);
		else if ((timeframe.equalsIgnoreCase("month")))
		      cal.add(Calendar.DATE, -30);

		
        java.sql.Date sqlDateFrom = new java.sql.Date(cal.getTimeInMillis());

		
		query = conn.prepareStatement("select c.CONSIGN_ID,c.CONSIGN_USER,c.CONSIGN_WEIGHT,c.CONSIGN_DATE,c.CONSIGN_SLOT,c.NO_OF_PACKAGE,c.COSG_TYPE,c.CONSIGN_PICUP_ADD_ID,c.CONSIGN_SCHEDULE_DATE,c.CONSIGN_STATUS,CONSIGN_RECIVER_NAME,c.DELIVERY_ADD1,c.DELIVERY_ADD2,c.DELIVERY_STATE,c.DELIVERY_COUNTRY,DELIVERY_CITY,DELIVERY_ZIP,DELIVERY_PHONENO" +
				"p.CONTACT_NAME,p.COMPANY,p.COUNTRY,p.CITY,p.ADDRESS_DETAILS_1,p.ADDRESS_DETAILS_2,p.STATE,p.STATE,p.ZIPCODE,p.PHONE_NO" +"from TL_CONSIGN_DETAILS c  INNER JOIN TL_PICKUP_ADDRESS p ON  c.CONSIGN_PICKUP_ADD_ID = P.PICKUP_ADD_ID" +
				"where c.CONSIGN_DATE >= ? AND c.CONSIGN_DATE <= ? ");

		query.setDate(1, sqlDateFrom); 
		//protect against sql injection
		query.setDate(2, sqlDateTo); 

		ResultSet rs = query.executeQuery();

		
		ArrayList<Consignment> list=new ArrayList<Consignment>();
		
//		Map<String, String> map=new HashMap<String, String>();
	
		Consignment consignment=null;
		
		JsonUtil jsonutil = new JsonUtil();
		
		while (rs.next()) {
	    
		
		consignment=new Consignment();

	consignment.setId(rs.getInt("CONSIGN_ID"));
		
		consignment.setUser(rs.getString("CONSIGN_USER"));
		consignment.setCreatedDate(rs.getDate("CONSIGN_DATE"));
		consignment.setPackageCount(rs.getInt("NO_OF_PACKAGE"));
		consignment.setPickupSlot(rs.getString("CONSIGN_SLOT"));
		consignment.setStatus(rs.getInt("CONSIGN_STATUS"));
		consignment.setType(rs.getString("CONSIGN_TYPE"));
		consignment.setWeight(rs.getInt("CONSIGN_WEIGHT"));
		
		
		
		Address pickup = new Address();
		
		
		pickup.setAddress1(rs.getString("ADDRESS_DETAILS_1"));
		pickup.setAddress2(rs.getString("ADDRESS_DETAILS_2"));
		pickup.setCity(rs.getString("CITY"));
		pickup.setCompanyName(rs.getString("COMPANY"));
		pickup.setContactName(rs.getString("CONTACT"));
		pickup.setCountry(rs.getString("COUNTRY"));
		pickup.setPhoneNo(rs.getInt("PHONE_NO"));
		pickup.setState(rs.getString("STATE"));
		pickup.setZipcode(rs.getInt("ZIPCODE"));
		
		
		consignment.setPickupAddress(pickup);
		
		Address delivery = new Address();
		
		delivery.setAddress1(rs.getString("DELIVERY_ADD1"));
		delivery.setAddress2(rs.getString("DELIVERY_ADD1"));
		delivery.setCity(rs.getString("DELIVERY_CITY"));
		delivery.setCompanyName(rs.getString("DELIVERY_COMPANY"));
		delivery.setContactName(rs.getString("DELIVERY_CONTACT"));
		delivery.setCountry(rs.getString("DELIVERY_COUNTRY"));
		delivery.setPhoneNo(rs.getInt("DELIVERY_PHONE_NO"));
		delivery.setState(rs.getString("DELIVERY_STATE"));
		delivery.setZipcode(rs.getInt("DELIVERY_ZIPCODE"));
		
		
		
		consignment.setDeliveryAddress(pickup);
	
		jsonObject =jsonutil.createJsonString(consignment);
		
		json.put(jsonObject);
		}
		
	query.close(); //close connection
	}
	catch(SQLException sqlError) {
		sqlError.printStackTrace();
		
}
	catch(Exception e) {
		e.printStackTrace();
		
//		query.close();
	}
	finally {
//		if (conn != null) conn.close();
	}

	return json;
}
public JSONArray getConsignmentsDataAdmin(int status)
{
	
	PreparedStatement query = null;
	Connection conn = null;

	JSONArray json = new JSONArray();
	String jsonObject = null ;

	try {
		conn = oracleConnection();
		
		query = conn.prepareStatement("select c.CONSIGN_ID,c.CONSIGN_USER,c.CONSIGN_WEIGHT,c.CONSIGN_DATE,c.CONSIGN_SLOT,c.NO_OF_PACKAGE,c.COSG_TYPE,c.CONSIGN_PICUP_ADD_ID,c.CONSIGN_SCHEDULE_DATE,c.CONSIGN_STATUS,CONSIGN_RECIVER_NAME,c.DELIVERY_ADD1,c.DELIVERY_ADD2,c.DELIVERY_STATE,c.DELIVERY_COUNTRY,DELIVERY_CITY,DELIVERY_ZIP,DELIVERY_PHONENO" +
				"p.CONTACT_NAME,p.COMPANY,p.COUNTRY,p.CITY,p.ADDRESS_DETAILS_1,p.ADDRESS_DETAILS_2,p.STATE,p.STATE,p.ZIPCODE,p.PHONE_NO" +"from TL_CONSIGN_DETAILS c " 
				+ "INNER JOIN TL_PICKUP_ADDRESS p ON  c.CONSIGN_PICKUP_ADD_ID = P.PICKUP_ADD_ID" +
				"where c.CONSIGN_STATUS = ? ");
		
		
		query.setInt(1, status); //protect against sql injection
		ResultSet rs = query.executeQuery();

		
		ArrayList<Consignment> list=new ArrayList<Consignment>();
		
//		Map<String, String> map=new HashMap<String, String>();
	
		Consignment consignment=null;
		
		JsonUtil jsonutil = new JsonUtil();
		
		while (rs.next()) {
	    
		
		consignment=new Consignment();

		
consignment.setId(rs.getInt("CONSIGN_ID"));
		
		consignment.setUser(rs.getString("CONSIGN_USER"));
		consignment.setCreatedDate(rs.getDate("CONSIGN_DATE"));
		consignment.setPackageCount(rs.getInt("NO_OF_PACKAGE"));
		consignment.setPickupSlot(rs.getString("CONSIGN_SLOT"));
		consignment.setStatus(rs.getInt("CONSIGN_STATUS"));
		consignment.setType(rs.getString("CONSIGN_TYPE"));
		consignment.setWeight(rs.getInt("CONSIGN_WEIGHT"));
		
		
		
		Address pickup = new Address();
		
		
		pickup.setAddress1(rs.getString("ADDRESS_DETAILS_1"));
		pickup.setAddress2(rs.getString("ADDRESS_DETAILS_2"));
		pickup.setCity(rs.getString("CITY"));
		pickup.setCompanyName(rs.getString("COMPANY"));
		pickup.setContactName(rs.getString("CONTACT"));
		pickup.setCountry(rs.getString("COUNTRY"));
		pickup.setPhoneNo(rs.getInt("PHONE_NO"));
		pickup.setState(rs.getString("STATE"));
		pickup.setZipcode(rs.getInt("ZIPCODE"));
		
		
		consignment.setPickupAddress(pickup);
		
		Address delivery = new Address();
		
		delivery.setAddress1(rs.getString("DELIVERY_ADD1"));
		delivery.setAddress2(rs.getString("DELIVERY_ADD1"));
		delivery.setCity(rs.getString("DELIVERY_CITY"));
		delivery.setCompanyName(rs.getString("DELIVERY_COMPANY"));
		delivery.setContactName(rs.getString("DELIVERY_CONTACT"));
		delivery.setCountry(rs.getString("DELIVERY_COUNTRY"));
		delivery.setPhoneNo(rs.getInt("DELIVERY_PHONE_NO"));
		delivery.setState(rs.getString("DELIVERY_STATE"));
		delivery.setZipcode(rs.getInt("DELIVERY_ZIPCODE"));
		
		
		
		consignment.setDeliveryAddress(pickup);
	
		jsonObject =jsonutil.createJsonString(consignment);
		
		json.put(jsonObject);
		}
		
	query.close(); //close connection
	}
	catch(SQLException sqlError) {
		sqlError.printStackTrace();
		
}
	catch(Exception e) {
		e.printStackTrace();
		
//		query.close();
	}
	finally {
//		if (conn != null) conn.close();
	}

	return json;
}

public int insertConsignment(Consignment consignment)throws Exception {

	PreparedStatement query = null;
	Connection conn = null;

		try {
			conn = oracleConnection();
			query = conn.prepareStatement("insert into TL_CONSIGNMENT_DETAILS " +"CONSIGN_USER,CONSIGN_WEIGHT,CONSIGN_SCHEDULE_DATE,CONSIGN_SLOT,NO_OF_PACKAGE,COSG_TYPE,CONSIGN_PICUP_ADD_ID,CONSIGN_STATUS,CONSIGN_RECIVER_NAME,DELIVERY_ADD1,DELIVERY_ADD2,DELIVERY_STATE,DELIVERY_COUNTRY,DELIVERY_CITY,DELIVERY_ZIP,DELIVERY_PHONENO" +
					"VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ? ) ");

			query.setString(1,consignment.getUser());
			query.setInt(2,consignment.getWeight());
			query.setDate(3,new java.sql.Date(consignment.getScheduledDate().getTime()));
			query.setString(4,consignment.getPickupSlot());
			query.setInt(5,consignment.getPackageCount());
			query.setInt(6,consignment.getPickupAddId());
			query.setInt(7,consignment.getStatus());
			query.setString(8,consignment.getDeliveryAddress().getContactName());
			query.setString(9,consignment.getDeliveryAddress().getAddress1());
			query.setString(10,consignment.getDeliveryAddress().getAddress2());
			query.setString(11,consignment.getDeliveryAddress().getState());
			query.setString(12,consignment.getDeliveryAddress().getCountry());
			query.setString(13,consignment.getDeliveryAddress().getCity());
			query.setInt(14,consignment.getDeliveryAddress().getZipcode());
			query.setInt(15,consignment.getDeliveryAddress().getPhoneNo());

			query.close();

		} catch(Exception e) {
			e.printStackTrace();
			return 500; //if a error occurs, return a 500
		}
		finally {
			if (conn != null) conn.close();
		}

		return 200;
	}




public JSONArray getConsignmentStatus(int consignid , String userid)
{
	
	PreparedStatement query = null;
	Connection conn = null;

	JSONArray json = new JSONArray();
	String jsonObject = null ;

	try {
		conn = oracleConnection();
		
		query = conn.prepareStatement("select c.CONSIGN_STATUS,s.STATUS_DESC FROM TL_CONSIGNMENT_DETAILS c INNER JOIN TL_STATUS S ON  c.CONSIGN_STATUS = s.STATUS_CODE" +
				"where c.CONSIGN_ID >= ? AND c.CONSIGN_USER <= ? ");

		query.setInt(1, consignid); 
		//protect against sql injection
		query.setString(2, userid); 

		ResultSet rs = query.executeQuery();

		
		ArrayList<Consignment> list=new ArrayList<Consignment>();
		
//		Map<String, String> map=new HashMap<String, String>();
	
		Consignment consignment=null;
		
		JsonUtil jsonutil = new JsonUtil();
		
		while (rs.next()) {
	    
		
		consignment=new Consignment();

	
		consignment.setStatus(rs.getInt("CONSIGN_STATUS"));
		consignment.setStatusDesc(rs.getString("CONSIGN_STATUS"));

	
		jsonObject =jsonutil.createJsonString(consignment);
		
		json.put(jsonObject);
		}
		
	query.close(); //close connection
	}
	catch(SQLException sqlError) {
		sqlError.printStackTrace();
		
}
	catch(Exception e) {
		e.printStackTrace();
		
//		query.close();
	}
	finally {
//		if (conn != null) conn.close();
	}

	return json;
}
	
}
	
	
	


