package ch07_array;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ArrayMain {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// 배열(Array)

		ArrayList<Integer> intList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 16) + 15;
			intList.add(rand);
		}
		System.out.println(intList);
		
		
		
		Collections.sort(intList);
		System.out.println(intList);
		
		
		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList);
		
		
     

		

		String samjang = "삼장";
		String woogong = "오공";
		String saojeong = "사오정";
		String palgye = "저팔계";

		// 문자열을 담을 수 있는 배열 String[]
		// 배열의 선언
		// 숫자 4는 첨자를 의마하고, 배열의 크기를 정한다.
		// 배여르이 크기는 바뀌지 않는다.
		String[] seoyugi = new String[4];

//		System.out.println(palgye.length()); 
		System.out.println(seoyugi.length); // .length로 길이를 리턴 (메소드는 아님)

		// 배열 내 요소(element) 확인
		// 인데스 사용 (= 인덱싱)
		System.out.println(seoyugi[0]);

		// 처음 생성된 배열 내에는 기본값(default)이 들어있다.
		// 참조타입 : null;
		// 기본타입 : 숫자면 0, boolean면 false
		int[] numbers = new int[3]; // 0,0,0 이 들어가있음
		System.out.println(numbers[0]);
		boolean[] bools = new boolean[5];
		System.out.println(bools[0]);

		System.out.println("\n=====================================\n");

		// 배열에 값 넣기
		seoyugi[0] = samjang;
		System.out.println(seoyugi[0]); // "삼장" , null, null, null
		seoyugi[1] = woogong; // "삼장", "오공", null, null
		seoyugi[2] = saojeong; // "삼장", "오공", "사오정", null
		seoyugi[3] = palgye; // "삼장", "오공", "사오정", "팔계"
		System.out.println(seoyugi);

		// for문을 이용해서 0부터 array.length 미만까지
		// 인덱스를 순회하면 배열의 모든 요소에 접근이 가능하다.
		for (int i = 0; i < seoyugi.length; i++) {
			System.out.println(seoyugi[i]);

		}
		// 배열 요소를 조회하는 메소드 만들기
		printArray(seoyugi); // 삼장, 오공, 사오정, 저팔계

		System.out.println("\n=====================================\n");

		// 배열의 단점
		// 크기가 고정됨
		// 늘어나지도, 줄어들지도 않으며
		// 값을 추가하거나 제거하지도 못한다.

		// 코드 편집기에서 빨간줄이 쫙 그이는 에러는 컴파일 에러로, 실행을 안해봐도 이클립스 캐치
		// 실행했을 때 발생하는 에러는 런타임 에러
		//
		// seoyugi[4] = "크리링"; 크기를 넘어서 에러뜸

		// 배열의 장점
		// for문을 이용하여 배열에 담긴 모든 요소들을 한번에 처리할 수 있다.(데이터 처리)
		for (int i = 0; i < seoyugi.length; i++) {
			seoyugi[i] = "서유기 " + seoyugi[i];
		}
		printArray(seoyugi);

		// 배열 내 특정 요소에 접근하여 처리를 할 수 있다.
		// 서유기 오공 -> 드래곤볼 오공
		for (int i = 0; i < seoyugi.length; i++) {
			// 오공이 포함되어 있으면 true
			if (seoyugi[i].contains("오공")) {
				seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");

			}
		}
		printArray(seoyugi);

		System.out.println("\n=====================================\n");

		int[] intArray = new int[6];

		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		intArray[5] = 6;

		printArray(intArray);
		for (int i = 0; i < intArray.length; i++) {
			// 로또 번호
			// 1 ~ 45 사이의 랜덤 숫자
			// Math.random() -> 0 ~1 사이의 랜덤 소수
			// ex) 0 , 0.1 , 0.9, 이런식으로 랜덤으로 뽑힌다.
			// Math.random() * 5 -> 0~ 5미만의 랜덤 소수
			// 0가 뽑히면 -> 0 0.1이 뽑히면 -> 0.5 , 0.9 가 뽑히면 -> 4.5가 나온다.
			// (int)(Math.random() * 5) 을 int로 바꿔라
			// 뽑힌 0,0.1,0.5에 *5를 하면 0 0 4 이 나오고 0~4사이에 랜덤 정수출력
			// 위에값에 (int)(Math.random() * 45) 를 한다 0~ 44사이에 랜덤 정수
			// (int)(Math.random() *45) + 1 -> 1 ~ 45 사이의 랜덤 정수

			intArray[i] = (int) (Math.random() * 45) + 1;
		}

		printArray(intArray);

		System.out.println("\n=====================================\n");

		// 값을 넣으며 배열 선언
		String[] students = { "가가가", "나나나", "다다다", "라라라", "마마마" };
		printArray(students);

		System.out.println("\n=====================================\n");

		// 문자열 나누기
		String subjects = "자바, SQL, 자바스크립트, JSP";

		// .split(문자열)
		// 괄호안 문자열을 기준으로 해당 문자열을 나눠서 문자열 배열로 리턴한다.
		String[] subjectArray = subjects.split(", ");

		System.out.println(subjectArray.length); // 콤마 기준으로 짤라서 4가 나온다
		System.out.println(subjectArray[0]); // 짤린값 기준으로 array[0]에는 자바 [1]에는 SQL 이런식으로 출력

		// 데이터가 잘 정돈되어 있지 않다면
		// ,로 일단 나누고 양쪽 공백을 제거해주면 된다.(trim).
		for (int i = 0; i < subjectArray.length; i++) {
			subjectArray[i] = subjectArray[i].trim();

		}
		printArray(subjectArray);

		System.out.println("\n=====================================\n");

		// 배열의 복사
		String[] sinSeoyugi = seoyugi;
		printArray(sinSeoyugi);

		sinSeoyugi[0] = "강호동";
		sinSeoyugi[1] = "이수근";

		printArray(sinSeoyugi);
		printArray(seoyugi); // sinSeoyugi[0] = "강호동"; 때문에 기존 배열에도 영향을 미친다.

		System.out.println(seoyugi);
		System.out.println(sinSeoyugi);
		// 위에코드System.out.println(seoyugi); System.out.println(sinSeoyugi); 에러 코드 =
		// [Ljava.lang.String;@2a139a55
		// @ 앞은 객체의 타입
		// @ 뒤에 붙은건 hashCode를 16진수로 나타낸 것

		System.out.println(seoyugi.hashCode()); // 두개 코드 에러 2a139a55이라는 숫자를 16진수로 변환( 705927765로 나옴)
		System.out.println(sinSeoyugi.hashCode());

		System.out.println(Integer.toHexString(seoyugi.hashCode()));
		// 해쉬 코드(hashcode)
		// 객체의 메모리 주소값을 이용해서 해쉬를 적용한 코드
		// 해쉬(hash)
		// 해쉬함수(암호화 알고리즘)를 이용해서 데이터를 암호화하는 기법(대표 SHA)

		String password = "1q2w3e4r";
		String encryptPw = encrypt(password);
		System.out.println(encryptPw);

		String loginPw = "1q2w3e4r";
		encryptPw = encrypt(loginPw);
		System.out.println(encryptPw);

		System.out.println("\n=====================================\n");

		// 올바른 배열 복사
		String[] newSeoyugi = seoyugi.clone();

		printArray(seoyugi);
		printArray(newSeoyugi);

		newSeoyugi[2] = "원지원";
		printArray(newSeoyugi);
		printArray(seoyugi);

		// .clone을 까먹었다.
		String[] copy = new String[seoyugi.length];
		// copy의 각 인덱스에, seoyugi의 각 인덱스 값을 넣어준다.
		for (int i = 0; i < seoyugi.length; i++) {
			copy[i] = seoyugi[i];
		}
		printArray(copy);

		System.out.println("\n=====================================\n");

		// 숫자 배열
		int[] numberArray = { 23, 456, 213, 32, 464, 1, 2 };

		System.out.println(numberArray[0]);
		System.out.println(numberArray[1]);

		// 인덱스 0번 값과 인덱스 1번 값의 위치를 바꿔봐라.
		int temp = numberArray[5];
		numberArray[5] = numberArray[2];
		numberArray[2] = temp;
		printArray(numberArray);

		printArray(numberArray);
		swap(0, 1, numberArray);
		printArray(numberArray);

		// 가끔 면접에서 묻는 문제
		// call by Value 와 Call by Reference 구분
		// 기본타입 변수에 대해서는 Call by Value로 동작
		// 참조타입 변수에 대해서는 Call by Reference로 동작

		int a = 10;
		int b = a;
		System.out.println(b);

		a = 20;
		System.out.println(b);

		swap(a, b);

		System.out.println(a);
		System.out.println(b);

		System.out.println("\n=====================================\n");
		// 다차원 배열
		// 1D -> x축
		// 2D -> x축 ,y축
		// 3D -> x축, y축, z축
		// 4D -> x축, y축, z축, t
		int[] oneDir = { 1, 2, 3 };
		// 2D는 1차원 배열 내에 1차원 배열들이 존재하는 경우
		// 행렬로 나타낸다면
		// 1 2 3
		// 4 5 6
		// 7 8 9
		int[][] twoDir = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// twoDir으로부터 twoDir[0] 1,2,3 출력 twoDir[1] 4,5,6 출력 twoDir[2] 7,8,9 출력
		int[] tempArray = twoDir[2];
		printArray(tempArray);

		// twoDir으로부터 6을 꺼내고 싶다
		int six = twoDir[1][2]; // twoDir[1](4,5,6)에서 twoDir[2]해서 6을 출력
		System.out.println(six);

		// 3차원배열은 일차원 배열 내 2차원 배열들이 존재
		int[][][] threeDir = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { 11, 12, 13 }, { 14, 15, 16 }, { 17, 18, 19 } },
				{ { 21, 22, 23 }, { 24, 25, 26 }, { 27, 28, 29 } } };

		// 0층의 행렬
		// 1 2 3
		// 4 5 6
		// 7 8 9
		// 1층의 행렬
		// 11 12 13
		// 14 15 16
		// 17 18 19
		// 2층의 행렬
		// 21 22 23
		// 24 25 26
		// 27 28 29
		System.out.println(threeDir[2][0][2]);
	}

	public static void swap(int p_a, int p_b) {
		int temp = p_a;
		p_a = p_b;
		p_b = temp;
	}

	public static void swap(int idxA, int idxB, int[] numberArray) {

		int temp = numberArray[idxA];
		numberArray[idxA] = numberArray[idxB];
		numberArray[idxB] = temp;
		printArray(numberArray);

	}

	// 메소드 오버로딩
	public static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			// i가 마지막일때에는 뒤에 콤마(,)를 붙이지 않고, 개행문자도 넣는다.
			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);
				break;
			} // else { 도 가
			System.out.print(intArray[i] + ", ");
		}
	}

	public static void printArray(String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			// i가 마지막일때에는 뒤에 콤마(,)를 붙이지 않고, 개행문자도 넣는다.
			if (i == strArray.length - 1) {
				System.out.println(strArray[i]);
				break;
			} // else { 도 가
			System.out.print(strArray[i] + ", ");
		}
	}

	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

}
