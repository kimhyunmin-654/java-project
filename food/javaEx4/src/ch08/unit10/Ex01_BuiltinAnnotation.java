package ch08.unit10;

import java.util.Date;

public class Ex01_BuiltinAnnotation {
	public static void main(String[] args) {
		User obj = new User();
		
		System.out.println(obj);
		
		obj.sub();
		
		obj.sub2();
	}
}

// 자바에 내장된 어노테이션
class User {
	
	/*
	 - @Override 
	 	: 메소드의 재정의 규칙에 위반하면 애러 출력 
	 	: toString() 메소드를 이름을 ToString() 으로 작성하면 에러
	 */
	
	@Override
	public String toString() {
		return "Annotation Test";
	}
	
	/*
	 - @Deprecated
	 	: 더 나은, 개선된 메소드가 있음을 나타내고자 하는 경우에 사용
	 
	 */
	
	@Deprecated
	public void sub() {
		System.out.println("사용을 자재해 주세요...");
	}
	
	
	/*
	  - @SuppressWarnings
	  	: 컴파일러 경고와 관련된 어노테이션
	  	: 이 부분에 대하여 경고문을 출력하지 말라는 의미
	 */
	
	@SuppressWarnings("deprecation")
	public void sub2() {
		Date date = new Date();
		int y = date.getYear() + 1900;
		System.out.println("올해 년도 : " + y);
	}
}