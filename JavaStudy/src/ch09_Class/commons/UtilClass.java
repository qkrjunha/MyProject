package ch09_Class.commons;

// 유용한 메소드들을 가지고 있는 클래스
public class UtilClass {

		// ch06_method/MethodMain에서 했던 weRound
	public static double weRound(double num, int n) {
	
		int ten = 1;
		for (int i = 0; i < n; i++) { // n회 반복하는 for문
			ten *= 10;

		}

		num = num * ten; // num *= ten; 이렇게 써도됨
		long temp = Math.round(num);

		double result = (double) temp / ten;
		return result;
	}

		
}
