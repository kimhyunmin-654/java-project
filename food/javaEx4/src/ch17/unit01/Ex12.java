package ch17.unit01;

import java.util.function.Supplier;

public class Ex12 {

	public static void main(String[] args) {
		// Supplier<T> : 매개변수가 없고, 리턴타입이 T 인 함수형 인터페이스
		
		// 람다식이용
		Supplier<Test2> obj = () -> new Test2();
		Test2 t = obj.get();
		t.disp();
		
		// 생성자 메서드 참조
		Supplier<Test2> obj2 = Test2::new;
		Test2 t2 = obj2.get();
		t2.disp();
		
	}
}

class Test2 {
	private String name = "홍길동";
	private int age = 20;
	
	public void disp() {
		System.out.println(name + " -> " + age);
	}
}
