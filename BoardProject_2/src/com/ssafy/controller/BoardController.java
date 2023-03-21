package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.Board;
import com.ssafy.model.BoardDao;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static BoardDao boardDao = new BoardDao();
	private static final long serialVersionUID = 1L;

	// step1. 라우팅
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");

		try {
			if (param.equals("list")) {
				getBoardList(request, response);
			}
			
			else if(param.equals("registPage"))
			{
				response.sendRedirect("registPage.jsp");
			}
			
			else if(param.equals("regist"))
			{
				getRegistList(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getRegistList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writername = request.getParameter("writername");
		
		try {
			boardDao.registAction(title, content, writername);
			getBoardList(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getBoardList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 비즈니스 로직, board list 속성에 저장하고 jsp로 보내기
		// jsp는 html page를 만들고 클라에게 리턴
		List<Board> board_list = boardDao.selectAll();
		request.setAttribute("board_list", board_list);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("BoardList.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
