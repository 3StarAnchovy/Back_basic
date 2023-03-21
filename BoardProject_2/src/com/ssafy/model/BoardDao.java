package com.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DbUtil;

public class BoardDao {
	private DbUtil dbUtil = DbUtil.getInstance();

	// 조희 비즈니스 로직

	public List<Board> selectAll() throws SQLException {
		List<Board> board_list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWritername(rs.getString("writername"));
				board_list.add(board);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return board_list;
	}

	public void registAction(String title, String content, String writername) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (title, content, writername) values (?,?,?)";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writername);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt,conn);
		}
	}

	public static void main(String[] args) throws SQLException {
		BoardDao boardDao = new BoardDao();
		List<Board> board_list = boardDao.selectAll();

		for (Board board : board_list) {
			System.out.println(
					board.getNum() + " " + board.getTitle() + " " + board.getContent() + " " + board.getWritername());

		}
	}
}
