package ch13.unit5;

public class Ex02 {

	public static void main(String[] args) {
		MyBank2 task = new MyBank2();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
	}

}

// 동기화 한 경우 
class MyBank2 implements Runnable {
	private long money = 10000;

	@Override
	public void run() {
		long need = 6000;
		long n = 0;
		String msg = null;
		
		try {
			synchronized (this) { // 동기화 블럭
				if(getMoney() >= need) {
					Thread.sleep(200);
					
					n = drawMoney(need);
					msg = "인출 성공";
				} else {
					n = 0;
					msg = "인출 실패";
				}
			}
			
			System.out.println(msg + ", 인출금액:" + n + ",잔고:" + getMoney());
			
		} catch (Exception e) {

		}
	}
	
	public long getMoney() {
		return money;
	}
	
	private long drawMoney(long m) {
		money -= m;
		return m;
	}
	
}
