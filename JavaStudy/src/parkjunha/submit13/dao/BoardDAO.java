package parkjunha.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	// 학생 회원가입(INSERT) 메소드
	public int registBoard(Connection conn, String title, String content) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO board (		");
		query.append("      bo_num				");
		query.append("    , bo_title			");
		query.append("    , bo_content			");
		query.append("    , bo_date				");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("	)						");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, title);
		ps.setString(idx++, content);

		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;
	}

	// 글 메소드
	public int registBoard(Connection conn, BoardVO board) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO board (		");
		query.append("      bo_num				");
		query.append("    , bo_title			");
		query.append("    , bo_content			");
		query.append("    , bo_date				");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("	)						");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, board.getTitle());
		ps.setString(idx++, board.getContent());

		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;
	}

}
