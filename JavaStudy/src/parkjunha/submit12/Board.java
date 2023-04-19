package parkjunha.submit12;

public class Board {
	private int num;
	private String name;
	private String day;
	private String nayong;
	
	public Board() {
		
	}
	public Board(int num, String name, String day, String nayong) {
		super();
		this.num = num;
		this.name = name;
		this.day = day;
		this.nayong = nayong;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", day=" + day + ", nayong=" + nayong + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getNayong() {
		return nayong;
	}
	public void setNayong(String nayong) {
		this.nayong = nayong;
	}

}
