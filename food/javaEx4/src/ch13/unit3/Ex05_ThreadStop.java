package ch13.unit3;

/*
 	- interrupt()
 	 : interrupt() 메소드를 호출하여 인터럽트를 받은 스레드가 
 	   sleep(), join(), wait() 와 같은 메소드를 호출하여 대기상태에 있으면
 	   InterruptedException 예외가 발생하여 대기상태를 빠져 나온다.
 */

public class Ex05_ThreadStop {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread5());
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		t.interrupt();
		
		System.out.println("메인 종료...");
	}

}

class MyThread5 implements Runnable {

	@Override
	public void run() {
		long n = 0;
		try {
			while(true) {
				System.out.println("스레드 : " + (++n));
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("인터럽트 됨");
		}
		
		System.out.println("스레드 종료...");
		
	}
	
}
