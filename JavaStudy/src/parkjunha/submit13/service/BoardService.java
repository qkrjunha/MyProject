package parkjunha.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.vo.WordGameVO;
import parkjunha.submit13.context.ConnectionPool;
import parkjunha.submit13.dao.BoardDAO;
import parkjunha.submit13.vo.BoardVO;

public class BoardService {

	private BoardService() {
	}

	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}

	private BoardDAO dao = BoardDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	public void registBoard(String title, String content) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registBoard(conn, title, content);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	} 
	
	public void registBoard(BoardVO board) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registBoard(conn, board);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	} 
}