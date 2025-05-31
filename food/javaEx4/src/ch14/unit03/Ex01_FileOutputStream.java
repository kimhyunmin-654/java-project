package ch14.unit03;

import java.io.FileOutputStream;

/*
 	- FileOutputStream
 	  : 파일 출력 byte 스트림
 	  : 파일이 없으면 만들고, 있으면 지우고 만듬
 */

public class Ex01_FileOutputStream {

	public static void main(String[] args) {
		String pathname = "test.txt";
		FileOutputStream fos = null;
		int data;
		
		try {
			fos = new FileOutputStream(pathname);
			
			System.out.println("문자열[Ctrl+Z : 종료]");
			while((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.flush();
			
			System.out.println("파일저장 완료 !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
				}
			}
		}
		
	}

}
