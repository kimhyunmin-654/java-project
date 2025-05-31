package ch14.unit02;

import java.io.OutputStream;

public class Ex05_OutputStream {

	public static void main(String[] args) {
		try {
			OutputStream os = System.out;
			
			os.write(65); // 하위 1byte를 출력 버퍼로 보냄
			os.write(66);
			os.write(67);
			
			// 출력 장치로 보내기-1
			// os.flush();
			
			// 출력 장치로 보내기-2
			// os.write(10);
			
			// 출력 장치로 보내기-3
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
