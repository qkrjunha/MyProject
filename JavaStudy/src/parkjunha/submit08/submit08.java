package parkjunha.submit08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class submit08 {

	public static void main(String[] args) {
	
		ArrayList<Integer> myLotto = makeLotto();
		System.out.println(myLotto);
		
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("아아디를 입력해주세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String pw = sc.next();
		
		// infoMap.get(id) 입력한 id 키값 중에 존재하면 value 리턴 ,없으면 null 리턴
		// if(infoMap.get(id) != null {   id가 amp안에 키값으로 존재
		// TODO 비밀번호체크
		// infoMap.get(id).equals(pw) {
		// System.out.println("로그인 성공");
		// }else {
		// 	System.out.println("비밀번호가 틀렸습니다.");
		
		while(true) {
			if (infoMap.containsKey(id)) {
				if(infoMap.containsValue(pw)) {
					System.out.println("로그인 성공");
					break;
				}
				if(!infoMap.containsValue(pw)) {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
			}
			else if(!infoMap.containsKey(id)) {
				System.out.println("존재하지 않는 아이디입니.");
				break;
			}
		}
		
	}
	
	public static ArrayList<Integer> makeLotto() {
		
		HashSet<Integer> lotto = new HashSet<>();
		
		int num;
		
		while(lotto.size() != 6) {
			
			num = (int)(Math.random() * 45) + 1;
			
			lotto.add(num);
		}
		
		ArrayList<Integer> lottoList = new ArrayList<>(lotto);
		
		Collections.sort(lottoList);
		
		return lottoList;
	}
}