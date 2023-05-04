package parkjunha.submit13.vo;

public class BoardVO {

	private int num;
	private String title;
	private String content;
	private String author;
	private String date;

	public BoardVO() {
	}

	public BoardVO(int num, String title, String content, String author, String date) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
	}

	@Override
	public String toString() {
		return  "[ " + num + " | " + title + " | " + content + " | " + author + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}