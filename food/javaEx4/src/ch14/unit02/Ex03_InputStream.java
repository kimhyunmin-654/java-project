package ch14.unit02;

public class Ex03_InputStream {

	public static void main(String[] args) {
		int data;
		
		try {
			System.out.println("ABCDEF 입력후 엔터...");
		
			data = System.in.read(); // 65
			System.out.write(data); // 하위 1byte를 버퍼에 출력. A 
			
			System.in.skip(2); // 2byte 버림 : BC 버림
			
			data = System.in.read(); // 68
			System.out.write(data); // D
			
			System.in.skip(4); // EF엔터 버림
			
			System.out.flush(); // 버퍼의 내용을 출력 장치로 보냄 
			// System.out.write(10); // 버퍼의 내용을 출력 장치로 보냄
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
