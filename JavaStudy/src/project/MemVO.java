package project;

public class MemVO {
	private String memId;
	private String memPw;
	private String memName;
	private int memPrice;

	public MemVO() {}
	public MemVO(String memId, String memPw, String memName, int memPrice) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memPrice = memPrice;
	}
	@Override
	public String toString() {
		return "보유자산 = " + memId + "님의 보유자산은 "  + memPrice
				+ "원 입니다";
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemPrice() {
		return memPrice;
	}
	public void setMemPrice(int memPrice) {
		this.memPrice = memPrice;
	}
	
	

	

}

