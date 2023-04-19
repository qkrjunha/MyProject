package ch09_Class.quiz;

import java.util.ArrayList;

public class MovieDB {
	
	private ArrayList<Movie> movieList = new ArrayList<>();
	
	// 싱글톤 패턴 (본인 생성자를 비공개로 만든다. MovieDB)
	private MovieDB() {
		movieList.add(new Movie("신세계", "거 죽기 딱 좋은 날씨네", "이정재 황정민 박성웅", "ㅅㅅㄱ"));
		movieList.add(new Movie("범죄와의전쟁", "느그 서장 남천동 살제?", "최민식, 하정우", "ㅂㅈㅇㅇㅈㅈ"));
		movieList.add(new Movie("베테랑", "어이가 없네", "황정민 유아인", "ㅂㅌㄹ"));
		movieList.add(new Movie("추격자", "야 4885 너지?", "하정우 김윤석", "ㅊㄱㅈ"));
		movieList.add(new Movie("청년경찰", "열정, 진념, 그리고.. 진심", "박서준 강하늘", "ㅊㄴㄱ"));
		movieList.add(new Movie("검사외전", "한치의 거짓도 없는 백 프로 진실입니다", "강동원 황정민", "ㄱㅅㅇㅈ"));
		movieList.add(new Movie("변호인", "국가란 국민입니다", "송강호 임시완 곽도원", "ㅂㅎㅇ"));
		movieList.add(new Movie("타짜", "묻고 더블로 가", "김혜수 유해진 김응수", "ㅌㅉ"));
		movieList.add(new Movie("친구", "니가 가라 하와이", "장동건 유오성 서태화", "ㅊㄱ"));
		movieList.add(new Movie("범죄도시", "내 누구지 아니", "마동석  윤계상", "ㅂㅈㄷㅅ"));
	}
	
	//다른곳에서 접속할수 있도록 본인을 소환한다.(수정,변경 위험이있어서 private으로 막는다)
	private static MovieDB instance = new MovieDB();
	
	//instance를 가져가도 되게 public 으로 연다
	public static MovieDB getInstance() {
		return instance;
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
	
	
	
	
}
