package ch14.unit03;

import java.io.File;

public class Ex12_FileRename {

	public static void main(String[] args) {
		String appDir = System.getProperty("user.dir");
		String pathname = appDir + File.separator + "ex.txt";
		
		File f = new File(pathname);
		if( ! f.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.exit(0);
		}
		
		String newPath = appDir + File.separator + "test.txt";
			// 경로(폴더)가 다르면 파일을 이동하여 파일이름 변경
		File dest = new File(newPath);
		
		// 파일 또는 폴더이름 변경
		f.renameTo(dest);
		
		System.out.println("파일명 변경 완료 ...");
		
		
	}

}
