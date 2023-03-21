package com.ssafy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dao.CityDao;
import com.ssafy.dto.City;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/city_list")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityDao cityDao = new CityDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.도시목록 조회
			List<City> cityList = cityDao.selectAll();
			request.setAttribute("cities", cityList);

			// 2. 해당 도시목록이 담긴 html 문서 반환이 아닌, 요청을 cityList.jsp에 넘김
			// ( foward ) 방식
//			RequestDispatcher dispatcher = request.getRequestDispatcher("cityList.jsp");
//			dispatcher.forward(request, response);
			
			response.sendRedirect("/city_list/cityList.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
