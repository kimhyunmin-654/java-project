package ch14.unit03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Ex07_FileReader {

	public static void main(String[] args) {
		String pathname = "text.txt";
		int data;
		
		try(FileReader fr = new FileReader(pathname)) {
			// 파일 입력 문자 스트림(이미지, 2진파일을 입력 불가)
			
			Writer wt = new OutputStreamWriter(System.out);
			
			System.out.println("파일 내용...");
			while((data = fr.read()) != -1) {
				wt.write(data);
			}
			wt.flush();
		} catch (FileNotFoundException e) {
			System.out.println(pathname + " 파일은 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
