package ch18.unit02;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class Ex02_Int {

	public static void main(String[] args) {
		// int[] -> IntBuffer -> ByteByffer
		int[] ii = {10, 20};
		IntBuffer ib = IntBuffer.wrap(ii);
		ByteBuffer bb = ByteBuffer.allocate(ib.capacity() * 4);
		for(int i = 0; i < ib.capacity(); i++) {
			bb.putInt(ib.get(i));
		}
		bb.flip();
		
		// ByteBuffer -> IntBuffer -> int[]
		ByteBuffer bb2 = bb;
		IntBuffer ib2 = bb2.asIntBuffer();
		int[] ii2 = new int[ib2.capacity()];
		ib2.get(ii2);
		System.out.println("복원배열 : " + Arrays.toString(ii2));
	}

}
