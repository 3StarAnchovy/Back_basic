package com.ssafy.paging.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.paging.dto.Board;
import com.ssafy.paging.dto.Page;
import com.ssafy.paging.model.service.Board1ServiceImpl;
import com.ssafy.paging.model.service.BoardService;

@WebServlet("/list3")
public class List1Controller3 extends HttpServlet {
	private BoardService service = Board1ServiceImpl.getInstance();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page page = new Page();
		//요청이 왔을 때, pageNo를 보내지 않는 경우, 오류 없이 1페이지를 조회하기 위해서
		try {
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		} catch (NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listBoard(page);;
			request.setAttribute("result", result);
			
			request.getRequestDispatcher("/board/list3.jsp")
			       .forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			
			//   77 / 10d -> ceil(7.7) : 8.0
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
}










