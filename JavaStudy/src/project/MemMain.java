package project;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.service.WordGameService;
import ch14_jdbc_jsp.vo.Memvo;
import ch14_jdbc_jsp.vo.WordGameVO;

public class MemMain {

	public static void main(String[] args) {
		StudentService stuService = StudentService.getInstance();
		MemService memService = MemService.getInstance();

			
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
			System.out.print(">>> ");

			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}

			if (command == 1) {
				// 로그인
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				Memvo mem = new Memvo();
				mem.setStuId(id);
				mem.setStuPassword(pw);

				Memvo login = stuService.login(mem);
				if (login.getStuId() != null) {
					System.out.println(login.getStuId() + "님 환영합니다.");

					// 끝말잇기 시작
					while (true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 게임 | 2. 팀 | 3. 선수 | 4. 랭킹 | 5. 보유자산 | 6. 로그아웃");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}

						if (select == 1) {
							ArrayList<Memvo> stuList = stuService.getStuList();
							for (int i = 0; i < stuList.size(); i++) {
								System.out.println(stuList.get(i).getStuName() + "님 자산은" + stuList.get(i).getStuId() + "원 입니다.");
							}

						} else if (select == 2) {
		

						} else if (select == 3) {
							
						} else if (select == 4) {
							ArrayList<Memvo> stuList = stuService.getStuList();
							for (int i = 0; i < stuList.size(); i++) {
								System.out.println((i + 1) + "등. " + stuList.get(i).getStuName() + " | "
										+ stuList.get(i).getStuScore());
							}
						} else if (select == 5) {
							break;
						
						} else {
							System.out.println("다시 입력해주세요");
						}

					}

				} else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

			} else if (command == 2) {
				// 회원가입
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				System.out.print("닉네임 : ");
				String name = scan.nextLine();

				Memvo stu = new Memvo(id, pw, name, 0);
				stuService.registStudent(stu);

			} else if (command == 3) {
				// 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}

		}

	}

}