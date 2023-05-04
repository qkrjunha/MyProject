package parkjunha.submit13.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.vo.Memvo;
import parkjunha.submit13.service.BoardService;
import parkjunha.submit13.service.MemberService;
import parkjunha.submit13.vo.BoardVO;
import parkjunha.submit13.vo.MemberVO;

public class MemberMain {
	public static void main(String[] args) {

		MemberService memService = MemberService.getInstance();
		BoardService boService = BoardService.getInstance();
		StudentService stuService = StudentService.getInstance();

		
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>> ");	

			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}

			if (command == 1) {
				

				System.out.println("아이디를 입력해주세요: ");
				System.out.print(">>> ");	
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요: ");
				System.out.print(">>> ");	
				String pw = scan.nextLine();

				MemberVO mem = new MemberVO(id, pw);
				memService.registMember(mem);

			} else if (command == 2) {
				System.out.println("아이디를 입력해주세요: ");
				System.out.print(">>> ");	
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요: ");
				System.out.print(">>> ");	
				String pw = scan.nextLine();

				MemberVO member = new MemberVO();
				member.setMemId(id);
				member.setMemPassword(pw);

				MemberVO login = memService.login(member);
				if (login.getMemId() != null) {
					System.out.println("로그인 되었습니다.");

					while (true) {
						System.out.println("행동을 선택해주세요.");
						System.out.println("1.게임  |2. 순위 | 3. 로그아웃 ");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}
						
						if(select == 1) {
						// 목록	
							ArrayList<Memvo> stuList = stuService.getStuList();
							for(int i = 0; i < stuList.size(); i++) {
								System.out.println(stuList.get(i));
						/*
						 * Random random = new Random();
        int target = random.nextInt(3) + 1;  // 1, 2, 3 중 하나를 무작위로 선택
        System.out.println("승부차기 게임을 시작합니다.");
        System.out.println("1번 왼쪽, 2번 가운데, 3번 오른쪽 중 하나를 선택하세요.");
        int input = scanner.nextInt();
        if (input == target) {
            System.out.println("축하합니다! 골!");
        } else {
            System.out.println("실패했습니다. 다시 시도하세요.");
        }
    }
}
						 * 
						 * 	
						 */
						

							}
						
	

						
						}else if( select == 2) {
							System.out.println("입력해주세요");
							System.out.println(">>> ");
							String writeNumber = scan.nextLine();
							
							int no = Integer.parseInt(scan.nextLine());
							
							
							ArrayList<BoardVO> boList = boService.getBoList();
							for(int i = 0; i < boList.size(); i++) {
								System.out.println(boList.get(i));
							}
							

							
					}else if(select ==3) {
						break;
					}else {
						System.out.println("다시 입력해주세요.");
					}
				}
			}
		}
	}
	}
}


//ArrayList<StudentVO> stuList = stuService.getStuList();
//for(int i = 0; i < stuList.size(); i++) {
//	System.out.println(stuList.get(i));
// 목록보기

//  System.out.println("입력해주세요.");
//	System.out.print(">>> ");	
//	String title = scan.nextLine();		
//	System.out.println("입력해주세요.");
//	System.out.print(">>> ");	
//	String content = scan.nextLine();

