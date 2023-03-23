package service;

import java.sql.SQLException;
import java.util.List;

import model.Car;
import model.CarDao;

public class CarService {
	private CarDao carDao = new CarDao();
	public List<Car> list() throws SQLException
	{
		return carDao.list();
	}
	
	public void registAction(Car car) throws SQLException
	{
		carDao.registAction(car);
	}
}
