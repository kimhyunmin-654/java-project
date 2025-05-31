package ch14.unit04;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Ex03_DataOutputStream {

	public static void main(String[] args) {
		String pathname = "demo.txt";
		
		// 기본자료형 자료 출력 가능
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathname))) {
			dos.writeUTF("자바");
			dos.writeByte(10);
			dos.writeChar('A');
			dos.writeInt(50);
			dos.writeUTF("서울");
			
			System.out.println("파일 저장 완료..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
