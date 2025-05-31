package ch17.unit01;

public class Ex02 {
	public static void main(String[] args) {
		User2 obj = new UserImpl2();
		obj.disp();
	}

}

// 람다표현식을 사용하지 않은 경우
interface User2 {
	public void disp();
}

class UserImpl2 implements User2 {

	@Override
	public void disp() {
		System.out.println("인터페이스 구현...");
	}
	
}
