package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.Dbutil;

public class CarDao {
	private Dbutil dbutil = Dbutil.getInstance();
	public List<Car> list() throws SQLException
	{
		List<Car> car_list = new ArrayList<Car>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from car";
		
		try {
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Car car = new Car();
				car.setNumber(rs.getString("number"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setBrand(rs.getString("brand"));
				
				car_list.add(car);
			}
			
			return car_list;
		} finally {
			dbutil.close(rs,pstmt,conn);
		}
	}
	
	public static void main(String[] args) throws SQLException
	{
		//init
		List<Car> result = new ArrayList<Car>();
		CarDao carDao = new CarDao();
		
		result = carDao.list();
		//action
		for(Car car : result)
		{
			System.out.println(car.toString());
		}
	}

	public void registAction(Car car) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into car (number,model,price,brand) values (?,?,?,?)";
		
		try {
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getNumber());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getPrice());
			pstmt.setString(4, car.getBrand());
			pstmt.executeUpdate();
		}finally {
			//dbutil.close(pstmt,conn);
		}
	}
}
