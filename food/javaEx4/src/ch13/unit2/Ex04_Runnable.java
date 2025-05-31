package ch13.unit2;

public class Ex04_Runnable {

	public static void main(String[] args) {
		// 스레드 구현 - 4 : 람다식을 이용
		Thread t = new Thread( () -> {
			for(int n=1; n<=20; n++) {
				try {
					System.out.println("스레드 : " + n);
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		t.start();
		
		for(int i=1; i<=10; i++) {
			try {
				System.out.println("메인 : " + i);
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main end ...");
		
	}

}
