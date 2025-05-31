package ch13.unit4;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Ex02_Timer {

	public static void main(String[] args) {
		MyScheduler t = new MyScheduler();
		t.start();
	}

}

class MyScheduler extends Thread {
	private long num = 0L;
	
	public MyScheduler() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				num = 0;
			}
		};
		
		// 바로 실행하여 20초마다 반복
		/*
		Timer timer = new Timer();
		Calendar cal = Calendar.getInstance();
		timer.schedule(task, cal.getTime(), 20000);
		*/
		
		// 다음날 0시0분0초에 시작하여 하루에 한번씩 실행
		Timer timer = new Timer();
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.DATE, 1);
		//cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		timer.schedule(task, cal.getTime(), 1000*60*60*24);
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("num : " + (++num));
				sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
