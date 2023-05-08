package project;

public class PlayerVO {
	private String playerName;
	private String playerCm;
	private String playerKg;
	private int playerPrice;
	public PlayerVO(String playerName, String playerCm, String playerKg, int playerPrice) {
		super();
		this.playerName = playerName;
		this.playerCm = playerCm;
		this.playerKg = playerKg;
		this.playerPrice = playerPrice;
	}
	@Override
	public String toString() {
		return "선수목록 [선수이름=" + playerName + ", 키=" + playerCm + ", 몸무게=" + playerKg
				+ ", 가격=" + playerPrice + "]";
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerCm() {
		return playerCm;
	}
	public void setPlayerCm(String playerCm) {
		this.playerCm = playerCm;
	}
	public String getPlayerKg() {
		return playerKg;
	}
	public void setPlayerKg(String playerKg) {
		this.playerKg = playerKg;
	}
	public int getPlayerPrice() {
		return playerPrice;
	}
	public void setPlayerPrice(int playerPrice) {
		this.playerPrice = playerPrice;
	}
	
	
}
