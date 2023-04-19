package ch09_Class.school;

import ch09_Class.commons.UtilClass;
import ch09_Class.nextit.NextStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SchoolMain {

	public static void main(String[] args) {
		// 이름, 국어, 영어, 수학, 평균 점수를 가지는 학생 객체
		
		Student yesl = new Student("예슬", 90, 80, 87, (85+80+87)/3.0);
		
		System.out.println(yesl);
		
		// 캡슐화
		// 같은 폴더 내에 있는 클래스라면 private 빼곤 다 접근 가능하다.
		System.out.println(yesl);
		
		// avg에 대한 Setter를 지워서 평균은 수정할 수 없도록 한다.
		// yesl.setAvg(100);
		System.out.println(yesl);
		
		System.out.println(yesl.getKor());
		System.out.println(yesl.getAvg());
		
		
		// 국어 점수 바꾸기
		yesl.setKor(93);
		System.out.println(yesl);
		
		System.out.println("\n===========================\n");

		Student qwe = new Student("진영", 90, 80, 87, UtilClass.weRound((90 + 80 + 87) /3.0, 1));
		System.out.println(qwe);
		
		qwe.setEng(86);
		System.out.println(qwe);
		
		// 평균을 넣지 않아도 적용되도록 생성자 추가(student java23)
		Student asd = new Student("대일", 92, 83, 78);
		System.out.println(asd);
		
		System.out.println("\n===========================\n");

		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(yesl);
		stuList.add(qwe);
		stuList.add(asd);
		stuList.add(new Student("준호", 80, 82, 77));
		stuList.add(new Student("동욱", 70, 92, 78));
		
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
		System.out.println("\n===========================\n");
		
		// 학생들의 평균을 이용해서 1등 ~ 5등 출력
		for (int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				if (stuList.get(i).getAvg()  < stuList.get(i + 1).getAvg()) {
					Student t = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, t);
				}
			}
		}
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		
	}

		System.out.println("\n===========================\n");
		
		// Collections.sort()
		Collections.sort(stuList, new Comparator<Student>() {
			@Override
			public int compare(Student stuA, Student stuB) {
				double diff = stuA.getAvg() - stuB.getAvg();
				// 양의 소수, 음의 소수
				if(diff < 0) {
					// 음의 정수
					return -1;
				}
					return 1;
				}
		});
	
		Collections.sort(stuList, (stuA, stuB) ->
		(stuA.getAvg() - stuB.getAvg() > 0) ? (1) : (-1) );
		
		for(int k = 0; k < stuList.size()-1; k++) {
			for(int i = 0; i < stuList.size()-1; i++) {
				if(stuList.get(i).getAvg() < stuList.get(i + 1).getAvg() ) {
					Student t = stuList.get(i);
					stuList.set(i, stuList.get(i+1 ));
					stuList.set(i+1, t);
					}
				}
		}
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등  " +stuList.get(i));
		}
	}
}

	
	
	
