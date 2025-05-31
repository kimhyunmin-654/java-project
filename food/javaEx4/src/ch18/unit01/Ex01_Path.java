package ch18.unit01;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/*
 	- Path
 	  : 파일 시스템의 경로를 표현하는 인터페이스
 	    파일 경로, 디렉터리 경로 등을 객체로 다룬다.
 */

public class Ex01_Path {
	public static void main(String[] args) {
		Path path = Paths.get("C:/db/demo/test.txt");
		
		System.out.println("파일명 : " + path.getFileName());
		System.out.println("부모 경로 : " + path.getParent().getFileName());
		System.out.println("중첩경로수 : " + path.getNameCount());
		System.out.println();
		
		for(int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
		System.err.println();
		
		Iterator<Path> it = path.iterator();
		while(it.hasNext()) {
			Path t = it.next();
			System.out.println(t.getFileName());
		}
	}
}
