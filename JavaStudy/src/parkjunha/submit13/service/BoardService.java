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

	// 글목록
	public ArrayList<BoardVO> getBoList() {
		Connection conn = cp.getConnection();
		ArrayList<BoardVO> result = new ArrayList<>();

		try {
			result = dao.getBoList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);

		}
		return result;
	}

//	
	public BoardVO getBoardNo(int boardNo) {
	    Connection conn = cp.getConnection();
	    BoardVO result = null;

	    try {
	        result = dao.getBoardNo(conn, boardNo);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }

	    return result;
	}
//
	
	
	// 글 쓰기
	public void registBoard(String title, String content, String memId) {
		Connection conn = cp.getConnection();

		try {
			dao.registBoard(conn, title, content, memId);
			System.out.println("글을 작성하셨습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}

	public void selectNumTwo(String writeNumber) {
		// TODO Auto-generated method stub
		BoardDAO.selectNumberTwo();
		
	}

//	
//	public void registBoard(BoardVO board) {
//		Connection conn = cp.getConnection();
//		
//		try {
//			dao.registBoard(conn, board);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			cp.releaseConnection(conn);
//		}
//	} 
}

