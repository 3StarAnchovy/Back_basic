package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {

	private Dbutil()
	{
		//step 01 클래스 동적로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static Dbutil dbUtil = new Dbutil();
	
	public static Dbutil getInstance()
	{
		return dbUtil;
	}
	
	public Connection getConnection() throws SQLException
	{
		String user ="ssafy";
		String pwd = "ssafy";
		String url ="jdbc:mysql://localhost:3306/train";
		
		return DriverManager.getConnection(url,user,pwd);
	}
}
