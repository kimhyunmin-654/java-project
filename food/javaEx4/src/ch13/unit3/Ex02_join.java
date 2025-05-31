package ch13.unit3;

public class Ex02_join {

	public static void main(String[] args) {
		MyThread2 t = new MyThread2();
		
		System.out.println("start 전 - Alive : " + t.isAlive());
		t.start();
		
		
		System.out.println("start 후 - Alive : " + t.isAlive());
		
		try {
			// t.join(500); // 지정시간 동안 대기
			t.join(); // 스레드가 종료될때 까지 대기
		} catch (Exception e) {
		}
		
		System.out.println("Alive : " + t.isAlive());
		
		System.out.println("main end...");
	}

}

class MyThread2 extends Thread {
	@Override
	public void run() {
		try {
			for(int i=1; i<=10; i++) {
				System.out.println(getName() + " -> " + i);
				sleep(100);
			}
		} catch (Exception e) {

		}
	}
}