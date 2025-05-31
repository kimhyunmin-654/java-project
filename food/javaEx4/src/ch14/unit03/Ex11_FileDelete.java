package ch14.unit03;

import java.io.File;

public class Ex11_FileDelete {

	public static void main(String[] args) {
		String appDir = System.getProperty("user.dir");
		String pathname = appDir + File.separator + "test.txt";
		
		File f = new File(pathname);
		
		// 파일이나 폴더 삭제.
		// 폴더는 비어 있는 경우만 삭제 가능. 한번에 하나씩 삭제 가능
		boolean b = f.delete();
		if(b) {
			System.out.println("파일 삭제 완료...");
		} else {
			System.out.println("파일 삭제 불가..");
		} 
		
		
	}

}
