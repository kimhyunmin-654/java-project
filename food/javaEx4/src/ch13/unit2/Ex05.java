package ch13.unit2;

import java.util.Calendar;

public class Ex05 {

	public static void main(String[] args) {
		
		ExThread1 t = new ExThread1();
		t.start();
		
		// Thread t = new Thread(new ExThread1());
		// t.start();
		
		
		
	}

}

class ExThread1 extends Thread {
	@Override
	public void run() {		
		while(true) {
			try {
				Calendar cal = Calendar.getInstance();
				String s = String.format("%tF %tT", cal,cal);
				System.out.println(s);
				
				Thread.sleep(1000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
