package ch14.unit03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCopyEx01 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source = null, dest = null;
		int data;
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			System.out.print("복사할 원본 파일명 ? ");
			source = br.readLine();
			
			System.out.print("복사시킬 대상 파일명 ? ");
			dest = br.readLine();
			
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest);
			
			// 잘못 코딩한 예 - 시간이 많이 걸림
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.flush();
			
			System.out.println("파일 복사 완료 !!!");
			
		} catch (FileNotFoundException e) {
			System.out.println(source + " 파일이 없습니다..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {

				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
						
				}
			}
		}
		
	}

}
