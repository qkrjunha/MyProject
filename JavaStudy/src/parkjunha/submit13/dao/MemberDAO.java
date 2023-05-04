package parkjunha.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import parkjunha.submit13.vo.MemberVO;

public class MemberDAO {
	
private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	// 학생 회원가입(INSERT) 메소드
	public int registMember(Connection conn, String id, String pw) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member (		");
		query.append("      mem_id				");
		query.append("    , mem_password		");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("	)						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, id);
		ps.setString(idx++, pw);
		ps.setInt(idx++, 0);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	
	// 학생 회원가입(INSERT) 메소드
	public int registMember(Connection conn, MemberVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member (		");
		query.append("      mem_id				");
		query.append("    , mem_password		");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("	)						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, member.getMemId());
		ps.setString(idx++, member.getMemPassword());
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	// 로그인(SELECT) 메소드
	// 입력받은 아이디와 비밀번호가 일치하는 하나의 데이터 리턴
	public MemberVO login(Connection conn, MemberVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		mem_id					");
		query.append("	  , mem_password AS pw	");
		query.append("FROM						");
		query.append("	  member				");
		query.append("WHERE 1=1					");
		query.append("  AND mem_id = ?			");
		query.append("  AND mem_password = ?	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, member.getMemId());
		ps.setString(idx++, member.getMemPassword());
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO result = new MemberVO();
		
		// rs에 데이터가 1개 담겨있으면 while문 한번만 실행된다.
		while(rs.next()) {
			result.setMemId(rs.getString("mem_id"));
			result.setMemPassword(rs.getString("pw"));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
}
