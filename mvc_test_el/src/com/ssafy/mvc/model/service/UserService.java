package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public User login(User loginInfo) throws SQLException
	{
		return userDao.login(loginInfo);
	}
}
