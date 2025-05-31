package ch14.unit02;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Ex09_Writer {

	public static void main(String[] args) {
		int data;
		
		try {
			Reader rd = new InputStreamReader(System.in);
			Writer wt = new OutputStreamWriter(System.out);
			
			System.out.println("문자열[Ctrl+Z:종료]...");
			while((data = rd.read()) != -1) {
				wt.write(data); // 하위 2byte 출력
			}
			wt.flush(); // Ctrl+Z 를 눌러야 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
