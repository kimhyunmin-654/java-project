package ch13.unit5;

public class Ex04 {

	public static void main(String[] args) {
		ShareData2 share = new ShareData2();
		
		UpThread2 t1 = new UpThread2(share, "up");
		DownThread2 t2 = new DownThread2(share, "down");
		
		t1.start();
		t2.start();
	}

}

// 동기화 한 경우 : synchronized 메소드
class ShareData2 {
	private int num = 100;
	
	public synchronized void up(String title) {
		System.out.print(title + " : " + num);
		num++;
		System.out.println(", 증가 -> " + num);
	}
	
	public synchronized void down(String title) {
		System.out.print(title + " : " + num);
		num--;
		System.out.println(", 감소 -> " + num);
	}

}

class UpThread2 extends Thread {
	private ShareData2 share;
	private String title;
	
	public UpThread2(ShareData2 share, String title) {
		this.share = share;
		this.title = title;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				sleep(500);
				
				share.up(title);
			} catch (Exception e) {
			}
		}
	}
}

class DownThread2 extends Thread {
	private ShareData2 share;
	private String title;
	
	public DownThread2(ShareData2 share, String title) { 
		this.share = share;
		this.title = title;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				sleep(500);
				
				share.down(title);
			} catch (Exception e) {
			}
		}
	}
	
}

