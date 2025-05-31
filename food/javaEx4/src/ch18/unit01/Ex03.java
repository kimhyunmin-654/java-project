package ch18.unit01;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex03 {

	public static void main(String[] args) {
		try {
			Path p1 = Paths.get("C:/db/demo/test.txt");
			Path p2 = Paths.get("C:/db/ex.txt");
			
			if(Files.notExists(p1)) {
				Files.createDirectories(p1);
			}
			
			if(Files.notExists(p2)) {
				Files.createFile(p2);
			}
			
			Path p3 = Paths.get("C:/db");
			DirectoryStream<Path> ds = Files.newDirectoryStream(p3);
			for(Path p : ds) {
				if(Files.isDirectory(p)) {
					System.out.println("폴더 : " + p.getFileName());
				} else {
					System.out.println("파일 : " + p.getFileName()
						+ ", 크기 : " + Files.size(p));
				}
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
