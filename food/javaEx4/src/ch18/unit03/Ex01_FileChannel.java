package ch18.unit03;

import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// 기본 입출력에서는 버퍼에 접근이 불가능
// 채널은 버퍼에 입출력 할 수 있는 버퍼와 데이터 소스, 목적지와의 연결 통로 제공
public class Ex01_FileChannel {
	public static void write(String s, String pathname) {
		FileOutputStream fos = null;
		FileChannel fc = null;
		
		try {
			fos = new FileOutputStream(pathname);
			fc = fos.getChannel();
			
			byte[] bb = s.getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(bb); // wrap 로 바이트버퍼생성
			fc.write(buffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fc != null) {
				try {
					fc.close();
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
	
	public static String read(String pathname) {
		String s = null;
		FileInputStream fis = null;
		FileChannel fc = null;
		
		try {
			fis = new FileInputStream(pathname);
			fc = fis.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
			fc.read(buffer);
			
			buffer.flip();
			
			byte[] bb  = new byte[buffer.limit()];
			buffer.get(bb);
			
			s = new String(bb);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fc != null) {
				try {
					fc.close();
				} catch (Exception e2) {
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {
				}
			}
		}
		
		return s;
	}
	
	
	public static void main(String[] args) {
		String pathname = "ex.txt";
		
		String s1 = "채널 예제 프로그램";
		write(s1, pathname);
		
		String s2 = read(pathname);
		System.out.println(s2);
	}

}
