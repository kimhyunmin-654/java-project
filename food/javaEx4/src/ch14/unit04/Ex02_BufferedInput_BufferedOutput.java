package ch14.unit04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Ex02_BufferedInput_BufferedOutput {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source, dest;
		int len;
		
		byte[] b = new byte[8192];
		
		// 내부적으로 버퍼를 사용하여 파일에서 한번에 큰 블록의 데이터를 읽어오거나 저장하므로 성능이 좋다.
		// 대용량을 다룰때 유리 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			System.out.print("원본파일 ? ");
			source = br.readLine();
			
			System.out.print("복사시킬 파일명 ? ");
			dest = br.readLine();
			
			bis = new BufferedInputStream(new FileInputStream(source));
			// bos = new BufferedOutputStream(new FileOutputStream(dest)); // 기본버퍼:8192
			bos = new BufferedOutputStream(new FileOutputStream(dest), 8192);
			
			while((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			
			System.out.println("파일복사 완료...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (Exception e2) {

				}
			}
			
			if(bos != null) {
				try {
					bos.close();
				} catch (Exception e2) {
				}
			}
		}
		
		
	}

}
