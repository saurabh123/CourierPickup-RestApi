package com.restapi.courier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.restapi.courier.dto.Consignment;
import com.restapi.courier.dto.User;
import com.restapi.courier.utils.DButil;

public class UserDAO extends DButil {
	
	public int createUser(User user)throws Exception {

		PreparedStatement query = null;
		Connection conn = null;

			try {
	/*
	* If this was a real application, we need to use some authentication protocol to pass password
	* 
	
	*/
				conn = oracleConnection();
				query = conn.prepareStatement("insert into TL_USER " +"(USER_ID ,USER_PASSWORD ,IS_ACTIVE,USER_GROUP,LOGON_COUNT ) " +
						"VALUES ( ?, ?, ?, ?, ? ) ");

				query.setString(1,user.getUsername());
				query.setString(2, user.getPassword());
				query.setBoolean(3, true);
				query.setString(4, user.getUserGroup());
				query.setInt(5, 0);
		
			} catch(Exception e) {
				e.printStackTrace();
				return 500; //if a error occurs, return a 500
			}
			finally {
				if (conn != null) conn.close();
			}

			return 200;
		}

		
		

}
