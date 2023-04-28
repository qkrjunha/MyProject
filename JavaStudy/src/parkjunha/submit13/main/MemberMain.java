package parkjunha.submit13.main;

import java.util.Scanner;

import ch14_jdbc_jsp.vo.StudentVO;
import parkjunha.submit13.service.BoardService;
import parkjunha.submit13.service.MemberService;
import parkjunha.submit13.vo.BoardVO;
import parkjunha.submit13.vo.MemberVO;

public class MemberMain {
	public static void main(String[] args) {

		MemberService memService = MemberService.getInstance();
		BoardService boService = BoardService.getInstance();

		
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
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요: ");
				String pw = scan.nextLine();

				MemberVO mem = new MemberVO(id, pw);
				memService.registMember(mem);

			} else if (command == 2) {
				System.out.println("아이디를 입력해주세요: ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요: ");
				String pw = scan.nextLine();

				MemberVO member = new MemberVO();
				member.setMemId(id);
				member.setMemPassword(pw);

				MemberVO login = memService.login(member);
				if (login.getMemId() != null) {
					System.out.println("로그인 되었습니다.");

					while (true) {
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}
						
						if(select == 1) {
						System.out.println("글 제목을 입력해주세요.");
						String title = scan.nextLine();
						
						System.out.println("글 내용을 입력해주세요.");
						String content = scan.nextLine();

						System.out.println("글이 작성되었습니다.");

						
						BoardVO bo = new BoardVO(0, title, content, content);
						boService.registBoard(bo);

						
//						BoardVO bo = new BoardVO(title, content);
						
						}else if( select == 2) {
							System.out.println("글 번호를 입력해주세요");
							System.out.println(">>> ");
							int no = Integer.parseInt(scan.nextLine());

//							boardDB.selectBoard(no);

							
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


