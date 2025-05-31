package ch14.unit03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex08_FileReader {

	public static void main(String[] args) {
		String pathname = "text.txt";
		String s;
		
		// FileReader
		// : 파일 입력 문자 스트림(이미지, 2진파일을 입력 불가)
		// : 인코딩은 이클립스 설정 인코딩을 따르며 변경 불가
		// - BufferedReader : 필터 스트림. 한줄씩 입력 가능
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathname))) {
			// 파일 입력 문자 스트림(이미지, 2진파일을 입력 불가)
						
			System.out.println("파일 내용...");
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(pathname + " 파일은 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
