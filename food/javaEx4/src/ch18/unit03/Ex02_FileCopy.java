package ch18.unit03;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex02_FileCopy {

	public static void main(String[] args) {
		Path from = Paths.get("test.txt");
		Path to = Paths.get("sample.txt");
		
		try {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사완료...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
