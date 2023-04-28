package ch15_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TreasureHunter {

	public static void main(String[] args) {
		String path = "/home/pc12/today/treasure";

		// treasure 폴더 내 파일을 먼저 찾기

		File folder = new File(path);
		System.out.println(folder);

		File[] inner = folder.listFiles();
		for (int i = 0; i < inner.length; i++) {
			if (inner[i].isDirectory()) {
				// 폴더
				File[] innerinner = inner[i].listFiles();
				for (int k = 0; k < innerinner.length; k++) {
					if (innerinner[k].isDirectory()) {

					} else {
						System.out.println(innerinner[k]);
					}

				}

			} else {
				// 파일
				System.out.println(inner[i]);
			}
		}
		
		findFile(folder);
		
		
	}// main 끝

	public static void findFile(File folder) {
		File[] inner = folder.listFiles();
		for (int i = 0; i < inner.length; i++) {
			if (inner[i].isDirectory()) {
				findFile(inner[i]);
			} else {
				System.out.println(inner[i]);
			}
		}
	}
}