package ch09_Class.homepage;

import java.util.ArrayList;

public class BoardDB {
	
	private ArrayList<Board> boardList = new ArrayList<>();
	
	// 싱글톤 적용
	// 싱글톤 사용 목적 - 프로젝트 내에서 이 클래스로 부터 객체를 딱 하나만 생성할 목적으로 사용
	
	private BoardDB() {
		boardList.add(new Board(1, "공지사항 필독", "욕설금지", "admin"));
		
	}
	
	private static BoardDB instance = new BoardDB(); 
	// 다른곳에서 쓸수있게 선언하는거
	// static으로 다른곳에 사용할수있게 해주지만 수정은 못하게 private를 쓴다.
	
	public static BoardDB getInstance() {
		return instance;
	}
	
	// 게시글 목록 출력
	public void showBoardList() {
		for(int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i));
			
			
		}
	}
	
	// 게시글 추가
	public void addBoard(Board board) {
		// board 객체 내부에 no가 0이 들어있음
		
		// board 객체 내부 no를 boardList.size() + 1 로 변경
		board.setNo(boardList.size() + 1);
		
		boardList.add(board);
	}
	
	public void selectBoard(int no) {
		// boardList에서 존재하는 board 객체 중에 
		// 파라미터로 들어온 no와 같은 no를 가지는 board 객체 찾기
		for(int i = 0; i < boardList.size(); i++) {
			Board bo = boardList.get(i);
			if(boardList.get(i).getNo() == no) {
				System.out.println("제목 :" + boardList.get(i).getTitle());
				System.out.println("작성자: " + boardList.get(i).getAuthor());
				System.out.println("=================");
				System.out.println(boardList.get(i).getContent());
				
				
				return;
			}
		}
		
		System.out.println("존재하지 않은 글번호입니다.");
		
	}
}
