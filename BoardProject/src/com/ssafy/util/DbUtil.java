package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	// 싱글톤
	// 동적로딩
	// 커넥팅
	// 자원반납?

	private DbUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static DbUtil dbUtil = new DbUtil();

	public static DbUtil getInstance() {
		return dbUtil;
	}

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ssafy_user";
		String user = "ssafy";
		String pw = "ssafy";

		return DriverManager.getConnection(url, user, pw);
	}
	
	public void close(AutoCloseable ...autoCloseables)
	{
		for(AutoCloseable a : autoCloseables)
		{
			try {
				a.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
