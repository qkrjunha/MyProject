package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PlayerDAO {
private PlayerDAO() {}
	
	private static PlayerDAO instance = new PlayerDAO();
	
	public static PlayerDAO getInstance() {
		return instance;
	}
	public ArrayList<PlayerVO> getPlayList(Connection conn) throws SQLException{

		StringBuffer query = new StringBuffer();
		query.append("SELECT					");
		query.append("		  player_name				");
		query.append("	 ,player_cm  	");
		query.append("	    ,player_kg 		");
		query.append("	  ,player_price 		");
		query.append("FROM						");
		query.append("	player						");
		query.append("ORDER BY player_price DESC	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		
		ArrayList<PlayerVO> result = new ArrayList<>();
		while(rs.next()) {

			

			String playername = rs.getString("player_name");
			String playercm = rs.getString("player_cm");
			String playerkg = rs.getString("player_kg");
			int playerprice = rs.getInt("player_price");
			PlayerVO play = new PlayerVO(playername, playercm, playerkg, playerprice);
			
			result.add(play);
		}
		
		ps.close();
		rs.close();
		
		return result;
	}
	
}
