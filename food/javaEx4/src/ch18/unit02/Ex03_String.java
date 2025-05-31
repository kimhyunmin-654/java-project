package ch18.unit02;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Ex03_String {

	public static void main(String[] args) {
		Charset charset = Charset.forName("utf-8");
		
		// 문자열 -> 인코딩 -> byteBuffer
		String s = "자바 NIO입니다.";
		System.out.println(charset.encode(s).toString());
		ByteBuffer bb = charset.encode(s);
		
		// ByteBuffer -> 디코딩 -> 문자열
		String s2 = charset.decode(bb).toString();
		
		System.out.println("복원 : " + s2);
	}

}
