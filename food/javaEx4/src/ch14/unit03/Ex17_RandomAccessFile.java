package ch14.unit03;

import java.io.RandomAccessFile;

public class Ex17_RandomAccessFile {

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		
		try {
			// 읽고 쓰기가 가능한 랜덤파일 객체 생성
			raf = new RandomAccessFile("ex.txt", "rw");
			
			// 파일에 영문자 저장
			for(int i = 65; i<= 90; i++) {
				raf.write(i);
			}
			
			// 파일의 내용을 읽을 위치로 이동
			byte b;
			raf.seek(5);
			b = raf.readByte();
			System.out.write(b); // F
			
			raf.seek(10);
			b = raf.readByte();
			System.out.write(b); // k
			
			b = raf.readByte();
			System.out.write(b); // L
			
			System.out.flush();
			System.out.println();
			
			raf.seek(0);
			for(int i = 0; i< (int)raf.length(); i++) {
				System.out.write(raf.readByte());
			}
			System.out.flush();
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(raf != null) {
				try {
					raf.close();
				} catch (Exception e2) {
				}
			}
		}
	}

}
