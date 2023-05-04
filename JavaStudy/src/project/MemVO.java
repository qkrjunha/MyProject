package project;

public class MemVO {

	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private int mem_money;

	public MemVO(String mem_id, String mem_pw, String mem_name, int mem_money) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_money = mem_money;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_money="
				+ mem_money + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getMem_money() {
		return mem_money;
	}

	public void setMem_money(int mem_money) {
		this.mem_money = mem_money;
	}

}
