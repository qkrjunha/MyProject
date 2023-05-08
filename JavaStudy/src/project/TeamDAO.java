package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamDAO {
private TeamDAO() {}
	
	private static TeamDAO instance = new TeamDAO();
	
	public static TeamDAO getInstance() {
		return instance;
	}
	public ArrayList<TeamVO> getTeamList(Connection conn) throws SQLException{

		StringBuffer query = new StringBuffer();
		query.append("SELECT					");
		query.append("		  team_name				");
		query.append("	 ,team_cm  	");
		query.append("	    ,team_kg 		");
		query.append("	  ,team_price 		");
		query.append("FROM						");
		query.append("	team						");
		query.append("ORDER BY team_price DESC	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		
		ArrayList<TeamVO> result = new ArrayList<>();
		while(rs.next()) {

			

			String teamname = rs.getString("team_name");
			String teamcm = rs.getString("team_cm");
			String teamkg = rs.getString("team_kg");
			int teamprice = rs.getInt("team_price");
			TeamVO team = new TeamVO(teamname, teamcm, teamkg, teamprice);
			
			result.add(team);
		}
		
		ps.close();
		rs.close();
		
		return result;
	}
	
}

