package ch18.unit02;

import java.nio.ByteBuffer;

/*
 	- Buffer
 		: 입출력을 담당할 데이터를 보관하는 역할
 		: 일정한 영역에 버퍼의 메모리를 할당하고 미리 할당된 부분에서만 입출력 처리
 	- ByteBuffer
 		: byte 버퍼
 	- 버퍼는 처음 크기를 지정하면 변경 불가
 	- 버퍼는 기본 자료형만 가능하고 레퍼런스형은 지원하지 않음
 	- 버퍼는 순차 접근을 기본으로 하고, 
 	  버퍼의 요소중 어느 위치에 접근해야하는지의 정보를 가지고 있음
 */

public class Ex01_Buffer {
	public static void printProp(ByteBuffer buffer) {
		System.out.print("포지션 : " + buffer.position());
		
		// 버퍼에 데이터를 넣을수 있는 범위
		System.out.print(", 리미트 : " + buffer.limit());
		System.out.println(", 크기 : " + buffer.capacity());
	}
	
	public static void printBuffer(ByteBuffer buffer) {
		ByteBuffer newBuffer = buffer.duplicate();
			// 버퍼를 복사하여 새로운 버퍼를 만듦
			// 포지션, 리미트, 크기 값들이 그대로 복사 됨
		printProp(newBuffer);
		
		byte x;
		newBuffer.position(0);
		newBuffer.limit(newBuffer.capacity());
		for(int idx = 0; idx < newBuffer.capacity(); idx++) {
			x = newBuffer.get();
			System.out.print("0x" + Integer.toHexString(x & 0xff) + ", ");
		}
		System.out.println("\n--------------------------------\n");
	
	}
	

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(12); // 버퍼크기지정
		printBuffer(buffer);
		
		buffer.put((byte)0x11);
		buffer.put((byte)0x12);
		printBuffer(buffer);
		
		// 바이트 배열
		byte[] b = {0x55, 0x66, 0x77, (byte)0x88};
		buffer.put(b);
		printBuffer(buffer);
		
		byte[] dst = new byte[3];
		buffer.flip(); // 현재의 포지션을 리미트로 지정하고 포지션은 0
		buffer.get(dst);
		for(int i = 0; i < dst.length; i++) {
			System.out.print("0x" + Integer.toHexString(dst[i]&0xff)+", ");
		}
		System.out.println();
		
		
	}

}
