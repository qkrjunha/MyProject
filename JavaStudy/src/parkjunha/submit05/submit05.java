package parkjunha.submit05;

import java.util.Scanner;

public class submit05 {

	public static void main(String[] args) {
		
	
		makeTree(5);
		makeTree(7);
		
		System.out.println("\n==========2번==========\n");
		
			String reverse2 = "";
			reverse(reverse2);
		
			// (자바에서 이진수, 16진수 등등은 문자열)
			String binaryString = Integer.toBinaryString(17);
			System.out.println(binaryString);
			
			binaryString = makeBinary(17);
			System.out.println(binaryString);
			
			
			
		}
	
	public static String makeBinary(int n) {
		// n에 17일 들어왔다. 
		// 17을 2로 나눠서 나머지는 1 / 몫은 8
		// 8을 2로 나눠서 나머지는 0 / 몫은 4
		// 4를 2로 나눠서 나머진는 0 / 몫은 2
		// 2를 2로 나눠서 나머지는 0 / 몫은 1 
		// 1를 2로 나눠서 나머지는 1 / 몫은 0 (0이되면 스탑되게 )
		
		//반복횟수와 기준이 애매하면 while(true)
		String result = "";
		while(true) {
			result += n % 2;
			n = n / 2;
			
			if(n == 0) {
				break;
//		while(n >0) {
//			result  += n % 2;
//			n = n / 2;
			}
		}
//			String rst = reverse(result);
//			return rst;           <-- 이렇게 써도
			return reverse(result);
	}
	
	public static int makeTree(int n) {

		for(int i = 0; i < n; i++) {
			String space = "";
			for(int k = 0; k < n-i; k++) {
				space += " ";
			}
			
			String stars = "";
			for(int k = 0; k < (i*2)+1; k++) {
				stars += "*";
			}
			
			System.out.println(space + stars);
		}
		
		return n;
	}

	
	
	public static String reverse(String reverse2) {
	Scanner scan = new Scanner(System.in);

	String example = "가나";
	String result = "";
	for(int i = 0; i < example.length(); i++) {
	String str = example.substring(i, i+1);	
	result = str + result;
	}
	System.out.println("뒤집은 문자열: " + result);
	
	return reverse2;
	}
	
	
	
	
	
}