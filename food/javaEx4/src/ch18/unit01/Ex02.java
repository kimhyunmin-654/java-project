package ch18.unit01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


// Files
// 	: 파일 및 폴더 조작을 위한 유틸리티 클래스
public class Ex02 {

	public static void main(String[] args) {
		Path path = Paths.get("C:/db/demo/test.txt");
		
		try {
			System.out.println("폴더 여부 : " + Files.isDirectory(path));
			System.out.println("파일 여부 : " + Files.isRegularFile(path));
			System.out.println("마지막수정일자 : " + Files.getLastModifiedTime(path));
			System.out.println("파일크기 : " + Files.size(path));
			System.out.println("파일크기 : " + Files.getOwner(path).getName());
			System.out.println("파일크기 : " + Files.isHidden(path));
			System.out.println("파일크기 : " + Files.isReadable(path));
			System.out.println("파일크기 : " + Files.isWritable(path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
