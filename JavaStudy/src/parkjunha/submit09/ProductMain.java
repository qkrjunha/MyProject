package parkjunha.submit09;

import java.util.ArrayList;

public class ProductMain {
	public static void main(String[] args) {

		Product refrigerator = new Product("냉장고", 2000000);
		Product tv = new Product("TV", 1000000);
		Product air = new Product("에어컨", 800000);
		Product com = new Product("컴퓨터", 1300000);
		Product fan = new Product("선풍기", 100000);

		ArrayList<Product> ProductList = new ArrayList<>();

		ProductList.add(refrigerator);
		ProductList.add(tv);
		ProductList.add(air);
		ProductList.add(com);
		ProductList.add(fan);
		
		
		
		for (int k = 0; k < ProductList.size() - 1; k++) {
			for (int i = 0; i < ProductList.size() - 1; i++) {
				if (ProductList.get(i).getPrice() > ProductList.get(i + 1).getPrice()) {
					Product t = ProductList.get(i);
					ProductList.set(i, ProductList.get(i + 1));
					ProductList.set(i + 1, t);
				}
			}
		}

		System.out.println(ProductList.indexOf(tv));

		for (int i = 0; i < ProductList.size(); i++) {

			System.out.println(ProductList.get(i));
			
			//indexof()
			//ArrayList<String> ramen = ["신라면", "안성탕면", "진라면"]
			//ArrayList<Integer> number = [10, 20, 30]
			//ramen.indexof("안성탕면") = 
			
			//여기에 쓴 정렬
			//ArrayList<Product> prodList = [Product 객체(냉장고),Product 객체(TV),...]
			//prodList.indexOf("TV") 쓰면 안나온다.

			
//			for(int i = 0; i < ProductList.size(); i++) {
//			ProductList.get(i).getName().equlas("TV")) {
//				System.out.println(i);
				
				
			}
			
			
		}
	}

