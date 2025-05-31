package ch14.unit03;

import java.io.PrintStream;
import java.util.Calendar;

/*
 	- PrintStream
 	  : byte 스트림
 	  : System.out 이 PrintStream 객체
 	  : 다른 출력 스트림에 기능을 추가하여 다양한 데이터의 값의 표현을 편리하게 출력 가능
 	  : 자동으로 플래시(autoFlush) 되도록 객체를 생성 할 수 있다.
 	- PrintWriter
 	  : 문자 스트림
 */

public class Ex16_PrintStream {

	public static void main(String[] args) {
		// PrintStream를 이용하여 파일 저장
		try(PrintStream ps = new PrintStream("test.txt")) {
			ps.printf("%1$tF %1$tA %1$tT", Calendar.getInstance());
			
			ps.println("\n프로그래밍");
			ps.print("자바");
			ps.print(", HTML");
			ps.println(", CSS");
			
			System.out.println("파일 저장 완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
