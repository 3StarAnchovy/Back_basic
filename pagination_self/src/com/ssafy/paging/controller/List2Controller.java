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

@WebServlet("/list2")
public class List2Controller extends HttpServlet {
	private BoardService service = Board1ServiceImpl.getInstance();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page page = new Page();
		//요청이 왔을 때, pageNo를 보내지 않는 경우, 오류 없이 1페이지를 조회하기 위해서
		try {
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		} catch (NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listBoard(page);;
			List<Board> list =(List<Board>)result.get("list");
			int count = (Integer)result.get("count");
			
			// 마지막 페이지 구하기
	//		int lastPage = (count % 10 == 0) ? count / 10 : count / 10 + 1;
	//		System.out.println(lastPage);
			
			int pageNo = page.getPageNo();
			// 마지막 페이지 번호
			int lastPage = (int)Math.ceil(count / 10d); // 실수연산을 위한 double (10d : double
			
			request.setAttribute("list", list);
			request.setAttribute("count", count);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("pageNo", pageNo);
			
			int tabSize = 10;
			int curTab = (pageNo - 1) / tabSize;	//탭의 번호, curTab == 1 -> 1 ~ 10 페이지
			int beginPage = (curTab -1) * tabSize + 1;
			int endPage = Math.min(curTab * tabSize, lastPage);
			boolean prevExists = beginPage != 1;
			boolean nextExists = endPage != lastPage;
			
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("prevExists", prevExists);
			request.setAttribute("nextExists", nextExists);
			
			//오...뭔소린지 하나도 모르겠어...
			
			
			request.getRequestDispatcher("/board/list1.jsp")
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










