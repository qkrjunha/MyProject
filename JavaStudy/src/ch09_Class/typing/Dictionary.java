package ch09_Class.typing;

import java.util.ArrayList;

public class Dictionary {
	
	public static final int OPTION_STUDENT_NAME = 0; // 상수선언 final은 모든문자 대문자_쓴다
	public static final int OPTION_CODING = 1;
	public static final int OPTION_RANDOM = 2;
	
	
	// 파라미터로 option에 0을 넣으면 학생 목록, 1이면 코딩용어, 2면 랜덤알파벳
	/**
	 * 단어목록을 만들어서 리턴해주는 메소드
	 * @param option 0을 넣으면 학생 목록, 1이면 코딩용어, 2면 랜덤알파벳
	 * @return 옵션에 대한 단어목록 리턴
	 */
	public static ArrayList<String> makeWordList(int option) {
		ArrayList<String> wordList = new ArrayList<>();

		if (option == OPTION_STUDENT_NAME) {
			wordList.add("장유정");
			wordList.add("배준호");
			wordList.add("고동욱");
			wordList.add("박혜라");
			wordList.add("정현진");
			wordList.add("홍민경");
			wordList.add("박진영");
			wordList.add("김대일");
			wordList.add("박창연");
			wordList.add("최성복");
			wordList.add("이자영");
			wordList.add("백민기");
			wordList.add("유동윤");
			wordList.add("강지혜");
			wordList.add("김태윤");
			wordList.add("박준하");
			wordList.add("주예슬");
			wordList.add("윤종현");
			wordList.add("류서영");
			wordList.add("신경호");
			wordList.add("김청아");
			wordList.add("김현곤");
		} else if (option == OPTION_CODING) {
			wordList.add("Class");
			wordList.add("static");
			wordList.add("while");
			wordList.add("method");
			wordList.add("public");
			wordList.add("Constructor");
			wordList.add("forEach");
			wordList.add("Scanner");
		} else if (option == OPTION_RANDOM) {
			// 랜덤 알파벳으로 이루어진 단어 출력
			// ex) ahasdwqe , asdzchkp
			String[] alphabet = "qwertyuiopasdfghjklzxcvbnm".split(""); // 뒤에 ""은 기준이 없다(다쪼개짐)

			// 6자리 랜덤 알파벳으로 이루어진 문자열 생성 후
			// wordList에 담기

			// 배열의 랜덤 인덱스
			// 0~ .length - 1
			String word = "";

			for (int i = 0; i < 6; i++) {
				int randIdx = (int) (Math.random() * alphabet.length);
				word += alphabet[randIdx];
//			for(int i = 0; i < alphabet.length; i++) {  // 알파벳 하나씩 짤려는지 확인하는 for문
//				System.out.println(alphabet[i]);
			}
			wordList.add(word);

			// 랜덤 문자열을 10개 담겠다.
			for (int j = 0; j < 10; j++) {
				int randIdx = (int) (Math.random() * alphabet.length);
				word += alphabet[randIdx];

			}
			wordList.add(word);

		}

		return wordList;
	}
}
