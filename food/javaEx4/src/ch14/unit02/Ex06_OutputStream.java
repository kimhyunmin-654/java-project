package ch14.unit02;

import java.io.OutputStream;

public class Ex06_OutputStream {

	public static void main(String[] args) {
		int data = 97;
		byte[] b = {65,66,67,68,69,70};
		
		try {
			System.out.write(data);
			System.out.println();
			// System.out.flush();
			
			OutputStream os = System.out;
			os.write(b); // byte 배열을 write 하면 flush() 하지 않아도 됨
			System.out.println();
			
			os.write(b, 2, 3); // CDE
			System.out.println();
			
			os.write(b,0,b.length); // ABCDEF
			// os.flush();
			
			os.close();
			
			System.out.println("end..."); // 출력 안됨
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
