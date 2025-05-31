package ch17.unit01;

public class Ex05 {

	public static void main(String[] args) {
		// 매개변수가 2개이상이고, 리턴타입이 있는 경우
		
		// User5 obj = (a, b) -> { return a + b; };
		User5 obj = (a, b) -> a + b;
			// 실행문이 return 만 존제하는 경우 return과 {}를 생략할 수 있다.
		
		int s = obj.add(10, 5);
		System.out.println(s);
		
	}
}

interface User5 {
	public int add(int a, int b);
}
