package ch09_Class.homepage;

import java.util.Scanner;

public class HomepageMain {

	public static void main(String[] args) {
		// 회원가입, 로그인
		// 학번, 아이디, 비밀번호, 이름

		MemberDB memDB = MemberDB.getInstance();
		BoardDB boardDB = BoardDB.getInstance();
		
		memDB.showMemberList();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
			System.out.println(">>> ");

			int command = Integer.parseInt(scan.nextLine());
			if (command == 1) {
		
				System.out.println("아이디를 입렵해주세요");
				System.out.println(">>> ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입렵해주세요");
				System.out.println(">>> ");
				String pw = scan.nextLine();

				System.out.println("이름을 입렵해주세요");
				System.out.println(">>> ");
				String name = scan.nextLine();

				Member mem = new Member(memDB.makeStuId(), id, pw, name);
				memDB.registMember(mem);

			} else if (command == 2) {
		
				System.out.println("아이디를 입렵해주세요");
				System.out.println(">>> ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입렵해주세요");
				System.out.println(">>> ");
				String pw = scan.nextLine();

	
				Member login = memDB.login(id, pw);

				if (login != null) {
					
					System.out.println("로그인 성공");
					System.out.println(login.getName());
			
					while (true) {
						
						boardDB.showBoardList();
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						System.out.println(">>> ");

						int select = Integer.parseInt(scan.nextLine());

						if (select == 1) {
							
							System.out.println("글 제목을 입력해주세요");
							System.out.print(">>> ");
							String title = scan.nextLine();
							
							System.out.println("글 내용을 입력해주세요");
							System.out.print(">>> ");
							String content = scan.nextLine();
							
							Board board = new Board(0, title, content, login.getId());
							boardDB.addBoard(board);
							
							
							
							
						}else if (select == 2) {
							// TODO 글조회
							System.out.println("글 번호를 입력해주세요");
							System.out.println(">>> ");
							
							int no = Integer.parseInt(scan.nextLine());
							
							// 1
							// 제목 : 공지사항 필독
							// 작성자 : admin
							// ===================
							// 욕설 금지
							
							boardDB.selectBoard(no);
							
							
						}else {
							
							break;
						}

					}

				} else {
					// 로그인 실패
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

			} else if (command == 3) {
				// 회원목록 조회
				memDB.showMemberList();
			} else {
				// 종료
				System.out.println("종료");
				break;
			}
		}

	}

}
