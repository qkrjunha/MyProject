package parkjunha.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;

import parkjunha.submit13.context.ConnectionPool;
import parkjunha.submit13.dao.MemberDAO;
import parkjunha.submit13.vo.MemberVO;

public class MemberService {
	
	private MemberService() {}
	
	private static MemberService instance = new MemberService();
	
	public static MemberService getInstance() {
		return instance;
	}
	
	private MemberDAO dao = MemberDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	
	
	// 회원가입 메소드
	public void registMember(String id, String pw) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registMember(conn, id, pw);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	} 
	
	public void registMember(MemberVO member) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registMember(conn, member);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	} 
	// 로그인(SELECT) 메소드
		public MemberVO login(MemberVO member) {
			Connection conn = cp.getConnection();
			MemberVO result = new MemberVO();
			
			try {
				result = dao.login(conn, member);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cp.releaseConnection(conn);
			}
			
			return result;
		}
}