package ch17.unit01;

public class Ex06 {

	public static void main(String[] args) {
		Demo6 d = new Demo6();
		d.using();
	}

}

@FunctionalInterface
interface User6 {
	public void fun();
}

class Demo6 {
	int x = 10;
	
	// 내부 클래스
	class Ex {
		int y = 20;
		
		public void sub() {
			int x = 100;
			int n = 50;
			
			// 람다식
			User6 u = () -> {
				System.out.println(this);
					// 람다식에서의 this는 익명객체가 아니라 람다식을 구현한 클래스(Demo6$Ex)
				
				System.out.println(x); // 100
				// System.out.println(this.x); // 에러
				
				System.out.println(Demo6.this.x); // 10
				
				System.out.println(y); // 20
				System.out.println(this.y); // 20
				
			};
			
			// n = 55; // 에러. 람다식에서 사용된 지역변수는 final 속성
			
			u.fun();
		}
	}
	
	// 메서드
	public void using() {
		Ex obj = new Ex();
		obj.sub();
	}
}



