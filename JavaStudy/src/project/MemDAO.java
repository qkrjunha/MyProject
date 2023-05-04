package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemDAO {
	
	private MemDAO() {}
	
	private static MemDAO instance = new MemDAO();
	
	public static MemDAO getInstance() {
		return instance;
	}
	// 조회
	public ArrayList<MemVO> getMemList(Connection conn) throws SQLException{
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		mem_id				");
			query.append("	  , mem_pw 	");
			query.append("	  , mem_name			");
			query.append("	  , mem_money			");
			query.append("FROM						");
			query.append("	  members				");	// 세미콜론이 없음에 주의
			query.append("ORDER BY mem_money DESC	");
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<MemVO> result = new ArrayList<>();
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memPw = rs.getString("mem_pw");
				String memName = rs.getString("mem_name");
				int memMoney = rs.getInt("mem_money");
				MemVO mem = new MemVO(memId, memPw, memName, memMoney);
				
				result.add(mem);
			}
			
			ps.close();
			rs.close();
			
			return result;
		}
	// 가입
	public int registMember(Connection conn, String id, String pw, String name) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member (	");
		query.append("      mem_id				");
		query.append("    , mem_pw		");
		query.append("    , mem_name			");
		query.append("    , mem_money			");
		query.append("	) VALUES (				");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("	)						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, id);
		ps.setString(idx++, pw);
		ps.setString(idx++, name);
		ps.setInt(idx++, 0);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	// 로그인
	public MemVO login(Connection conn, MemVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		mem_id				");
		query.append("	  , mem_pw				");
		query.append("	  , mem_name			");
		query.append("	  , mem_money			");
		query.append("FROM						");
		query.append("	  members				");
		query.append("WHERE 1=1					");
		query.append("  AND mem_id = ?			");
		query.append("  AND mem_password = ?	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, member.getMem_id());
		ps.setString(idx++, member.getMem_pw());
		
		ResultSet rs = ps.executeQuery();
		
		MemVO result = new MemVO(null, null, null, idx);
		
		while(rs.next()) {
			result.setMem_id(rs.getString("mem_id"));
			result.setMem_pw(rs.getString("mem_pw"));
			result.setMem_name(rs.getString("mem_name"));
			result.setMem_money(rs.getInt("mem_money"));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
	}

