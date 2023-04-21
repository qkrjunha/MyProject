package parkjunha.submit12;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import ch09_Class.nextit.NextStudent;

public class DateBoardMain {

public static void main(String[] args) {
// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");


for (int i = 0; i < 50; i++) {
int randDay = (int) (Math.random() * 365) + 1; // 1~365
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DATE, randDay * -1);

String strDate = sdf.format(cal.getTime());
dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
}

for (int i = 0; i < dbList.size(); i++) {
System.out.println(dbList.get(i));
}

// TODO 코드작성 시작 ~!!

System.out.println("\n========================================================\n");
// 날짜 정렬
// 1. 버블정렬
//for (int k = 0; k < dbList.size() - 1; k++) {
//	for (int i = 0; i < dbList.size() - 1; i++) {
//		// 날짜 비교
//		// String date
//		// 2023.02.21 12:34:56 -> Date 객체 with sdf.parse
//		Date left = sdf.parse(dbList.get(i).getDate());
//		Date right = sdf.parse(dbList.get(i+1).getDate());
//		
//		if (left.getTime()  < right.getTime()) {
//			DateBoard t = dbList.get(i);
//			dbList.set(i, dbList.get(i + 1));
//			dbList.set(i + 1, t);
//		}


dbList.sort(Comparator.comparing(DateBoard::getDate).reversed());
System.out.println("날짜별로 정렬 후 출력(최신순)");
dbList.forEach(item -> System.out.println(item.toString()));

System.out.println("\n========================================================\n");

//Collections.sort(dbList, new Comparator<DateBoard>() {
//
//@Override
//public int compare(DateBoard dbA, DateBoard dbB) {
//	 int result = 1;
//	 try {
//	 Date left = sdf.parse(dbA.getDate());
//	 Date right = sdf.parse(dbB.getDate());
//	 
//	 if(left.getTime() - right.getTime() < 0) {
//	 result = -1;
//	 }
//	 catch(ParseException e) {
//		 e.printStackTrace();
//	 }
//	 return result;
dbList.sort(Comparator.comparing(DateBoard::getDate));
System.out.println("날짜별로 정렬 후 출력(오래된 순)");
dbList.forEach(item -> System.out.println(item.toString()));


	 
System.out.println("\n========================================================\n");
// Calendar cal = Calendar.getInstance();
// cal.add(Calendar.MONTH, -1); // 한달 전 날짜로 세팅
// for(int i =0; i < dbList.size(); i++) {
//Date temp = sdf.parse(dbList.get(i).getDate());
//
//// temp를 밀리초로 나타낸 것이
////  한달 전 날짜를 밀리초로 나타낸 것보다 크면
//// 최근 한달 내 데이터를 의미한다.
//if(temp.getTime() > cal.getTime().getTime()) {
//System.out.println(dbList.get(i));
// 	} 
// }
 
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DATE, -30);

System.out.println("최근 한달 내에 작성된 게시글 출력");
for (DateBoard board : dbList) {
   try {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
       Calendar boardCal = Calendar.getInstance();
       boardCal.setTime(dateFormat.parse(board.getDate()));
       if (boardCal.compareTo(cal) >= 0) {
           System.out.println(board);
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
}
System.out.println("\n========================================================\n");

//이번달 게시글
//Calendar toMonth = Calendar.getInstance();
//
//int year = toMonth.get(Calendar.YEAR);
//int month = toMonth.get(Calendar.MONTH);
//
//for(int i =0; i < dbList.size(); i++) {
//	Date temp = sdf.parse(dbList.get(i).getDate());
//	Calendar tempCal = Calendar.getInstance();
//	tempCal.setTime(temp);
//	int tempYear = tempCal.get(Calendar.YEAR);
//	int tempMonth = tempCal.get(Calendar.MONTH);
//	
//	if(year == tempYear && month == tempMonth) {
//		System.out.println(dbList.get(i));
//	}
//}
Calendar cal2 = Calendar.getInstance();
int thisYear = cal2.get(Calendar.YEAR);
int thisMonth = cal2.get(Calendar.MONTH) + 1;
cal2.set(Calendar.YEAR, thisYear);
cal2.set(Calendar.MONTH, thisMonth - 1);
cal2.set(Calendar.DATE, 1);

System.out.println("이번달에 작성된 게시글 출력");
for (DateBoard board : dbList) {
   try {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
       Calendar boardCal = Calendar.getInstance();
       boardCal.setTime(dateFormat.parse(board.getDate()));
       if (boardCal.compareTo(cal2) >= 0) {
           System.out.println(board);
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
}
System.out.println("\n========================================================\n");

Calendar cal3 = Calendar.getInstance();
cal3.set(Calendar.YEAR, 2023);
cal3.set(Calendar.MONTH, Calendar.FEBRUARY);
cal3.set(Calendar.DATE, 1);

System.out.println("2월에 작성된 게시글 출력");
for (DateBoard board : dbList) {
   try {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
       Calendar boardCal = Calendar.getInstance();
       boardCal.setTime(dateFormat.parse(board.getDate()));
       if (boardCal.get(Calendar.YEAR) == 2023 && boardCal.get(Calendar.MONTH) == Calendar.FEBRUARY) {
           System.out.println(board);
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
}
System.out.println("\n========================================================\n");

//String fromStr = "2023.02.14";
//String toStr = "2023.03.21";
//
//sdf = new SimpleDateFormat("yyyy.MM.dd");
//
//	Date FromDate = sdf.parse(fromstr);
//	Date toDate = sdf.parse(toStr);
//	
//	for(int i =0; i < dbList.size(); i++) {
//		Date temp = sdf.parse(dbList.get(i).getDate());
//		// temp를 밀리초로 바꾼 값이
//		// 밀리초로 바꾼것보다 크고
//		// 밀리초로 바꾼것보다 작은 것
//		  temp.getTime()
//				 
//		System.out.println(dbList.get(i));
//	}

Calendar start = Calendar.getInstance();
start.set(Calendar.YEAR, 2023);
start.set(Calendar.MONTH, Calendar.FEBRUARY);
start.set(Calendar.DATE, 14);

Calendar end = Calendar.getInstance();
end.set(Calendar.YEAR, 2023);
end.set(Calendar.MONTH, Calendar.MARCH);
end.set(Calendar.DATE, 21);

System.out.println("2023년 2월 14일부터 3월 21일까지 작성된 게시글 출력");
for (DateBoard board : dbList) {
   try {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
       Calendar boardCal = Calendar.getInstance();
       boardCal.setTime(dateFormat.parse(board.getDate()));
       if (boardCal.compareTo(start) >= 0 && boardCal.compareTo(end) <= 0) {
           System.out.println(board);
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
}


	}



}

