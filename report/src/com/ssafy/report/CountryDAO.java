package com.ssafy.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
	DBUtill dbUtill = DBUtill.getInstance();
	
	
	public List<CountryDTO> selectAll() throws SQLException
	{
		List<CountryDTO> countryList = new ArrayList<CountryDTO>();
		String sql = "select Code,Name,Continent,LifeExpectancy from world.country";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtill.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next())
			{
				CountryDTO country = new CountryDTO();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
				
				countryList.add(country);
			}
		}finally {
			dbUtill.close(rs,psmt,conn);
		}
		
		
		return countryList;
	}
	
	public static void main(String[] args) {
		CountryDAO countryDAO = new CountryDAO();
		List<CountryDTO> countryList = new ArrayList<CountryDTO>();
		try {
			countryList = countryDAO.selectAll();
			System.out.println(countryList);
			for(CountryDTO country : countryList)
			{
				System.out.println(country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
