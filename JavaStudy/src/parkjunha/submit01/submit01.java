package parkjunha.submit01;

public class submit01 {

	public static void main(String[] args) {
		
		String  strName = "홍길동";
		int intAge = 26;
		double doubleHeight = 177.9;
		String strPhone =	 "010-7398-7332";
		String strEmail = "gildong@gmail.com";
		System.out.println( "이름 : "  + strName);
		System.out.println( "나이 :"  + intAge);	
		System.out.println( "키 :"  + doubleHeight);
		System.out.println( "연락처 :" + strPhone);
		System.out.println( "이메일 :" + strEmail);


		
		 String enigma = "너오구늘리뭐너먹구지리"; 
		 System.out.println(enigma);
		 enigma = enigma.replace("너오구늘리뭐너먹구지리", "오구늘리뭐먹구지리");
		 System.out.println(enigma);
		 enigma = enigma.replace("오구늘리뭐먹구지리", "오늘리뭐먹지리");
		 System.out.println(enigma);
		 enigma = enigma.replace("오늘리뭐먹지리", "오늘뭐먹지");
		 System.out.println(enigma);
		 System.out.println("해독완료!! -> : " +enigma);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 int example = 278;
		 String strNum = example + " ";
		 String S = (strNum.substring(0,1)); 
		 String T = (strNum.substring(1,2));
		 String R = (strNum.substring(2,3));
		 int N = Integer.parseInt(S);
		 int U = Integer.parseInt(T);
		 int M = Integer.parseInt(R);
		 int result = N + U + M;
		 System.out.println(result);
		 /*한줄로 요약
		  * int result = Integer.parseInt(strNum.substring(0,1)) + Integer.parseInt(strNum.substring(1,2)) + Integer.parseInt(strNum.substring(2,3));
		  * System.out.println(result);
		  * 
		  * */
		 
		
	}
}


