package ch15.unit01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class Ex01_ObjectOutputStream {

	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("자바", "프로그래밍");
		ht.put("HTML", "웹프로그래밍");
		ht.put("오라클", "데이터베이스");
		
		String pathname = "object.txt";
		
		// ObjectOutputStream
		// : 객체를 저장할 수 있는 스트림
		// : 객체를 저장하면 최상단에 클래스명이 저장됨		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathname))) {
			oos.writeObject(ht); // 객체가 가지고 값을 바이트 형태로 변환하여 저장
			System.out.println("파일 저장 완료...");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
