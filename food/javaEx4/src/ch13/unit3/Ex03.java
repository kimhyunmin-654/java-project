package ch13.unit3;

import java.util.concurrent.TimeUnit;

public class Ex03 {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			
			TimeUnit.SECONDS.sleep(1L); // 1s
			TimeUnit.MILLISECONDS.sleep(1000L); // 1000ms -> 1s
			TimeUnit.MICROSECONDS.sleep(1000000L); // 1s
			TimeUnit.NANOSECONDS.sleep(1000000000L); // 1s
			
			long end = System.currentTimeMillis();
			System.out.println("sleep : " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
