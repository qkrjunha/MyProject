package parkjunha.submit12;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Board {
	private int num;
	private String name;
	private String day;
	private String content;
	
	public Board() {
		
	}
	public Board(String name, String day, String content) {
		BoardDB db = BoardDB.getInstance();
		this.num = db.makeNumber();
		this.name = name;
//		Date currentTime = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		this.day = day;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", day=" + day + ", content=" + content + "]";
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
