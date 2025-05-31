package ch08.unit11;

public class Ex03 {
	public static void main(String[] args) {
		Person p = new Person("홍길동", 20);
		System.out.println(p.name() + ", " + p.age());
	}
}

/*
 - 컴팩트 생성자
 	: 생성자 매개변수 부분이 사라진 형태 
 	: 컴팩트 생성자를 이용하여 매개변수의 유효성 검사를 할 수 있다.
 	: 개발자가 명시적으로 인스턴스 필드를 초기화 하지 않아도 컴팩트 생성자의 마지막에
 		초기화 구문이 자동으로 삽입
 */

record Person(String name, int age) {
	public Person { 
		if(age < 0) {
			throw new IllegalArgumentException("나이는 0이상만 가능...");
		}
	}
}
