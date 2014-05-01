package com.restapi.courier.utils;
import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;

public class DButil {
	
	



		private static DataSource Oracle = null; //hold the database object
		private static Context context = null; //used to lookup the database connection in weblogic
		
		private static DataSource OracleConn() throws Exception {
			
			/**
			 * check to see if the database object is already defined...
			 * if it is, then return the connection, no need to look it up again.
			 */
			if (Oracle != null) {
				return Oracle;
			}
			
			try {
				
				
				if (context == null) {
					context = new InitialContext();
				}
				
				Oracle = (DataSource) context.lookup("RestApiCourier");
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return Oracle;
			
		}
		
		
		protected static Connection oracleConnection() {
			Connection conn = null;
			try {
				conn = OracleConn().getConnection();
				return conn;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	}



