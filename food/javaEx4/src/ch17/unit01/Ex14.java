package ch17.unit01;

import java.util.function.BiFunction;

public class Ex14 {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = new String("java");
		
		boolean b = s1.equals(s2);
		System.out.println("문자열 비교 : " + b);
		System.out.println("주소 비교 : " + (s1 == s2));
		
		// 람다식
		BiFunction<String, String, Boolean> f = (a1, a2) -> a1.equals(a2);
		Boolean bobj = f.apply(s1, s2);
		System.out.println("람다 문자열 비교 : " + bobj);
		
		// 인스턴스 메서드 참조
		BiFunction<String, String, Boolean> f2 = String::equals;
		Boolean bobj2 = f2.apply(s1, s2);
		System.out.println("메서드 참조 문자열 비교 : " + bobj2);
		
	}

}
