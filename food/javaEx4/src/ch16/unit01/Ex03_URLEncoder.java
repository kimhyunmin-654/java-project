package ch16.unit01;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Ex03_URLEncoder {

	public static void main(String[] args) {
		String s1, s2;
		
		try {
			s1 = "자바 java 123";
			
			// 문자열을 인터넷 상태에서 전송할수 있는 주소형식으로 변환
			// (application/x-www-form-urlencoded)
			s2 = URLEncoder.encode(s1, "utf-8");
			System.out.println("인코딩 결과 : " + s2);
			// 영문자, 숫자, ., -, *, _ 는 그대로
			// 공백은 +, 나머지는 %xy 형식의 16진수로 인코딩
			
			// application/x-www-form-urlencoded 형식의 문자열을 원래 문자열로 복원
			s1 = URLDecoder.decode(s2, "utf-8");
			System.out.println("디코딩 결과 : " + s1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
