package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.City;
import com.ssafy.mvc.model.dao.CityDao;

public class CityService {
	CityDao cityDao = new CityDao();
	
	
	public List<City> selectAll() throws SQLException{
		return cityDao.selectAll();
	}
	
	public void cityRegist(City city) throws SQLException{
		cityDao.cityRegist(city);
	}
}
