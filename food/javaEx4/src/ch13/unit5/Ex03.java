package ch13.unit5;

public class Ex03 {
	public static void main(String[] args) {
		ShareData1 share = new ShareData1();
		
		UpThread1 t1 = new UpThread1(share, "up");
		DownThread1 t2 = new DownThread1(share, "down");
		
		t1.start();
		t2.start();
	}

}

// 동기화 하지 않은 경우
class ShareData1 {
	private int num = 100;
	
	public void up(String title) {
		System.out.print(title + " : " + num);
		num++;
		System.out.println(", 증가 -> " + num);
	}
	
	public void down(String title) {
		System.out.print(title + " : " + num);
		num--;
		System.out.println(", 감소 -> " + num);
	}

}

class UpThread1 extends Thread {
	private ShareData1 share;
	private String title;
	
	public UpThread1(ShareData1 share, String title) {
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

class DownThread1 extends Thread {
	private ShareData1 share;
	private String title;
	
	public DownThread1(ShareData1 share, String title) { 
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

