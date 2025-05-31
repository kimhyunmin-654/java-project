package ch14.unit04;

import java.io.PrintWriter;

public class Ex01_PrintWriter {

	public static void main(String[] args) {
		// PrintStream : byte 스트림
		// PrintWriter : 문자 스트림
		
		/*
		PrintWriter pw = new PrintWriter(System.out);
		pw.print("자바");
		pw.print("오라클");
		pw.println("웹");
		pw.flush(); // flush()나 close()를 호출해야 출력
		*/
		
		// true 옵션을 주면 flush()로 호출하거나 println()을 호출하면 출력
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.print("자바");
		pw.print("오라클");
		pw.println("웹");
	}

}
