package parkjunha.submit13.dao;

public class BoardDAO {

	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
}
