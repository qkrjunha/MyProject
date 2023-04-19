package ch06_method;

import java.util.Scanner;

public class MethodMain {

	public static void main(String[] args) {
		// 메소드 = method = 함수 = function
		// 굳이 나누자면 method는 클래스에 종속된 함수를 말하며,
		// function은 클래스에 독립적인 함수를 말한다.
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		sum = 0;
		for (int id = 30; id <= 60; id++) {
			sum += id;
		}
		System.out.println(sum);

		sum = 0;
		for (int is = 25; is <= 50; is++) {
			sum += is;
		}
		System.out.println(sum);

		System.out.println("\n=====================================\n");

		// 위 작업을 함수로 만들기
		// 메소드 실행
		// 70부터 90까지 더하기
		printSum(70, 90);

		// 함수를 쓰면 좋은점
		// 실행부의 코드가 간결해진다(가독성증강)
		// 중복된 코드를 함수로 만들어서 사용하면
		// 해당 코드를 한 곳에서 관리할 수 있으므로 수정할때 용이

		// 리턴값이 존재하는 함수 만들기
		returnSum(80, 90); // 리턴값을 사용하고 있지 않음

		int rst = returnSum(80, 90);
		System.out.println(rst);

		System.out.println("\n=====================================\n");

		// System.out.println(); 를 print() 만들어쓰기
		print("파이썬 저리가라");
		System.out.println("파이썬 저리가라");

		System.out.println(returnSum(1, 10));
		System.out.println(55);
		print(55);

		System.out.println("\n=====================================\n");

		// 절댓값 구해주는 메소드 만들기
		int number = Math.abs(-10);
		System.out.println(number);

		number = absolute(-10);
		System.out.println(number);

		System.out.println("\n=====================================\n");

		// 이름, 국어 점수, 영어 점수, 수학 점수를 파라미터로 넣으면
		// 이름 : 가 국어 : 90 영어 : 85 수학 : 87 평균 : 87.11 등급 : B
		// (90점 이상 A, 80점 이상 B, 그 외 C)
		makeCard("가", 90, 90, 89);

		
		System.out.println("\n=====================================\n");
		
		//Loopfor 에서 했던 각 자리수 더하기 메소드화
//		int sum1 = eachAdd(33333);
//		System.out.println(sum1);
		
		System.out.println("\n=====================================\n");
		
		//LoopWhile에서 했던 포켓몬스터 메소드로 만들기
		playPokemon();
		
		System.out.println("\n=====================================\n");
		// 재귀함수 (Recursion Fuction)
		// 메소드 내부에서 해당 메소드를 또 실행하는 경우
		// 메소드를 반복 실행
		
		// 5 
		// 4
		// 3
		// 2
		// 1
		
//		for(int i = 5; i >=1; i--) {
//			System.out.println(i);
//		}                            를 재귀함수로
		
		recursionPrint(5);
		
		System.out.println("\n=====================================\n");

		//재귀함수 팩토리얼
		long no = Factorial(5);
		System.out.println(no);
		
		//재귀함수 팩토리얼 2
		no = recFactorial(5);
		System.out.println(no);
		
		
		
	} // main 끝지점
	
	
	public static long recFactorial(int num) {
		if(num == 1) {
			return 1;
		}
		
		return num * recFactorial(num-1);
		// 5를 넣었다면 
		// 5 * recFactorial(num-1값인 4) 
		// 5 * 4 * recFactorial(3)
		// 5 * 4 * 3 * recFactorial(2)
		// 5 * 4 * 3 * 2 recFactorial(1)
		// 5 * 4 * 3 * 2 * 1		
	}
	
	
	
	public static long Factorial(int num) {
		// 팩토리얼을 어디서 했는지 기억안나면 단축키 [ctrl + h]

		long asd = 1;
		for (long i = 1; i <= 5; i++) {
			asd *= i;
		}
		return asd;
	}
	
	
	
	public static void recursionPrint(int num) {
		// 재귀함수도 반복을 중단하는 조건을 잘 설정해주어야 한다.
		if(num <=0) {
			return;
		}
		
		System.out.println(num);
		recursionPrint(num-1);
	}
	
	
	//리턴타입이 없는 void 메소드도 리턴은 사용가능
	
	public static void playPokemon() {
		Scanner scan = new Scanner(System.in);
		int enemyHp = 100;
		outer: while (true ) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 || 2. 도망");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				// TODO 공격
				while(true) {
					System.out.println("공격방법 선택");
					System.out.println("1. 백만볼트 || 2. 전광석화 || 3. 취소");
					System.out.print(">>> ");
					
					int select = Integer.parseInt(scan.nextLine());
					
					if(select == 1) {
						System.out.println("피~카~츄");
						enemyHp -= 20;
					}else if(select ==2) {
						System.out.println("삐까삐까");
						enemyHp -= 10;
					}else if(select ==3 ) {
						System.out.println("공격 취소");
						// 내부 while문 종료
						// 외부 while문 계속 실행
						break;
					}
					System.out.println("파이리의 현재체력은: " + enemyHp);
					
					if(enemyHp <=0) {
						System.out.println("파이리를 잡았다");
//						System.exit(0);  프로그램 종료
						// 내부에서 외부 while문 중지
						
						return; //break outer;
						// void에서의 리턴 메소드를 즉시 종료하는 효과
					}
				}
			}else if(command == 2) {
				//  도망
				System.out.println("도망쳤습니다.");
				break;
			}
		}
	}
	
//	public static int eachAdd(int num) {
//		int example = 4784593;
//
//		// 숫자를 문자열로 변환
//		String strEx = num + ""; 
//		int result = 0;
//		// 문자열의 길이만큼 반복되는 for문
//		for (int i = 0; i < strEx.length(); i++) {
//			result = Integer.parseInt(Integer.parseInt(str););
//		
//		}
//		System.out.println("각 자리수를 더한 값:" + result);	
//	}
	
	
	public static void makeCard(String name, int num1, int num2, int num3) {
		System.out.println("이름 :" + name);
		System.out.println("국어:" + num1);
		System.out.println("영어:" + num2);
		System.out.println("수학:" + num3);
		// avg 값 반올림 (몇번째 자리를 기준)
		double avg = (num1 + num2 + num3) / 3.0;
		// 반올림
		// 89.66 -> 90
		// 89.67
		double score = weRound(avg, 2);
		System.out.println("평균:" + score);

		String grade = "C";
		if (avg >= 90) {
			System.out.println("A");
		} else if (avg >= 80) {
			System.out.println("B");
		}
		System.out.println("등급:" + grade);

	}

	/**
	 * 입력한 소수를 반올림하여 소수 n번째 자리로 리턴해주는 함수입니다.
	 * 
	 * @param num 반올림하고자 하는 소수를 의미한다.
	 * @param n   소수 n번째 자리까지 리턴
	 * @return 반올림된 소수를 리턴
	 */
	// 반올림 메소드
	public static double weRound(double num, int n) {
		// Math.round() 은 소수 첫째 자리에서 반올림한 정수를 리턴
		// 3.141592 에 Math.round(3.141592) 를 하면
		// 3이된다.

		// 그런데 3.1로 만들고 싶다면 3.141592에 10을 곱하면 31.41592
		// 해당값을 Math.round(31.41592)을 하면 31이된다
		// 31을 10으로 나누면 3.1이된다.

		// 314를 만들고 싶다면 3.141592에 100을 곱하면 314.1592가 되고
		// Math.round(314.1592)를 넣으면 314가 되고 거기에 100을 나누면
		// 3.14가 된다.

		// 10의 n제곱 구하기
		int ten = 1;
		for (int i = 0; i < n; i++) { // n회 반복하는 for문
			ten *= 10;

		}

		num = num * ten; // num *= ten; 이렇게 써도됨
		long temp = Math.round(num);

		double result = (double) temp / ten;
		return result;
	}

	// 메소드의 선언
	// [접근제어자 static] 리턴타입 메소드명(파라밑){ }
	// void는 리턴타입이 없는 메소드를 의미
	public static void printSum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++) {
			sum += i;
		}
		System.out.println(from + "부터" + to + "까지 더한 결과" + sum + "입니다.");
	}

	public static int returnSum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++) {
			sum += i;
		}
		System.out.println(from + "부터" + to + "까지 더한 결과" + sum + "입니다.");
		// 변수 sum의 값을 리턴
		// 메소드 내에 return이 실행되면
		// 그 즉시 메소드를 종료
		return sum;

	}

	public static void print(String msg) {
		System.out.println(msg);
	}

	// 하나의 클래스 내에 있는 메소드는 기본적으로 메소드명이 중복되면 안된다.
	// 메소드 오버로딩 하나의 클래스 내에 파라미터의 타입, 수를 다르게 지정하는 경우 중복된 메소드명을 사용할 수 있음
	public static void print(int num) {
		System.out.println(num);
	}

	public static int absolute(int num) {
		// 들어온 num 값이 양수면 그대로 리턴 음수면 양수로 바꿔준후 리턴( * -1)
		if (num < 0) {
			num *= -1;
		}
		return num;
		/*		int number = Math.abs(-10);
		System.out.println(number);

		number = absolute(-10);
		System.out.println(number);*/
	}
}
