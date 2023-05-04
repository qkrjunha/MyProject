package parkjunha.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import parkjunha.submit13.vo.BoardVO;

public class BoardDAO {

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
	public ArrayList<BoardVO> getBoList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		 bo_num					");
		query.append("		,bo_title	");
		query.append("		,bo_author					");
		query.append("		,bo_date				");
		query.append("FROM								");
		query.append("			bo				"); // 세미콜론이 없음에 주의
		query.append("ORDER BY bo_num asc			");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList<BoardVO> result = new ArrayList<>();
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬러명과 일치해야 함
			int boardNo = rs.getInt("bo_num");
			String boardTitle = rs.getString("bo_title");
			String boardAuthor = rs.getString("bo_author");
			String boardDate = rs.getString("bo_date");
			
	
	
			BoardVO bo = new BoardVO(boardNo,boardTitle,boardAuthor,boardDate, "");
			
			result.add(bo);

			
		}
		ps.close();
		rs.close();
		
		return result;
	}



	
	//
	
	public BoardVO getBoardNo(Connection conn, int boardNo) throws SQLException {
	    // 3. 쿼리문 작성
	    StringBuffer query = new StringBuffer();
	    query.append("SELECT								");
	    query.append("       bo_num						");
	    query.append("      ,bo_title					");
	    query.append("      ,bo_content					");
	    query.append("      ,bo_author					");
	    query.append("      ,bo_date					");
	    query.append("FROM									");
	    query.append("        bo						");
	    query.append("WHERE 1=1								");
	    query.append("  AND board_no = ?					");
	    query.append("ORDER BY board_no ASC				");

	   
	    PreparedStatement ps = conn.prepareStatement(query.toString());

	    
	    ps.setInt(1, boardNo);

	   
	    ResultSet rs = ps.executeQuery();

	 
	    BoardVO bo = null;
	    if (rs.next()) {
	        int boardNo1 = rs.getInt("board_no");
	        String boardTitle = rs.getString("board_title");
	        String boardAuthor = rs.getString("board_content");
	        String author = rs.getString("board_author");
	        String boardDate = rs.getString("board_date");

	        bo = new BoardVO(boardNo1,boardTitle,boardAuthor,boardDate, "");
	    }
	
	    rs.close();
	    ps.close();

	    return bo;
	}
	
	//
	
//	public ArrayList<BoardVO> getBoList(Connection conn) throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("SELECT							");
//		query.append("		 bo_num					");
//		query.append("		,bo_title	");
//		query.append("		,bo_author					");
//		query.append("		,bo_date				");
//		query.append("FROM								");
//		query.append("			bo				"); // 세미콜론이 없음에 주의
//		query.append("ORDER BY stu_num ASC			");
//
//	
//		PreparedStatement ps = conn.prepareStatement(query.toString());
//		ArrayList<BoardVO> result = new ArrayList<>();
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			int boardNo = rs.getInt("bo_num");
//			String boardTitle = rs.getString("bo_title");
//			String boardAuthor = rs.getString("bo_author");
//			String boardDate = rs.getString("bo_date");
//			BoardVO board = new BoardVO(boardNo,boardTitle,boardAuthor,boardDate,"");
//			
//			result.add(board);
//		}
//		
//		
//		ps.close();
//		rs.close();
//		
//		return result;
//	}

	
	
	public int registBoard(Connection conn, String title, String content, String memId) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO bo (			");
		query.append("      bo_num				");
		query.append("    , bo_title			");
		query.append("    , bo_content			");
		query.append("    , bo_author				");
		query.append("    , bo_date				");
		query.append("	) VALUES (				");
		query.append("      (SELECT count(*) + 1 from bo) 					");
		query.append("    , ?						");
		query.append("    , ?						");
		query.append("    , ?						");
		query.append("    , sysdate 					");
		query.append("	)						");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
	
		ps.setString(idx++, title);
		ps.setString(idx++, content);
		ps.setString(idx++, memId);
		
		
		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;
	}
	
	public static void selectNumberTwo() {
	
	}

//	// 글 메소드
//	public int registBoard(Connection conn, BoardVO board) throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("INSERT INTO bo (			");
//		query.append("      bo_num				");
//		query.append("    , bo_title			");
//		query.append("    , bo_content			");
//		query.append("    , bo_date				");
//		query.append("	) VALUES (				");
//		query.append("      ?					");
//		query.append("    , ?					");
//		query.append("    , ?					");
//		query.append("    , ?					");
//		query.append("	)						");
//
//		PreparedStatement ps = conn.prepareStatement(query.toString());
//
//		int idx = 1;
//		ps.setString(idx++, board.getTitle());
//		ps.setString(idx++, board.getContent());
//
//		int cnt = ps.executeUpdate();
//
//		ps.close();
//
//		return cnt;
//	}

}
