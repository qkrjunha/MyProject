package parkjunha.submit11;

import java.util.Scanner;
import java.util.Random;

public class RouletteGame {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
	
		while(true) {
			System.out.println("어서오세요 입장 하실분들은 '입장'을 입력해주세요: ");
			String next = input.nextLine();
			if (next.equals("입장")) {
			System.out.println("입장을 환영합니다.");
				break;
			}
		}
		System.out.print("게임에 참여할 인원 수를 입력하세요 (2~6명): ");
		int Players = input.nextInt();

		while (Players < 2 || Players > 6) {
			System.out.print("잘못된 인원 수입니다. 2~6명 사이의 인원 수를 입력하세요: ");
			Players = input.nextInt();
		}

		String[] Name = new String[Players];

		for (int i = 0; i < Players; i++) {
			System.out.print((i + 1) + "번 플레이어의 이름을 입력하세요: ");
			Name[i] = input.next();
		}
	

		int bullet = (int) (Math.random() * 12) + 1;
		System.out.println("==========================================================================");
		System.out.println("총알이 장전되었습니다. 게임을 시작합니다!");
				
//		java -jar RouletteGame.jar

		int Player = 1;
		int number = 1;
		boolean game = false;

		while (!game) {
			
			System.out.print(Name[Player - 1] + "님의 차례입니다. (1: 격발) ");
			int select = input.nextInt();

			while (select != 1) {
				System.out.print("잘못된 입력입니다. 다시 입력해주세요. (1: 격발) ");
				select = input.nextInt();
			}
			System.out.println("==========================================================================");
			System.out.println(Name[Player - 1] + "님이 생존하셨습니다.");
			System.out.println("빵!!");
			System.out.println("        |\\___________________,");
			System.out.println("       |    ===== _______)___) ==========|||)");
			System.out.println("      |	   ||----||");
			System.out.println("   __/___   ====/");
			System.out.println("  (O___)\\\\_(_/");
			System.out.println(" (O___)");
			System.out.println("(O___)");
			System.out.println();
			if (number == bullet) {
				System.out.println("==========================================================================");
				System.out.println(Name[Player - 1] + "님이 총알에 맞았습니다. 게임이 종료됩니다.");
				game = true;
			} else {
				number++;
				if (number == 13) {
					number = 1;
				}
			}

			if (!game) {
				Player++;
				if (Player > Players) {
					Player = 1;
				}
				System.out.println("==========================================================================");
				System.out.println("현재 탄창 위치: " + number);
			}
		}

		System.out.println("게임이 종료되었습니다.");
	}

}
