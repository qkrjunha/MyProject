package parkjunha.submit09;

public class Product {

	private String name;
	private int price;
	
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "submit09 [제품=" + name + ", 가격=" + price + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
