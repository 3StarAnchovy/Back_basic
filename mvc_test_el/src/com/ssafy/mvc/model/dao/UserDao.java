package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.mvc.dto.User;
import com.ssafy.util.DBUtill;

public class UserDao {
	private DBUtill dbUtill = DBUtill.getInstance();
	/**
	 * 입력값 id, password
	 * 저장되는 사용자 정보 -> id 이름 나이
	 * @throws SQLException 
	 */
	public User login(User loginInfo) throws SQLException
	{
		//List<User> user_list = new ArrayList<>();
		//1. 쿼리문 작성
		String sql = "select id, name, age from user where id = ? and password = ?";
		
		//2. db 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtill.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginInfo.getId());
			pstmt.setString(2, loginInfo.getPassword());
			
			//3. 조회 쿼리 실행 
			rs = pstmt.executeQuery();
			
			//4. 조회 결과를 가공해서 반환
			if(rs.next())
			{
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				
				return user;
			}
			
			return null;
			
		} finally {
			dbUtill.close(rs, pstmt, conn);
		}
		
	}
	
	public static void main(String[] args)
	{
		
	}
}
