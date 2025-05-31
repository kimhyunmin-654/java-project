package ch13.unit3;

public class Ex04_ThreadStop {
	public static void main(String[] args) {
		MyThread4 task = new MyThread4();
		Thread t = new Thread(task);
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		
		// t.stop(); // 권장하지 않음. 스레드가 종료되지 않음
		
		task.stopTask();
		
		System.out.println("메인 종료...");
	}
}

class MyThread4 implements Runnable {
	private boolean bTask = true;
	@Override
	public void run() {
		long n = 0;
		
		try {
			while(bTask) {
				System.out.println("스레드 -> " + (++n));
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("스레드 종료...");
	}
	
	public void stopTask() {
		this.bTask = false;
	}
	
}
