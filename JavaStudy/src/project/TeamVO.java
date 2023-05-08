package project;

public class TeamVO {
	private String teamName;
	private String teamCm;
	private String teamKg;
	private int teamPrice;
	public TeamVO(String teamName, String teamCm, String teamKg, int teamPrice) {
		super();
		this.teamName = teamName;
		this.teamCm = teamCm;
		this.teamKg = teamKg;
		this.teamPrice = teamPrice;
	}
	@Override
	public String toString() {
		return "TeamVO [teamName=" + teamName + ", teamCm=" + teamCm + ", teamKg=" + teamKg + ", teamPrice=" + teamPrice
				+ "]";
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCm() {
		return teamCm;
	}
	public void setTeamCm(String teamCm) {
		this.teamCm = teamCm;
	}
	public String getTeamKg() {
		return teamKg;
	}
	public void setTeamKg(String teamKg) {
		this.teamKg = teamKg;
	}
	public int getTeamPrice() {
		return teamPrice;
	}
	public void setTeamPrice(int teamPrice) {
		this.teamPrice = teamPrice;
	}

}

