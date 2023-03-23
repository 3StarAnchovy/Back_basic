package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.Dbutil;

public class UserDao {
	private Dbutil dbutil = Dbutil.getInstance();

	public User login(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, pwd, name from user where id = ? and pwd = ?";

		try {
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				User result = new User(rs.getString("id"), rs.getString("pwd"), rs.getString("name"));
				return result;
			}

			return null;
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
	}

	// test
	public static void main(String[] args) throws SQLException {
		// init
		UserDao userDao = new UserDao();

		/*
		 * 성공
		 */
		User user = new User("ssafy", "1234");
		User result = userDao.login(user);
		
		System.out.println(result.toString());
		
		/*
		 * 실패
		 */
		user = new User("ssafy", "1234");
		result = userDao.login(user);
		
		if(result == null)
		{
			System.out.println("null test");
		}
	}
}
