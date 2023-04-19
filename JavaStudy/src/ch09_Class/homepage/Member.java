package ch09_Class.homepage;

public class Member {

	private String stuId;		// 학번
	private String id;			// 아이디
	private String password;		// 비밀번호
	private String name;			// 이름

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [stuId=" + stuId + ", id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
	public Member() {}
	
	public Member(String id, String pw, String name) {
		MemberDB memDB = MemberDB.getInstance();
		this.stuId = memDB.makeStuId();
		this.id = id;
		this.password = pw;
		this.name = name;
	}
	
	
	public Member(String stuId, String id, String password, String name) {
		super();
		this.stuId = stuId;
		this.id = id;
		this.password = password;
		this.name = name;
	}

}
