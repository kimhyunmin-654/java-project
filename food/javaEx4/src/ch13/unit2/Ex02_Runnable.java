package ch13.unit2;

public class Ex02_Runnable {

	public static void main(String[] args) {
		MyThread2 th = new MyThread2();
		Thread t = new Thread(th);
		
		t.start();
		
		try {
			for(int i=1; i<=10; i++) {
				System.out.println("main->" + i);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main종료 !!!");
	}
	

}

// - 스레드 구현 - 2
// 	 1) Runnable 인터페이스 구현 클래스를 만들어 run() 메소드를 override 한다.
//	 2) Runnable 인터페이스 구현 클래스의 객체를 생성한다.
//	 3) Thread 클래스의 객체를 생성하며, Thread 클래스 객체를 생성할때 생성자의 인자에 
//		2) 번에서 생성한 객체를 전달한다.
//	 4) Thread 클래스의 객체의 start() 메소드를 호출한다.
class MyThread2 implements Runnable {

	@Override
	public void run() {
		int n = 0;
		
		try {
			while(n < 20) {
				n++;
				System.out.println(Thread.currentThread().getName() + " -> " + n);
				Thread.sleep(200); // 지정시간(ms) 동안 스레드 실행이 일시 중지됨
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
