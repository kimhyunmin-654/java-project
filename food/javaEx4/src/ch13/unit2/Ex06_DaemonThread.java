package ch13.unit2;

/*
 - 독립 스레드
 	: 메인 스레드가 종료되어도 모든 독립 스레드의 작업이 완료될때 까지 
 	  프로그램은 종료되지 않는다.
 	: 메인 스레드는 프로그램의 진입점이지 종료덤은 아니다.
 -- 데몬 스레드
 	: 다른 스레드에게 도움을 주기 위한 스레드
 	: 메인 스레드가 종료되면 데몬 스레드의 작업이 완료되지 않아도 프로그램이 종료된다.
 */

public class Ex06_DaemonThread {

	public static void main(String[] args) {
		MyThread6 t1 = new MyThread6();
		MyThread6 t2 = new MyThread6();
		MyThread6 t3 = new MyThread6();
		
		t1.setDaemon(true); // 스레드를 데몬 스레드로 만듦
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join(); // 스레드가 종료될때까지 대기
			t2.join();
			t3.join();
		} catch (Exception e) {
		}
		
		
		System.out.println("main end...");
	}

}

class MyThread6 extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=20; i++) {
			System.out.println(getName() + " -> " + i);
			
			try {
				sleep(500);
			} catch (Exception e) {

			}
		}
	}
}
 