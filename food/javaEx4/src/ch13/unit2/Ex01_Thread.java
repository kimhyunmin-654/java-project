package ch13.unit2;


// main은 프로그램의 시작점이지 종료점은 아니다.
// 모든 스레드가 종료되어야 프로그램이 종료된다.
public class Ex01_Thread {

	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		// t.run(); // run()을 직접 호출하면 스레드가 아님
		t.start();
		
		try {
			for(int i = 1; i<=10; i++) {
				System.out.println("main -> " + i);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main 종료 !!!");
	}

}

// 스레드 구현 방법 - 1
// 1) Thread 클래스를 상속 받아 run() 메소드를 override 한다.
// 2) Thread 클래스를 상속 받은 클래스의 객체를 생성하여 start() 메소드를 호출한다.
class MyThread1 extends Thread {
	@Override
	public void run() {
		int n = 0;
		
		try {
			while(n < 20) {
				n++;
				System.out.println(getName() + " -> " + n);
				
				sleep(200); // 지정시간(ms) 동안 스레드 실행이 일시 중지됨
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}