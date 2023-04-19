package parkjunha.submit07;

import java.util.ArrayList;
import java.util.Arrays;

public class submit07 {

	public static void main(String[] args) {

		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 11) + 10;
			intList.add(rand);
			
//			int rand1 = makeRandom(10,20);  @문 
//			System.out.println(rand1);  
		}
		System.out.println(intList);

		ArrayList<Integer> result = new ArrayList<>();
		

		for (int Remove : intList) {
			if (!result.contains(Remove)) {
				result.add(Remove);
			}
		}
		
		System.out.println(result);
		
		// for (int i = 0; i < intList.size(); i++) {
		// result.add(intList.get(i));   
		// result 안에 현재의 intList.get(i) 가 존재하지 않는 경우에만 추가하기
		// if(!result.contains(intList.get(i))) {
		// result.add(intList.get(i));
		//		}
		// }
		// System.out.println(result);   --> 중복제거 다른방법
		
		// for(int i = 0 ; i < intList.size(); i++) {
		// for(int k = intList.size() -1; k > i; k--) {
		// intList.get(i) == intList.get(K)) {
		// intList.remove(k);
		//}
		//	}
		//}
		//System.out.println(intList); --> 중복제거 다른방법
		
		for (int k = 0; k < result.size(); k++) {
			for (int i = 0; i < result.size() - 1; i++) {
				if (result.get(i) > result.get(i + 1)) {
					int t = result.get(i);
					result.set(i, result.get(i + 1));
					result.set(i + 1, t);
				}

			}
		}
		System.out.println("오름차순: " + result);

		for (int k = 0; k < result.size(); k++) {
			for (int i = 0; i < result.size() - 1; i++) {
				if (result.get(i) < result.get(i + 1)) {
					int t = result.get(i);
					result.set(i, result.get(i + 1));
					result.set(i + 1, t);
				}

			}
		}
		System.out.println("내림차순: " + result);

		System.out.println("\n==============2번==============\n");

		ArrayList<String> hus = new ArrayList<>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));
		ArrayList<String> wife = new ArrayList<>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));

		ArrayList<String> gyo = gyo(wife, hus);
		ArrayList<String> hap = hap(wife, hus);
			
		for (int i = 0; i < gyo.size(); i++) {
			System.out.println(gyo.get(i));
		}

		for (int i = 0; i < hap.size(); i++) {
			System.out.print(hap.get(i) + " ");
		}
		
		// 교집합을 위한 .retainAll()
		// wantBuy.clear();
		// wantBuy.addAll(wife);
		// wantBuy.retainAll(husList);
		// System.out.println(wantbuy);
		
		
	}
	
//	public static int makeRandom(int a, int b) {
//		int rand1 = (int) (Math.random() * 11) + 10;
//		return rand1;
		// = return(int) (Math.random() * 11) + 10;
//	} @ 문제
	
	public static ArrayList<String> hap(ArrayList<String> wife, ArrayList<String> hus) {
		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < wife.size(); i++) {
			result.add(wife.get(i));
		}

		boolean check = true;
		for (int i = 0; i < hus.size(); i++) {
			for (int j = 0; j < result.size(); j++) {
				if (hus.get(i).equals(result.get(j))) {
					check = false;
				}
			}
			if (check) {
				result.add(hus.get(i));
			}
			check = true;
		}

		return result;
	}

	public static ArrayList<String> gyo(ArrayList<String> wife, ArrayList<String> hus) {

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < wife.size(); i++) {
			for (int j = 0; j < hus.size(); j++) {
				if (wife.get(i).equals(hus.get(j))) {
					result.add(wife.get(i));
				}
			}
		}
		return result;
	}

}
