package ch15_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public static void main(String[] args) {
		// 자바에서 파일에 내용 쓰기
		String filePath = "/home/pc12/today/test.txt";
		
		File test = new File(filePath);
		
		
		// new FileOutputStream(test) -> 기존 파일 내용을 덮어씀
		// new FileOutputStream(test, true) -> 기존 파일 내용에 이어씀
		try(FileOutputStream fos = new FileOutputStream(test,true)) {
			
			String temp = "\n월요일도 쉬지롱~~~~ ";
			
			// String 에 .getByte()하면 byte[] 를 리턴한다.
			byte[] tempBtye = temp.getBytes();
			
			
			fos.write(tempBtye);
			System.out.println("작성완료");
//			fos.write(temp.getBytes());
//			fos.write(오늘은 금요일~~~.getBytes); 다 사용가능

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
	}
}