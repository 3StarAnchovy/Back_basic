package com.ssafy.paging.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.ssafy.paging.dto.Board;
import com.ssafy.paging.dto.Page;

public interface BoardDao {
	public List<Board> selectBoard(Page page) throws SQLException, NamingException;
	public int selectBoardCount(Page page) throws SQLException, NamingException; 
}