package ch14.unit04;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04_DataInputStream {

	public static void main(String[] args) {
		String pathname = "demo.txt";
		
		// 더이상 읽을 데이터가 없으면 EOFException이 발생
		// 저장된 타입과 일치하게 일거와야 한다.
		try(DataInputStream dis = new DataInputStream(new FileInputStream(pathname))) {
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
