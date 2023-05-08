package project;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.vo.Memvo;

public class MemMain {
	public static void main(String[] args) {

		PlayerService playService = PlayerService.getInstance();
		MemService memService = MemService.getInstance();

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

				System.out.println("이름을 입력해주세요: ");
				System.out.print(">>> ");
				String name = scan.nextLine();

				MemVO mem = new MemVO(id, pw, name, 0);
				memService.registMember(mem);

			} else if (command == 2) {
				System.out.println("아이디를 입력해주세요: ");
				System.out.print(">>> ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요: ");
				System.out.print(">>> ");
				String pw = scan.nextLine();

				MemVO member = new MemVO();
				member.setMemId(id);
				member.setMemPw(pw);

				MemVO login = memService.login(member);
				if (login.getMemId() != null) {
					System.out.println("로그인 되었습니다.");

					while (true) {
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 승부차기 | 2. 자산 | 3. 목록 | 4. 구매 | 5. 로그아웃");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}

						if (select == 1) {
							int wins = 0; // 이긴 횟수를 저장하기 위한 변수
							for (int i = 0; i < 5; i++) { // 5번 반복
								int computer = (int) (Math.random() * 3) + 1;
								System.out.println("어느쪽으로 차시겠습니까? (1: 왼쪽, 2: 가운데, 3: 오른쪽): ");
								System.out.print(">>> ");
								int user = 0;
								try {
									user = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException ex) {
									System.out.println("숫자로 입력해주세요");
									i--; 
									continue;
								}

								if (user >= 1 && user <= 3) {
									if (user == computer) {
										System.out.println("같은 숫자를 입력하셨습니다!" + " 득점에 실패하셨습니다!");
									} else {
										String computerPosition;
										if (computer == 1) {
											computerPosition = "왼쪽";
										} else if (computer == 2) {
											computerPosition = "가운데";
										} else {
											computerPosition = "오른쪽";
										}

										String userPosition;
										if (user == 1) {
											userPosition = "왼쪽";
										} else if (user == 2) {
											userPosition = "가운데";
										} else {
											userPosition = "오른쪽";
										}

										System.out.println("컴퓨터: " + computerPosition);
										System.out.println(userPosition + "을 입력하였습니다! 득점에 성공하셨습니다!");
										wins++;
									}
								} else {
									System.out.println("잘못된 숫자입니다.");
									i--; // 잘못된 숫자 입력 시에도 횟수를 감소시켜 다시 시도하도록 함
								}
							}
							System.out.println("승부차기 종료!");
							System.out.println("득점 횟수: " + wins + "번");
//							if (wins >= 3) {
//								memService.plusPirce(login.getMemId());
							} else if (select == 2) {
//								ArrayList<Memvo> stuList = stuService.getStuList();
//								for(int i = 0; i < stuList.size(); i++) {
//									System.out.println((i+1) + "등. " 
//											+ stuList.get(i).getStuName() + "님 | "
//											+ stuList.get(i).getStuScore());
								
//								for(int i = 0; i< priceList.size(); i++) {
//									System.out.println(priceList.get(i).getMemId() + "님의 자산은" 
//											+ priceList.get(i).getMemPrice() + "입니다.");
								ArrayList<MemVO> priceList = memService.getPriceList();
								 String logInId = login.getMemId();
								 for (MemVO memVO : priceList) {
								        if (memVO.getMemId().equals(logInId)) {
								            System.out.println(memVO);
								        }
							}
								
							} else if (select == 3) {

							} else if (select == 4) {
								ArrayList<PlayerVO> playList = playService.getPlayList();
								for (int i = 0; i < playList.size(); i++) {
									System.out.println(playList.get(i));

							            
									// playList에 get name에서 이름 받고 차감업데이트 실시
								}
							} else if (select == 5) {
								break;
							} else {
								System.out.println("다시 입력해주세요.");
							}
						}
					}
				}
			}
		}
	}
