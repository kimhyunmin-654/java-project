package ch14.unit03;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex06_FileWriter {

	public static void main(String[] args) {
		String pathname = "text.txt";
		int data;
		
		try(FileWriter fw = new FileWriter(pathname)) {
			// 문자출력스트림(텍스트 파일만 가능, 2진파일은 저장 불가)
			// 문자열도 가능
			
			System.out.println("문자열 입력[Ctrl+Z:종료] : ");
			Reader rd = new InputStreamReader(System.in); 
			while((data = rd.read()) != -1)  {
				fw.write(data);
			}
			fw.flush();
			
			System.out.println("파일 저장 완료!!!");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
