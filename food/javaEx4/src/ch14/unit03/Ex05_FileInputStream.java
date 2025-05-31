package ch14.unit03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex05_FileInputStream {

	public static void main(String[] args) {
		String pathname = "test.txt";
		int data;
		
		try(FileInputStream fis = new FileInputStream(pathname)) {
			System.out.println(pathname + " 파일 내용...");

			while((data = fis.read()) != -1) {
				System.out.write(data);
			}
			System.out.flush();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
