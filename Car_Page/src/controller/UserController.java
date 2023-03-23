package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;


/*
 * user?param=loginpage -> 로그인
 * user?param=loginAction -> 로그인 model ㄱㄱ
 * user?param=logoutAction -> 로그아웃
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		try {
			if(param.equals("loginpage"))
			{
				response.sendRedirect(request.getContextPath() + "/loginpage.jsp");
			}
			
			else if(param.equals("login"))
			{
				loginAction(response,request);
			}
			
			else if(param.equals("logout"))
			{
				logoutAction(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void logoutAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	private void loginAction(HttpServletResponse response, HttpServletRequest request) throws SQLException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println(id + " " + password);
		
		//서비스 호출
		UserService userService = new UserService();
		User result = userService.login(new User(id,password));
		//인덱스로 페이지 이동
		if(result == null) //실패할때 로그인페이지
		{
			response.sendRedirect(request.getContextPath() + "user?param=loginpage");
		}
		else //성공하면 인덱스, 세션 생성 ㄱㄱ
		{
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", result);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
