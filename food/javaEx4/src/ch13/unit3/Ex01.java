package ch13.unit3;

public class Ex01 {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("A");
		MyThread1 t2 = new MyThread1("B");
		MyThread1 t3 = new MyThread1("C");
		
		// 스레드 우선순위(1~10), 기본 : 5
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class MyThread1 extends Thread {
	public MyThread1(String name) {
		super(name); // 상위 클래스 생성자 호출. 스레드 이름 지정
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(getName() + " : " + i);
			
			try {
				sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
