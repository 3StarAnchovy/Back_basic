package com.ssafy.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	/*
	 * auth?param = loginPage -> 로그인 페이지 요청 auth?param = login -> 로그인 auth?param =
	 * logout -> 로그아웃
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");
		try {
			if (param.equals("loginPage")) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else if (param.equals("login")) {
				login(request, response);
			} else if (param.equals("logout")) {
				logout(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 세션에서 정보삭제
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");

		// 2. 메인페이지 반환
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// System.out.println("로그인 요청 수신");

		// 1. 아이디, 비밀번호 정보 추출, User 객체로 가공
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		User loginInfo = new User(id, password);
		// 2. DB에서 아이디, 비번 이용해서 조회
		User result = userService.login(loginInfo);
		//System.out.println("로그인 조회 결과 " + result.toString());

		if (result != null) {
			// 3. 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", result);
			System.out.println(session.toString());
			// id 저장 체크박스가 체크된 경우
			if (request.getParameter("isRemember") != null) {
				// id 값이 저장된 쿠키 만들어서 응답에 추가 ( id 저장 가능 )
				Cookie cookie = new Cookie("rememberId", result.getId());
				cookie.setMaxAge(60 * 60); // 쿠키 유효기간 설정, 저장위치가 클라이언트여서 expire 지정 해줘야됨
				response.addCookie(cookie);
			}
			else { // 체크 안되있을떄
				Cookie cookie = new Cookie("rememberId", result.getId());
				cookie.setMaxAge(0); // 쿠키 유효기간 설정, 저장위치가 클라이언트여서 expire 지정 해줘야됨
				response.addCookie(cookie);
			}
				
			// 4. 메인페이지 반환
			response.sendRedirect(request.getContextPath());
		} else
			response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
