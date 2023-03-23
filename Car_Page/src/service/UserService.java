package service;

import java.sql.SQLException;

import model.User;
import model.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public User login(User user) throws SQLException
	{
		return userDao.login(user);
	}
}
