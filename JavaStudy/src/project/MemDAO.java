package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.vo.Memvo;



public class MemDAO {
	
private MemDAO() {}
	
	private static MemDAO instance = new MemDAO();
	
	public static MemDAO getInstance() {
		return instance;
	}
	
	// 회원가입
//	public int registMember(Connection conn, String id, String pw, String name) throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("INSERT INTO member (		");
//		query.append("      mem_id				");
//		query.append("    , mem_pw		");
//		query.append("    , mem_name		");
//		query.append("	) VALUES (				");
//		query.append("      ?					");
//		query.append("    , ?					");
//		query.append("    , ?					");
//		query.append("	)						");
//		
//		PreparedStatement ps = conn.prepareStatement(query.toString());
//		
//		int idx = 1;
//		ps.setString(idx++, id);
//		ps.setString(idx++, pw);
//		ps.setString(idx++, name);
//		ps.setInt(idx++, 0);
//		
//		int cnt = ps.executeUpdate();
//		
//		ps.close();
//		
//		return cnt;
//	}
	
	// 회원가입
	public int registMember(Connection conn, MemVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO members (		");
		query.append("      mem_id				");
		query.append("    , mem_pw				");
		query.append("    , mem_name				");
		query.append("    , mem_price				");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , 0					");
		query.append("	)						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, member.getMemId());
		ps.setString(idx++, member.getMemPw());
		ps.setString(idx++, member.getMemName());
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	// 로그인
	public MemVO login(Connection conn, MemVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		mem_id					");
		query.append("	  , mem_pw	");
		query.append("FROM						");
		query.append("	  members				");
		query.append("WHERE 1=1					");
		query.append("  AND mem_id = ?			");
		query.append("  AND mem_pw = ?	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, member.getMemId());
		ps.setString(idx++, member.getMemPw());
		
		ResultSet rs = ps.executeQuery();
		
		MemVO result = new MemVO();
		
		while(rs.next()) {
			result.setMemId(rs.getString("mem_id"));
			result.setMemPw(rs.getString("mem_pw"));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
	
	
	// 자산
	public ArrayList<MemVO> getPriceList(Connection conn) throws SQLException{

		StringBuffer query = new StringBuffer();
		query.append("SELECT					");
		query.append("      mem_id				");
		query.append("    , mem_pw				");
		query.append("    , mem_name				");
		query.append("	  ,mem_price 		");
		query.append("FROM						");
		query.append("	members						");
//		query.append("	WHERE 1 =1 						");
//		query.append("	AND mem_id = ?						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemVO> result = new ArrayList<>();
		while(rs.next()) {

			

			String memId = rs.getString("mem_id");
			String memPw = rs.getString("mem_pw");
			String memName = rs.getString("mem_name");
			int memPrice = rs.getInt("mem_price");
			MemVO play = new MemVO(memId, memPw, memName, memPrice);
			
			result.add(play);
		}
		
		ps.close();
		rs.close();
		
		return result;
	}
	// 보상금
	public int plusPirce(Connection conn, String memberId) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE 		 					");
		query.append("		members		 			");
		query.append("SET 								");
		query.append("      mem_price = mem_price + 500000	");
		query.append("WHERE	1=1							");
		query.append("  AND mem_id = ?					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setString(1, memberId);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	}
//구매를 했을때
//차감 update
//선수 insert
