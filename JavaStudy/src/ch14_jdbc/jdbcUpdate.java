package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUpdate {

	public static void main(String[] args) {

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
			
		conn = DriverManager.getConnection(url, id, pw);

		StringBuffer query = new StringBuffer();
		query.append("UPDATE  					");
		query.append("		students			");
		query.append("SET 						");
		query.append("    stu_score = stu_score + 1		");
//		query.append("    stu_password = ?		");
		query.append("WHERE 1=1					");
		query.append("	AND stu_id = ? 		");
		
	
		ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++,"d001");
		
		int cnt = ps.executeUpdate();
		
		System.out.println(cnt + "행 이(가) 수정되었습니다.");
		
		
		
		
		// 업데이트문 실행 후 SELECT 문 실행하여
		// 변경사항 확인		
		query = new StringBuffer();
		query.append("SELECT				");
		query.append("		stu_id		");
		query.append("		, stu_password	AS passw	");
		query.append("		, stu_name		");
		query.append("		, stu_score		");
		query.append("FROM		");
		query.append("		students		"); // 세미콜론이 없어야됨
		
		// 사용했던 ps는 한번 닫아준뒤 사용
		ps.close();
		ps = conn.prepareStatement(query.toString());
		
		rs = ps.executeQuery();
		
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
			if(ps != null) try {ps.close();} catch (SQLException e) {e.printStackTrace();}				
			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}				
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}				
			
			
		}
	}
}
		
		
	
