package ch05_control;

public class LoopFor {

	public static void main(String[] args) throws InterruptedException {
		// for 문 콘솔창에 1부터 10까지 출력

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// for문 내에서 선언된 변수 i는 for문 종료 후 메모리에서 삭제된다.(변수의 scope)
		// System.out.println(i);

		// for문 내 변수 i는 for문의 반복횟수를 정하기 위함이 주 목적이므로 꼭 변수 i를 for문 내에서 사용하지않아도된다.

		int one = 1;
		for (int i = 0; i < 10; i++) { // 10번 반복실행
			System.out.println(one++);
		}

		// i는 for문 내에서 사용되는 변수명일뿐이므로 i가 아닌 다른 단어를 사용해도된다.
		for (int x = 0; x < 5; x++) { // 5번 반복실행
			System.out.println(x);
		}

		System.out.println("\n====================================\n");

		// 1부터 20까지 더하기
		// 변수의 사용범위(scope)
		int sum = 0;
		for (int i = 1; i < 21; i++) {
			sum += i;
			System.out.println(sum);
		}

		// 21부터 45까지 더하기
		sum = 0;
		for (int i = 21; i <= 45; i++) {
			sum += i;
			System.out.println(sum);
		}

		// 1부터 40까지 중에 짝수끼리만 더한 값
		sum = 0;
		for (int i = 1; i <= 40; i++) {
			// 현재 i가 짝인지 확인
			if (i % 2 == 0) {
				// 짝수이면 더한다
				sum += i;
			}
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 0; i <= 40; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		// 0부터 2까지 0.2마다 출력
		for (double i = 0; i <= 2; i += 0.2) {
			System.out.println(i);
		}

		for (int i = 0; i <= 20; i += 2) {
			System.out.println(i / 10.0);
		}

		// 증감식에 i++로 두고 위의 코드와 결과가 같도록 만들기
		System.out.println("\n====================================\n");

		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i / 10.0);
			}
		}
		// 규칙을 파악
		// syso가 11번 실행 -> i = 0; ㅑ < 11
		// i = 0 -> 0
		// i = 1 -> 0.2
		// i = 2 -> 0.4
		// i = 10 -> 2.0
		// 규칙은 i에 2를 곱하고 10으로 나눈 값
		for (int i = 0; i < 11; i++) {
			System.out.println((i * 2) / 10.0);
		}

		System.out.println("\n====================================\n");

		// 구구단 2단 출력
		for (int i = 2; i < 11; i++) {
			System.out.println("2 x " + i + " = " + (i * 2));
		}

		System.out.println("\n====================================\n");

		// 아래의 5층 트리를 for문을 이용하여 구현
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");

		String a = "*";
		for (int i = 0; i < 5; i++) {
			System.out.println(a);
			a += "*";
		}

		for (String i = "*"; i.length() <= 5; i += "*") {
			System.out.println(i);
		}

		System.out.println("\n================ 국수나무 ==================\n");
		// 나머지 연산자(%)의 사용 예시 for문 내에서 순환하는 숫자에 대해 사용
		// 국수공장에서 면을 20cm 뽑고 있는데 5cm마다 잘라주기
		for (int i = 0; i < 20; i++) {
			System.out.println("||||||||");

			// i가 4, 9, 14일때 면을 잘라준다. if(i == 4 || i == 9 || i == 4){ 로도 사용가능
//			if (i == 4) {
//				System.out.println("--------");
//			} else if (i == 9) {
//				System.out.println("--------");
//			} else if (i == 14) {
//				System.out.println("--------");
			// i가 4, 9, 14, 19... 일때 면을 잘라준다. 규칙 찾기 i를 5로 나눈 나머지가 4인 애들
			if (i % 5 == 4) {
				System.out.println("--------");
			}
		}

		System.out.println("\n================ 신라면 ==================\n");
		// 라면 공장에서 면을 30cm 뽑고 있는데 6cm마다 잘라주기

		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0) {
				System.out.println("/////////");
			} else {
				System.out.println("\\\\\\\\\\\\\\\\");
			}

			// i가 5일때, 11일때, 17일때, ... 자른다.
			// i를 6으로 나눈 나머지가 5일때 자른다.
			if (i % 6 == 5) {
				System.out.println("--------");
			}
			// 컴퓨터가 0.4초 쉰다.(400ms)
			// Thread.sleep(400);

		}

		System.out.println("\n==================================\n");
		// 10부터 1까지 출력
		// 거꾸로 for문
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}

		System.out.println("\n==================================\n");
		// for문으로 String 가지고 놀기
		// submit01 에서 했던 숫자의 각 자리수를 더한 결과를 출력
		// for문을 이용하여 해결

		// Q.03 각자리수 더하기
		int example = 4784593;

		// 숫자를 문자열로 변환
		String strEx = example + ""; // "4784593"

		int result = 0;
		// 문자열의 길이만큼 반복되는 for문
		for (int i = 0; i < strEx.length(); i++) {
			String str = strEx.substring(i, i + 1);
			int no = Integer.parseInt(str);
			result += no;
		}
		System.out.println("각 자리수를 더한 값:" + result);

		// 문자열을 각 자리수마다 자른다.
		String str1 = strEx.substring(0, 1); // i = 0
		String str2 = strEx.substring(1, 2); // i = 1
		String str3 = strEx.substring(2, 3); // i = 2

		int int1 = Integer.parseInt(str1);
		int int2 = Integer.parseInt(str2);
		int int3 = Integer.parseInt(str3);

		System.out.println("\n==================================\n");

		int loop = 0;
		for (int i = 1; i <= 15; i++) {
			loop += i;
			System.out.println(loop);
		}

		// 슈의 갯수는?
		String syu = "슈ㅇㅁㄴ슈ㅇㄴ슉ㅁㅇ슈ㄴㅁㅇ슈";
		// syu 를 한글자씩 자르고 -> 자른 값이 : "슈"인지 체크하고 -> "슈"가 맞다면 카운팅을 한다.

		int count = 0;
		for (int i = 0; i < syu.length(); i++) {
			String str = syu.substring(i, i + 1);

			if (str.equals("슈")) {
				count++;
			}
		}
		System.out.println("슈의 갯수:" + count);

		System.out.println("\n==================================\n");

		// break 문
		// 반복문 내에서 break 문이 실행되면
		// 해당 반복문을 즉시 종료

		// 1부터 n까지 더한다고 했을때,
		// 더한 값이 100 이상이 되는 지점의 n을 구할때
		sum = 0;
		for (int i = 1; i < 9999; i++) {
			sum += i;

			if (sum >= 100) {
				System.out.println(i);
				break;
			}

		}


		System.out.println("\n==================================\n");

		// 이중 for문
		// 구구단 출력 2 X 2 = 4
		// 2 X 3 = 6
		// 2 X 9 = 18
		// 3 X 2 = 6
		// 3 X 3 = 9 ..... 9 X 9 = 81

		for (int left = 2; left <= 9; left++) {
			for (int right = 2; right <= 9; right++) {
				System.out.println(left + "X" + right + "=" + (left * right));

			}
		}

		/*
		 * 디버깅 모드 코드라인에 좌측 연두색 부분 더블클릭하여 break 포인트(더블 클릭 초록점)를 만든 후 디버깅 실행 breakpoint
		 * 생성/해제 단축키 [Ctrl + Shift + B] [디버깅 실행 단축키 = F11]
		 * 
		 * 디버깅의 목적 코드를 한줄한줄 실행해보며, 변수에 어떤 값이 담기고 있는지 확인해볼 수 있다.
		 * 
		 * 디버깅 실행 (상단에 벌레 모양 아이콘 클릭해도됨) 처음에 디버깅 모드에 적합한 화면(Perspective) 전환 여부 묻는 창이 뜬다.
		 * (전환 하기)
		 * 
		 * 코드들이 쭉 실행되다가 breakpoint가 있는 지점에 멈춰서 실행 대기를 한다.
		 * 
		 * 이후 상단의 RUN -> step over[단축키 = F6] 을 눌러 한줄한줄 코드를 실행해본다.
		 * 
		 * 디버깅 모드를 종료하시려면 Terminate[단축키 = Ctrl + F2] (콘솔창 쪽에 뜨는 빨간색 중지 버튼) 이후 원래
		 * 화면(Perspective)으로 돌아오려면 우측 상단에서 Java Perspective를 클릭
		 * 
		 */

		System.out.println("\n==================================\n");

		// 트리
		// *
		// **
		// ***
		// ****
		// *****

		System.out.println("    " + "*");
		System.out.println("   " + "**");
		System.out.println("  " + "***");
		System.out.println(" " + "****");
		System.out.println("" + "*****");

		// i = 0,1,2,3,4
		// 공백은 4,3,2,1,0 개
		// *은 1,2,3,4,5

		for (int i = 0; i < 5; i++) {
			String space = "";
			for (int k = 0; k < 4 - i; k++) {
				// 외부 for문의 변수 i를 이용하여
				// 내부 for문의 반복횟수를 조정할 수 있다.
				space += " ";
			}
			String star = "";
			for (int k = 0; k < i + 1; k++) {
				star += "*";
			}
			System.out.println(space + star);
		}

		System.out.println("\n==================================\n");

		// *
		// ***
		// *****
		// *******
		// *********

		// for문에 5번 실행
		// i = 	0,1,2,3,4 일떄
		// 공백은 	4,3,2,1,0
		// *은 		1,3,5,7,9
		System.out.println("\n=================================\n");

		for (int i = 0; i < 5; i++) {
			String space = "";
			for (int k = 0; k < 4 - i; k++) {
				// 외부 for문의 변수 i를 이용하여
				// 내부 for문의 반복횟수를 조정할 수 있다.
				space += " ";
			}
			String star = "";
			for (int k = 0; k < (i * 2) + 1; k++) {
				star += "*";
			}
			System.out.println(space + star);
		}

		// *********
		// *******
		// *****
		// ***
		// *

		// for문에 5번 실행
		// i가 0,1,2,3,4 일때
		// 공백은 0,1,2,3,4
		// *은 9,7,5,3,1

		for (int i = 0; i < 5; i++) {
			String space = "";
			for (int k = 0; k < i; k++) {
				// 외부 for문의 변수 i를 이용하여
				// 내부 for문의 반복횟수를 조정할 수 있다.
				space += " ";
			}
			String star = "";
			for (int k = 0; k < 9 - (i * 2); k++) {
				star += "*";
			}
			System.out.println(space + star);
		}

		System.out.println("\n==================================\n");

		int as = 1;
		for (int i = 1; i <= 15; i++) {
			as *= i;
		}
		System.out.println(as);
		}
	
	
//	String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
//
//	int c = 0;
//	for (int i = 0; i < findWally.length(); i++) {
//		String str = findWally.substring(i, i + 2);
//
//		if (str.equals("윌리")) {
//			c++;
//		}
//	}
//	System.out.println("윌리의 갯수:" + c);
	}


