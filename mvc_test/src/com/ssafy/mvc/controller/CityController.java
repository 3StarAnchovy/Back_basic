package com.ssafy.mvc.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.mvc.dto.City;

import com.ssafy.mvc.model.service.CityService;

// http://localhost:8080/city_list/city?param=list => 도시목록 조회 요청
// http://localhost:8080/city_list/city?param=regist => 도시 정보 등록 요청

//prama = writePage
@WebServlet("/city")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityService cityService = new CityService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("param");

		// 라우팅
		try {
			if (parameter.equals("list")) {
				getCityList(request, response);
			}
			// 도시정보 등록페이지 redirect
			else if (parameter.equals("writePage")) {
				response.sendRedirect(request.getContextPath()+"/cityRegist.jsp");
			}
			// 도시정보 등록 요청 처리
			else if (parameter.equals("regist"))
			{
				cityRegist(request,response);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 도시정보를 등록
	 * 등록 후 조회로 리다이렉트
	 */
	private void cityRegist(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("도시 등록요청 수신");
		//1. 요청 파라미터 추출, 필요하다면 가공
		String name = request.getParameter("name");
		String countrycode = request.getParameter("countryCode");
		int population = Integer.parseInt(request.getParameter("population"));
		
		City city = new City(0,name,countrycode,population);
		//2. DB에 등록
		cityService.cityRegist(city);
		
		//3. 목록페이지 조회로 redirect
		//getCityList(request, response);
		response.sendRedirect(request.getContextPath() + "/city?param=list");
	}

	// 도시 목록 조회
	private void getCityList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CityService cityService = new CityService();
		List<City> cityList;
		try {
			cityList = cityService.selectAll();
			request.setAttribute("cities", cityList);

			// 2. 해당 도시목록이 담긴 html 문서 반환이 아닌, 요청을 cityList.jsp에 넘김
			// ( foward ) 방식
			RequestDispatcher dispatcher = request.getRequestDispatcher("cityList.jsp");
			dispatcher.forward(request, response);
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
