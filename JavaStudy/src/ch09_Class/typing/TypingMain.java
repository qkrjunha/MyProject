package ch09_Class.typing;

import java.util.ArrayList;
import java.util.Scanner;

public class TypingMain {

	public static void main(String[] args) {
		// 타자 연습 게임
		Scanner scan = new Scanner(System.in);

		// 단어 목록
		// static 메소드는 해당 클래스를 굳이 객체로 만들지 않더라도 사용이 가능하다.
		ArrayList<String> wordList = Dictionary.makeWordList(Dictionary.OPTION_RANDOM);
		
//		Dictionary dict = new Dictionary();
//		ArrayList<String> wordList = dict.makeWordList();
//		ArrayList<String> wordList = new ArrayList<>();

		
		
		// 현재 시간을 저장
		// 1970년 1월 1일 기준으로
		// 현재까지(밑에 before가 실행됐을때까지) 경과된 시간을 밀리초 단위로 리턴 (1초 = 1000밀리초)
		long before = System.currentTimeMillis();
		System.out.println(before);

		while (true) {
			// wordList에 담긴 단어가 입력 순서대로 출력
//			System.out.println(wordList.get(0));
			
			// wordList에 담긴 단어가 랜덤하게 출력 
			// = Math.random() 실행 결과가 wordList의 인덱스 중 하나
			// = wordList의 인덱스 0 ~ wordList.size()-1
			int randIdx = (int)(Math.random() * wordList.size());
			System.out.println(wordList.get(randIdx));
			
			// 출력된 단어를 입력
			System.out.println(">>> ");
			String input = scan.nextLine();

			// 입력한 단어가 출력된 단어와 일치하는지 체크
//			if (wordList.get(0).equals(input)) {
				if (wordList.get(randIdx).equals(input)) {

				// 일치한다면 wordList에서 해당 단어를 삭제
//				wordList.remove(0); 
				wordList.remove(randIdx);
			}

			// 일치하지 않으면 해당 단어가 삭제되지 않고 또 입력하게 됨

			// 위 과정을 반복 (wordList.size()가 0이 될때까지)
			if (wordList.size() == 0) {
				break;
			}
		}
		
		long after = System.currentTimeMillis();
		// after에서 before를 빼면, 타자를 친 시간이 구해진다.
		long diff = after - before; //diff는 밀리초단위
		
		// 초 단위로 변환 
		// ex)31.87초가 걸렸다라고 과정하면 318700밀리초가 나온다.
		double result = diff / 1000.0; // 31.0 초
		System.out.println(result + "초 걸리셨습니다.");
		
	}

}
