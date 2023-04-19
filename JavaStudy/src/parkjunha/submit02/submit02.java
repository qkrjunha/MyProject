package parkjunha.submit02;

import java.util.Scanner;

public class submit02 {

	public static void main(String[] args) {

		
//		  Scanner scan = new Scanner(System.in);
//		  System.out.println("이름을 입력해주세요.");
//		  System.out.print(">>> "); 
//		  String name = scan.nextLine(); 
//		  
//		  System.out.println("국어점수를 입력해주세요."); 
//		  System.out.print(">>> "); 
//		  String guk =scan.nextLine(); 
//		  
//		  System.out.println("영어 점수를 입력해주세요."); 
//		  System.out.print(">>> "); 
//		  String young = scan.nextLine(); 
//		  
//		   
//		  System.out.println("수학점수를 입력해주세요."); 
//		  System.out.print(">>> "); 
//		  String su = scan.nextLine();
//		  		 
//		 int int1 = Integer.parseInt(guk);
//		 int int2 = Integer.parseInt(young);
//		 int int3 = Integer.parseInt(su);
//		
//		 
//		 
//		 int hap = int1 + int2 + int3;
//		 
//		 System.out.println( "이름 :" + name); 
//		 System.out.println( "국어 :" + guk);
//		 System.out.println( "영어 :" + young); 
//		 System.out.println( "수학 :" + su);
//		 System.out.println( "평균 :" + hap / 3);
		 
		

		  Scanner scan = new Scanner(System.in);
		  System.out.println(">>>");
		  scan.nextLine();
		  String name = scan.nextLine();
		   
		  System.out.println("국어 점수를 입력");
		  System.out.println(">>>");
		  int kor = Integer.parseInt(scan.nextLine());
		  
		  System.out.println("영어 점수를 입력");
		  System.out.println(">>>");
		  int eng = Integer.parseInt(scan.nextLine());
		  
		  System.out.println("수학 점수를 입력");
		  System.out.println(">>>");
		  int math = Integer.parseInt(scan.nextLine());
		  
		  System.out.println("이름:" + name);
		  System.out.println("국어:" + kor);
		  System.out.println("영어:" + eng);
		  System.out.println("수학:" + math);
		  
		  double avg = (kor + eng + math) / 3;
		  System.out.printf("평균: %.2f", avg );
		  System.out.println();
		  
		  String grade = (avg >= 90) ? ("A")  : ( (avg >=80) ? ("B") : ("C"));
		  System.out.println("등급:" + grade);
		  //풀이//
		 
		  
		 
//		String idBack = "3222222";
//		String strNum = idBack + " ";
//		String S = (idBack.substring(0, 1));
//		int N = Integer.parseInt(S);
//		String result = (N % 2 == 0) ? ("여성") : ("남성");
//		System.out.println(result);
		
		  
System.out.println("\n====== 2번문제 ======\n");
		  
		  String idBack = "1231476";
		  
		  String first = idBack.substring(0, 1);
		  System.out.println(first);
		  
		  char start = idBack.charAt(0);
		  System.out.println(start);
		  
		  String strStart = start + "";
		  System.out.println(strStart);
		  
		  int num = Integer.parseInt(strStart);
		  String gender = (num % 2 == 1) ? ("남성") : ("여성");
		  System.out.println(gender);
		  //풀이//
	}
}
