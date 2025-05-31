package ch08.unit11;

public class Ex_record {

	public static void main(String[] args) {
		Point p = new Point(10,5);
		System.out.println(p.x() + ", " + p.y());
		
		Point p2 = new Point(10,5);
		System.out.println(p.equals(p2)); // true
	}

}

/*
  - 상태(x,y)를 보유하는 불변의 객체 만들기
  	: 컴파일러는 헤더를 통해 내부 필드를 추론. 아래의 필드를 자동으로 만듬
  	  private final int x;
  	  private final int y;
  	: 모든 필드를 초기화 하는 RequiredAllArgument 생성자가 자동으로 만들어짐
  	  public Point(int x, int y) {
  	  	this.x = x;
  	  	this.y = y;
  	  }
  	: toString, equals, hashCode 메서드에 대한 구현을 자동으로 제공
 */

record Point(int x, int y) {}
