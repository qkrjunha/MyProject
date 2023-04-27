package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelect {

	public static void main(String[] args) {
		
		// 1번 드라이버 로딩
		// (프로젝트 내에서 단 한번만 실행이 되면 됨
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 등록 실패");
			System.exit(0);  // 현재 프로그램 종료
		}
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "jdbc";
		String pw = "oracle";
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 2번 커넥션 객체 생성
			// 오라클 DB와 접속이 된 객체를 리턴
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 커넥션 성공");
		
		// 3번 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		stu_id		");
		query.append("		, stu_password	AS passw	");
		query.append("		, stu_name		");
		query.append("		, stu_score		");
		query.append("FROM		");
		query.append("		students		"); // 세미콜론이 없어야됨
		
		// 4번 쿼리문을 보유하고 실행할 수 있는 객체(PreparedStatement) 생성
		ps = conn.prepareStatement(query.toString());
		
		// 5번 쿼리문 실행
		// SELECT문의 경우는 실행결과 ResultSet에 담는다.
		rs = ps.executeQuery();
		
		// 6번 ResultSet에 담긴 데이터 조회
		while(rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야함
			// AS 적용 가능(위에 AS 넣었으면 getString에도 AS 이름값으로바꿔야됨)
			String stuId = rs.getString("stu_id");
			String stuPw = rs.getString("passw");
			String stuName = rs.getString("stu_name");
			int stuScore = rs.getInt("stu_score");
			
			System.out.println("아이디:" + stuId 
					+ "비밀번호:" + stuPw 
					+ "이름:" + stuName 
					+ "점수:" + stuScore);
			
			
			
		}
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 7번 DB 연결에 사용된 자원정리
			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}				
			if(ps != null) try {ps.close();} catch (SQLException e) {e.printStackTrace();}				
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}				
			
			
		}
		
		
		
	}

}