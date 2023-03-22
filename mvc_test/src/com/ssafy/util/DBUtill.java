package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 싱글톤 패턴
 * - 상태를 갖지 않고, 기능만 사용하는 객체의 경우
 * step 1. 생성자 막기
 * step 2. 객체 생성하기
 * step 3. 해당 객체 주소 return해주는 메소드 만들기
 */

public class DBUtill {
	
	private DBUtill()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static DBUtill dbUtill = new DBUtill();
	
	public static DBUtill getInstance()
	{
		return dbUtill;
	}
	
	//Connection 객체를 반환하는 메소드
	public Connection getConnection() throws SQLException {
		String user = "ssafy";
		String pwd = "ssafy";
		String url = "jdbc:mysql://localhost:3306/world";
		
		return DriverManager.getConnection(url, user, pwd);
	}
	
	public void close(AutoCloseable ...autoCloseables)
	{
		for(AutoCloseable obj : autoCloseables)
		{
			try {
				obj.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
