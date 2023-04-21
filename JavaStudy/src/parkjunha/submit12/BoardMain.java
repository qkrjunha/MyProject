package parkjunha.submit12;

import java.text.SimpleDateFormat;
import  java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

static ArrayList<String> itemList = new ArrayList<String>();
    static ArrayList<Date> timeList = new ArrayList<Date>();

    public static void main(String[] args) {
    	CartoonBoard cb = new CartoonBoard(1, "일빠", "내용", "2023.04.21", "이미지");
    	System.out.println(cb);
    	
    	
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 글 목록  | 2. 글 쓰기 | 3. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                for (int i = 0; i < itemList.size(); i++) {
                    String item = itemList.get(i);
                    Date time = timeList.get(i);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                    String formattedTime = sdf.format(time);
                    System.out.println((i + 1) + ". | " + item + " | " + formattedTime);
                }
            } else if (command == 2) {
                System.out.print("글 제목을 입력해주세요: ");
                String title = scan.nextLine();
                System.out.print("글 제목을 입력해주세요: ");
                String content = scan.nextLine();

                itemList.add(title);
                timeList.add(new Date());
            } else {
                // 프로그램 종료
                System.out.println("종료합니다.");
                break;
            }
        }

    }
}
