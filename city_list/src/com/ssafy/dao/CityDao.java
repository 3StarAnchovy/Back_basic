package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.City;
import com.ssafy.util.DBUtill;

public class CityDao {
	private DBUtill dbUtill = DBUtill.getInstance();

	public List<City> selectAll() throws SQLException {
		List<City> cityList = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select니깐 resultSet으로 담아야됨
		String sql = "select id, name, countrycode, population from world.city limit 20";

		try {
			// 1. DB와 연결
			conn = dbUtill.getConnection();
			// 2. 쿼리 보내기
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 3. 조회 결과를 원하는 형태로 가공
			while (rs.next()) {
				// city 객체 하나를 만들어서 정보를 저장하고 list에 추가한다.
				City city = new City();
				city.setId(rs.getInt("id"));
				// city.setId(rs.getInt(1));
				city.setName(rs.getString("name"));
				city.setContryCode(rs.getString("countrycode"));
				city.setPopulation(rs.getInt("population"));

				cityList.add(city);
			}

		} finally {
			// 자원 반납
			// 중복되니깐 걍 메소드 만들자
			// 얘네 전부 autocloseable 상속 받고있음
//			rs.close();
//			pstmt.close();
//			conn.close();
			dbUtill.close(rs, pstmt, conn);
		}

		return cityList;
	}

	/*
	 * 도시 정보 등록 메소드
	 */
	public void cityRegist(City city) throws SQLException {
		// 1. 쿼리 작성
		String sql = "insert into city (name, countrycode, population) values (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 2. db 연결
			conn = dbUtill.getConnection();
			// 3. 쿼리 실행
			pstmt = conn.prepareStatement(sql); // 쿼리 저장
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getContryCode());
			pstmt.setInt(3, city.getPopulation());
			pstmt.executeUpdate(); // 쿼리 실행
		} finally {
			dbUtill.close(pstmt, conn);
		}

		// 4. 자원 반납
	}

	// test용 main
	public static void main(String[] args) {
		CityDao bookDao = new CityDao();

		try {
			List<City> list = bookDao.selectAll();
			for (City c : list) {
				System.out.println(c);
			}
			
			City city = new City();
			city.setName("도시");
			city.setContryCode("AFG");
			city.setPopulation(100);
			bookDao.cityRegist(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
