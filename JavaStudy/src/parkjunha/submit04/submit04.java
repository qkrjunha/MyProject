package parkjunha.submit04;

import java.util.Scanner;

public class submit04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("거꾸로 뒤집을 문자열 입력:");
		String input = scan.nextLine();

		for (int i = 0; i < input.length(); i++) {
			System.out.print(input.substring((input.length() - 1) - i, input.length() - i));

			/*
			 * String result = ""; for (int i=0; i<input.length() ; i++) { String str =
			 * input.subString(i, i+1); System.out.println(str); result += str; // result =
			 * str + result; 도 가능 } System.out.println("뒤집은 문자열 :" + result);
			 */
		}

		System.out.println("\n========== 2번 ==========\n");

//		int elevatorA = 10;
//		int elevatorB = 4;
//		while (true) {
//			System.out.println("\n========== 희영빌딩 엘리베이터 ========\n");
//			System.out.println("승강기 A의 현재 위치:" + elevatorA + "층:");
//			System.out.println("승가기 B의 현재 위치:" + elevatorB + "층:");
//			System.out.println("몇층에 계시나요 ? [종료는 q 또는 exit]:");
//			String inputText = scan.nextLine();
//			if (inputText.equals("q") || inputText.equals("exit")) {
//				System.out.println("프로그램이 종료되었습니다.");
//				break;
//			}
//
//			int floor1 = Integer.parseInt(inputText);
//			// 층수 차이 계산
//			int diffA = Math.abs(elevatorA - floor1);
//			int diffB = (elevatorB < floor1) ? (floor1 - elevatorB) : (elevatorB - floor1);
////				if(diffB < 0) {  음수면 -1을 곱하라고 선언해서 절댓값대신 써도됨
////					diifB *-1;
//			if (diffA > diffB) {
//				System.out.println("엘리베이터 B가" + floor1 + "층으로 이동하였습니다.");
//				elevatorB = floor1;
//			} else if (diffA < diffB) {
//				System.out.println("엘리베이터 A가" + floor1 + "층으로 이동하였습니다.");
//				elevatorA = floor1;
//			} else {
//
//				if (elevatorA > elevatorB) {
//					System.out.println("엘리베이터 A가" + floor1 + "층으로 이동하였습니다.");
//					elevatorA = floor1;
//				} else {
//					System.out.println("엘리베이터 B가" + floor1 + "층으로 이동하였습니다.");
//					elevatorB = floor1;
//
//				}
//
//			}

			boolean isRun = true;
			while (true) {
				String a = "승강기 A";
				String b = "승강기 B";
				int randoma = ((int) (Math.random() * 10) + 1);
				int randomb = ((int) (Math.random() * 10) + 1);
				System.out.println(a + "의 현재 위치:" + randoma + "층:");
				System.out.println(b + "의 현재 위치:" + randomb + "층:");
				System.out.println("몇층에 계시나요 ? [종료는 q 또는 exit]:");
				String floor = scan.nextLine();
				if (floor.equals("q") || floor.equals("exit")) {
					System.out.println("프로그램이 종료되었습니다.");
					break;

				}
				int apha = Math.abs(randoma - Integer.parseInt(floor));
				int beta = Math.abs(randomb - Integer.parseInt(floor));
				if (apha > beta) {
					System.out.println(floor + "층에서 엘리베이터를 호출합니다.");
					System.out.println(b + "가" + floor + "층으로 이동하였습니다. ");
					System.out.println("\n========== 희영빌딩 엘리베이터 ========\n");
					randomb = Integer.parseInt(floor);
				} else if (beta > apha) {
					System.out.println(floor + "층에서 엘리베이터를 호출합니다.");
					System.out.println(a + "가" + floor + "층으로 이동하였습니다.");
					System.out.println("\n========== 희영빌딩 엘리베이터 ========\n");
					randoma = Integer.parseInt(floor);
				} else if (apha == beta) {
					if (randoma > randomb) {
						System.out.println(floor + "층에서 엘리베이터를 호출합니다.");
						System.out.println(a + "가" + +Integer.parseInt(floor) + "층으로 이동하였습니다.");
						System.out.println("\n========== 희영빌딩 엘리베이터 ========\n");
						randoma = Integer.parseInt(floor);

					} else if (randomb > randoma) {
						System.out.println(floor + "층에서 엘리베이터를 호출합니다.");
						System.out.println(b + "" + +Integer.parseInt(floor) + "층으로 이동하였습니다.");
						System.out.println("\n========== 희영빌딩 엘리베이터 ========\n");
						randomb = Integer.parseInt(floor);
					}
				}
			}
		}
	}
