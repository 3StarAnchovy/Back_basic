package com.ssafy.paging.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.paging.dto.Board;
import com.ssafy.paging.dto.Page;
import com.ssafy.paging.dto.pageResult;
import com.ssafy.paging.model.dao.BoardDao;
import com.ssafy.paging.model.dao.BoardDaoImpl;

public class Board3ServiceImpl implements BoardService {
	private Board3ServiceImpl() {}
	private static BoardService instance = new Board3ServiceImpl();
	public static BoardService getInstance() {
		return instance;
	}
	private BoardDao dao = BoardDaoImpl.getInstance();
	
	@Override
	public Map<String, Object> listBoard(Page page) throws Exception {
		List<Board> list = dao.selectBoard(page);
		int count = dao.selectBoardCount(page);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", list);
		result.put("pageInfo", new pageResult(page.getPageNo(), count));
		return result;
	}
}
