package parkjunha.submit12;

public class CartoonBoard extends Board{

	private String image;
	
	public CartoonBoard(int num, String name, String day, String nayong, String image) {
		super( name, day, nayong);
		this.image = image;
	}
	@Override
	public String toString() {
		return "CartoonBoard [num=" + super.getNum() + ", name=" + super.getName() + ", day=" + super.getDay() + ", nayong=" + super.getContent() + ", image="
				+ image + "]";
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
