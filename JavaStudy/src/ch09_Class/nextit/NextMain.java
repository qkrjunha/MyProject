package ch09_Class.nextit;

import java.util.ArrayList;
import java.util.Collections;
import ch09_Class.school.Student;

public class NextMain { // 메인 메소드를 보유하고 있는 클래스 (실행의 주체가 됨)

	public static void main(String[] args) {
		// 학생 상태 관리
		String changyeonName = "창연";
		int changyeonAge = 30;
		int changyeonLevel = 2;
		int changyeonExp = 80;

		// 하루가 지나면 경험치를 얻고 (20~60)
		// 경험치가 100이 넘으면 레벨을 1 올려준다.
		int rand = (int) (Math.random() * 41) + 20;
		changyeonExp += rand;
		System.out.println("창연씨의 현재 경험치는" + changyeonExp);
		if (changyeonExp >= 100) {
			System.out.println("레벨업!");
			changyeonLevel++;
			System.out.println("창연씨의 현재 레벨은" + changyeonLevel);
			changyeonExp -= 100;
		}

		String minkiName = "민기";
		int minkiAge = 28;
		int minkiLevel = 3;
		int minkiExp = 70;

		rand = (int) (Math.random() * 41) + 20;
		minkiExp += rand;
		System.out.println("민기씨의 현재 경험치는" + minkiExp);
		if (minkiExp >= 100) {
			System.out.println("레벨업!");
			minkiLevel++;
			System.out.println("민기씨의 현재 레벨은" + minkiLevel);
			minkiExp -= 100;
		}

		System.out.println("\n============================\n");

		// 클래스를 통한 객체 생성
		NextStudent junho = new NextStudent();

		// NextStudent 클래스에 선언된 필드 변수들을 가지고 있다.
		System.out.println(junho.name); // null
		System.out.println(junho.age); // 0
		System.out.println(junho.level); // 0 이렇게 출력하면 값이 저렇게나옴
		System.out.println(junho.exp); // 0

		// 필드 변수의 값에는 기본적으로 기본값(디폴트)이 들어있다.
		// 기본타입: 숫자(0), boolean(false)
		// 참조타입: null

		// 객체의 필드변수에 값 넣기
		junho.name = "준호";
		junho.age = 30;
		junho.level = 2;
		junho.exp = 30;

		System.out.println(junho); // 에러

		System.out.println(junho.name);
		System.out.println(junho.age);
		System.out.println(junho.level);
		System.out.println(junho.exp);

		// 하루가 지났다.
		rand = (int) (Math.random() * 41) + 20;
		junho.exp += rand;
		System.out.println("준호씨의 현재 경험치는" + junho.exp);

		if (junho.exp >= 100) {
			System.out.println("레벨업!");
			junho.level++;
			System.out.println("준호씨의 현재 레벨은" + junho.level);
			junho.exp -= 100;
		}

		// 태윤씨도 추가
		NextStudent taeyoon = new NextStudent();
		taeyoon.name = "태윤";
		taeyoon.age = 28;
		taeyoon.level = 3;
		taeyoon.exp = 70;

		// 하루가 지났다

		taeyoon.endDay();
		junho.endDay();

		System.out.println("\n============================\n");

		// 지혜
		// 객체를 생성하면서 필드 변수값을 채운다
		// 생성자의 파라미터 순서에 유의해서 필드 변수의 값을 넣는다.
		NextStudent jihye = new NextStudent("지혜", 28, 3, 40);

		System.out.println(jihye.name);
		System.out.println(jihye.age);
		System.out.println(jihye.level);
		System.out.println(jihye.exp);

		// 객체의 상태를 한번에 보고싶으면
		// 클래스 내에 toString() 메소드 오버라이딩
		// syso 내에 객체를 넣게 되면, toString()의 실행결과가 콘솔창에 출력
		System.out.println(jihye);
		System.out.println(jihye.toString());

		System.out.println("\n============================\n");

		// 여러분들의 짝궁에 대해 객체로 만들어주시는데 레벨과 경험치는 1과0으로 고정해서 만들어보세요
		NextStudent jinyoung = new NextStudent("진영", 25, 1, 0);
		NextStudent dail = new NextStudent("대일", 26, 1, 0);
		System.out.println(jinyoung);
		System.out.println(dail);

		// 레벨과 경험치는 1과0으로 고정
		// 객체를 생성할때, 레벨과 경험치를 건드리지는 않는다.
		// 이름과 나이만 입력받는 생성자로 객체를 생성하고자 한다.
		NextStudent junha = new NextStudent("준하", 27);
		System.out.println(junha);

		System.out.println("\n============================\n");

		// 객체 복사
		// 같은 필드변수 값을 가지는 새로운 객체 생성

		NextStudent junhaBot = new NextStudent(junha.name, junha.age, junha.level, junha.exp);
		System.out.println(junhaBot);
		junhaBot.name = "준하봇";
		System.out.println(junhaBot);
		System.out.println(junha);

		System.out.println("\n============================\n");

		// 하루가 지났다.
		jihye.endDay();
		junha.endDay();
		dail.endDay();
		jinyoung.endDay();
		junho.endDay();
		taeyoon.endDay();

		// 다수의 객체를 다루기 위해서 ArrayList에 담는다.
		ArrayList<NextStudent> stuList = new ArrayList<>();

		stuList.add(jihye);
		stuList.add(junha);
		stuList.add(dail);
		stuList.add(jinyoung);
		stuList.add(junho);
		stuList.add(taeyoon);

		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).endDay();
		}

		// 향상된 for문
		for (NextStudent stu : stuList) {
			stu.endDay();
		}

		// 객체를 생성하면서 ArrayList에 담기
		NextStudent jayoung = new NextStudent("자영", 25);
//		stuList.add(jayoung);
		stuList.add(new NextStudent("자영", 25));

		System.out.println(stuList.size());

		// 16일이 지났다
		// 하루가 지났다

		for (int i = 0; i < 16; i++) {
			for (NextStudent stu : stuList) {
				stu.endDay();
			}
		}

		System.out.println("\n============================\n");

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		// 레벨을 이용하여 정렬하기
		// Collections.sort는 정렬 기준을 모르면 에러가난다.
//		Collections.sort(stuList); -> 에러
		System.out.println("\n============================\n");

		// 버블정렬 이용하여 정렬 
		// 변수명 한번에 바꾸기 단축키 [Alt + Shift + R]
		// 레벨순으로 정렬
		// stuList [지혜] ,[태윤], [진영] 등등이 들어가있다.
		for (int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (stuList.get(i).level  < stuList.get(i + 1).level) {
					NextStudent t = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, t);
				}
			}
		}
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
			
		}
		System.out.println("\n============================\n");

		// 정렬 기준을 알려주면
		// Collections.sort()를 사용할 수 있다.
		
		
		// 람다식 사용
		// stuA - stuB 는 오름차순
		Collections.sort(stuList, (stuA, stuB) -> stuA.level - stuB.level);
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
			
		}
		System.out.println("\n============================\n");

		// stuB - stuA 는 내림차
		Collections.sort(stuList, (stuA, stuB) -> stuB.level - stuA.level);
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		
		// Student 폴더에 파일을 Next파일에 적용하는법 
//		Student  temp = new Student();
//		System.out.println(temp.kor);
		
	}
}