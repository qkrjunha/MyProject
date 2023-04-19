package parkjunha.submit12;

import java.util.ArrayList;
import java.util.Scanner;

import parkjunha.submit10.Book;

public class BoardMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				
		//		library.showBookList();
				int no = Integer.parseInt(scan.nextLine());



			} else if (command == 2) {
				
				System.out.println("글 제목을 입력해주세요: ");
				String name = scan.nextLine();
				System.out.println("글 내용을 입력해주세요: ");
				String nayong = scan.nextLine();
				System.out.print(">>> ");


			} else {
				System.out.println("종료합니다.");
				break;
		}
	}

	}
}
