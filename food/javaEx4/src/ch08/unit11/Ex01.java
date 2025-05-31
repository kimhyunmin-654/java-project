package ch08.unit11;

public class Ex01 {

	public static void main(String[] args) {
		Test t = new Test(10,5);
		System.out.println(t.getX() + "," + t.getY());
		
		Test t2 = new Test(10, 5);
		System.out.println(t.equals(t2)); // false
	}

}

/*
  - 상태(x, y)를 보유하는 불변의 객체 만들기
   : 모든 필드는 final 로 정의
   : 모든 필드값을 포함한 생성자
   : 모든 필드에 대한 getter 작성
   : 상속을 방지하기 위해 클래스를 final로 작성
   : 로깅을 출력하기 위한 toString() 재정의
   : 두개의 인스턴스를 비교하기 위해 hashCode(), equals() 재정의
 */

final class Test {
	private final int x;
	private final int y;
	
	public Test(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
