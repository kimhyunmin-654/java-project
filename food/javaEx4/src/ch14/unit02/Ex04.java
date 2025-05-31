package ch14.unit02;

public class Ex04 {

	public static void main(String[] args) {
		boolean run = true;
		int speed = 0;
		char key;
		
		try {
			while(run) {
				do {
					System.out.println("1.증가 2.감소 3.종료");
					System.out.print("선택 => ");
					key = (char)System.in.read();
					System.in.skip(2); // 엔터버림
				} while(key < '1' || key > '3');
				
				switch(key) {
				case '1': speed++; break;
				case '2': speed--; break;
				case '3': run = false; break;
				}
				System.out.println("speed : " + speed); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
