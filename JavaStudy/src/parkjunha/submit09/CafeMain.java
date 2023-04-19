package parkjunha.submit09;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		
//		ArrayList<Coffee> starBucks = new ArrayList<>();
//		starBucks.add(new Coffee("아메리카노", 7000));
//		starBucks.add(new Coffee("카푸치노", 8000));
//		starBucks.add(new Coffee("바닐라라떼", 8500));
//
//		ArrayList<Coffee> conte = new ArrayList<>();
//		conte.add(new Coffee("아메리카노", 2000));
//		conte.add(new Coffee("레몬차", 5000));
//		conte.add(new Coffee("말차라떼", 6000));		
		
		Cafe starBucks = new Cafe("스타벅스");
		starBucks.addCoffee(new Coffee("아메리카노", 5000));
		starBucks.addCoffee(new Coffee("카푸치노", 6000));
		starBucks.addCoffee(new Coffee("오곡라떼", 7000));
		
		Cafe conte = new Cafe("꽁떼");
		conte.addCoffee(new Coffee("아메리카노", 2500));
		conte.addCoffee(new Coffee("바닐라라떼", 3000));
		conte.addCoffee(new Coffee("아이스티", 3500));

			

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀..");
			System.out.print(">>> ");
			int select = Integer.parseInt(sc.nextLine());

			if (select == 1) {
				// TODO 스타벅스 방문
				System.out.println("어서오세요. 스타벅스입니다.");
				starBucks.showMenu();
				starBucks.buyCoffee(sc);
//				ArrayList<Coffee> starList = starBucks.getMenuList();
//				
//				for (int i = 0; i < starList.size(); i++) {
//					System.out.println((i + 1) + ". " + starList.get(i));
//
//				}

//				System.out.print("메뉴를 선택해주세요.");
//				int coice = Integer.parseInt(sc.nextLine());
//
//				System.out.println(
//						starList.get(coice - 1).getName() + "를 " + starList.get(coice - 1).getPrice() + "원에 구매했습니다.");

			} else if (select == 2) {
				// TODO 꽁떼 방문
				System.out.println("어서오세요. 꽁떼입니다.");
				conte.showMenu();
				conte.buyCoffee(sc);
//				ArrayList<Coffee> conteList = conte.getMenuList();
//				for (int i = 0; i < conteList.size(); i++) {
//					System.out.println((i + 1) + ". " + conteList.get(i));
//
//				}

//				System.out.print("메뉴를 선택해주세요.");
//				int coice = Integer.parseInt(sc.nextLine());
//
//				System.out.println(
//						conteList.get(coice - 1).getName() + "를 " + conteList.get(coice - 1).getPrice() + "원에 구매했습니다.");

			} else {
				// 사무실 복귀
				System.out.println("사무실로 복귀합니다.");
				break;
			}
		}

	}
}
