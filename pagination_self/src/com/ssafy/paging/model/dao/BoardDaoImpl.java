package com.ssafy.paging.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ssafy.paging.dto.Board;
import com.ssafy.paging.dto.Page;
import com.ssafy.paging.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private BoardDaoImpl() {}
	private static BoardDao instance = new BoardDaoImpl();
	public static BoardDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Board> selectBoard(Page page) throws SQLException, NamingException {
		
		//1. 쿼리 작성
		String sql = "select * from tb_paging_board order by no desc limit ?, ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//2. DB 연결
			conn = DBUtil.getConnection();
			
			//3. 쿼리 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page.getPageNo() - 1) * page.getListSize());
			pstmt.setInt(2, page.getListSize());
			rs = pstmt.executeQuery();
			
			//4. 조회 데이터 파싱
			List<Board> list = new ArrayList<>();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				list.add(board);
			}
			return list;
		}
		//5. 자원 반납
		finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public int selectBoardCount(Page page) throws SQLException, NamingException {
		//1. 쿼리 작성
		String sql = "select count(*) from tb_paging_board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//2. DB 연결
			conn = DBUtil.getConnection();
			
			//3. 쿼리 실행
			pstmt = conn.prepareStatement(sql);
			
			//4. 조회 데이터 파싱
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} 
		//5. 자원 반납
		finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}

}
