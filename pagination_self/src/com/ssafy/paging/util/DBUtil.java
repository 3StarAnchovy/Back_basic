package com.ssafy.paging.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getConnection() throws NamingException, SQLException {
		Context context = (Context) new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/paging");
		return ds.getConnection();
	}
	
	public static void close(AutoCloseable...autoCloseables) {
		for(AutoCloseable obj: autoCloseables) {
			if(obj!=null)
				try {
					obj.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
	}
}
