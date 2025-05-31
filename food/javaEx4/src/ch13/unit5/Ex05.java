package ch13.unit5;


public class Ex05 {
	public static void main(String[] args) {
		MyBank5 task = new MyBank5();
		
		Thread t1 = new Thread(task, "T1");
		Thread t2 = new Thread(task, "T2");
		
		t1.start();
		t2.start();
	}
}

class MyBank5 implements Runnable {
	private long money = 10000;

	@Override
	public void run() {
		synchronized (this) { // 현재 객체를 동기화
			for(int i=0; i<10; i++) {
				if(getMoney() <= 0) {
					this.notifyAll();
					break;
				}
				
				drawMoney(1000);
				
				if(getMoney() >= 2000 && getMoney() % 2000 == 0) {
					try {
						this.wait();
							// 해당 스레드는 대기. 동기화 블럭에서만 가능
					} catch (Exception e) {
					}
				} else {
					this.notify(); // wait() 에 의해 대기하고 있는 쓰레드를 깨움
				}
			}
		}
	}
	
	public long getMoney() {
		return money;
	}
	
	public void drawMoney(long m) {
		System.out.print(Thread.currentThread().getName() + ", "); // 현재 스레드명
		
		if(getMoney() >= m) {
			money -= m;
			System.out.println("잔액:" + getMoney());
		} else {
			System.out.println("잔액이 부족합니다.");
		}
	}
}
