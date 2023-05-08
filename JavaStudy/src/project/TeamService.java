package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;

public class TeamService {
private TeamService() {}
	
	private static TeamService instance = new TeamService();
	
	public static TeamService getInstance() {
		return instance;
	}
	private TeamDAO dao = TeamDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public ArrayList<TeamVO> getPlayList(){
		Connection conn = cp.getConnection();
		ArrayList<TeamVO> result = new ArrayList<>();
		
		try {
			result = dao.getTeamList(conn); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}
	} 

