package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;

public class MemService {

	private MemService() {
	}

	private static MemService instance = new MemService();

	public static MemService getInstance() {
		return instance;
	}

	private MemDAO dao = MemDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	// 목록조회
	public ArrayList<MemVO> getStuList() {
		Connection conn = cp.getConnection();
		ArrayList<MemVO> result = new ArrayList<>();

		try {
			result = dao.getMemList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}

		return result;
	}

	public void registMember(String id, String pw, String name) {
		Connection conn = cp.getConnection();

		try {
			dao.registMember(conn, id, pw, name);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	// 로그인(SELECT) 메소드
//		public MemVO login(MemVO student) {
//			Connection conn = cp.getConnection();
//			MemVO result = new MemVO();
//			
//			try {
//				result = dao.login(conn, member);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				cp.releaseConnection(conn);
//			}
//			
//			return result;
//		}
}