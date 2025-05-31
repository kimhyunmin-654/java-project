package ch13.unit2;

public class Ex03_Runnable {

	public static void main(String[] args) {
		// 스레드 구현 - 3 : 익명 클래스
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					for(int n = 1; n<=20; n++) {
						System.out.println("스레드 -> " + n);
						Thread.sleep(200);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		t.start();
		
		try {
			for(int i=1; i<=10; i++) {
				System.err.println("메인 -> " + i);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 종료 !!!");
	}

}
