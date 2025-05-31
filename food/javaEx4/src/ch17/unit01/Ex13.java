package ch17.unit01;

import java.util.function.BiFunction;

public class Ex13 {

	public static void main(String[] args) {
		// BiFuntion<T,U,R> : 두개의매개변수<T, U> 와 반환값(R)
		
		// 람다식
		BiFunction<String, Integer, Test3> obj = (a, b) -> new Test3(a, b);
		Test3 t = obj.apply("이자바", 20);
		t.disp();
		
		// 생성자 메서드 참조
		BiFunction<String, Integer, Test3> obj2 = Test3::new;
		Test3 t2 = obj2.apply("다자바", 19);
		t2.disp();
		
		
	}
}

class Test3 {
	private String name;
	private int age;
	
	public Test3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void disp() {
		System.out.println(name + " : " + age);
	}
	
	
}
