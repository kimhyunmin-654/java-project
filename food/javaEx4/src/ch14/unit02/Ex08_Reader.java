package ch14.unit02;

import java.io.InputStreamReader;
import java.io.Reader;

public class Ex08_Reader {

	public static void main(String[] args) {
		// InputStream : 바이트 스트림
		// Reader : 문자 스트림
		// InputStreamReader : 바이트 스트림을 문자 스트림으로 변환
		// Reader read() : 1문자를 입력 받아 코드를 반환
		
		int data;
		char ch;
		
		// AB엔터 : 65 66 13 10
		// 대한엔터 : 45824 54620 13 10
		try {
			Reader rd = new InputStreamReader(System.in);
			
			System.out.println("입력[Ctrl+Z : 종료]");
			while((data =  rd.read()) != -1) {
				// System.out.println(data);
				
				ch = (char)data; 
				// System.out.write(ch); // 2byte 문자를 1byte문 출력 하므로 한글은 출력이 안됨 
				System.out.print(ch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
