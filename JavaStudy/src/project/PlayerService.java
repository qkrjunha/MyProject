package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.vo.Memvo;


public class PlayerService {

private PlayerService() {}
	
	private static PlayerService instance = new PlayerService();
	
	public static PlayerService getInstance() {
		return instance;
	}
	private PlayerDAO dao = PlayerDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public ArrayList<PlayerVO> getPlayList(){
		Connection conn = cp.getConnection();
		ArrayList<PlayerVO> result = new ArrayList<>();
		
		try {
			result = dao.getPlayList(conn); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}
	} 

