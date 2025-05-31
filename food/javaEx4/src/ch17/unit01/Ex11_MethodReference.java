package ch17.unit01;

public class Ex11_MethodReference {

	public static void main(String[] args) {
		String s;
		
		// 정수를 문자열로 변환
		s = String.valueOf(50);
		System.out.println("결과 : " + s);
		System.out.println();
		
		// 람다식을 이용하여 정수를 문자열로 변환 
		Test1 t = n -> String.valueOf(n);
		s = t.convert(150);
		System.out.println("결과 : " + s);
		
		
		// 메서드 참조
		// : 메서드를 참조하여 매개변수의 정보 및 리턴타입을 알아내어
		//	 람다식에서 불필요한 매개변수를 제거하는데 목적이 있음
		// 클래스 메서드 참조 이용
		Test1 t2 = String::valueOf;
		s = t2.convert(200);
		System.out.println("메소드 참조 결과 : " + s);
		
	}
}

interface Test1 {
	public String convert(Integer num); 
}
