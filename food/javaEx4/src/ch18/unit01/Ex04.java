package ch18.unit01;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Ex04 {

	public static void main(String[] args) {
		// FileSystem : 운영체제의 파일 시스템 구조와 상호작용할 수 있게 추상화
		
		try {
			FileSystem fs = FileSystems.getDefault();
			for(FileStore store : fs.getFileStores()) {
				System.err.println("드라이버명 : " + store.name());
				System.out.println("파일시스템 : " + store.type());
				System.out.println("전체공간 : " + store.getTotalSpace());
				System.out.println("사용중인공간 : " + (store.getTotalSpace() - store.getUnallocatedSpace()));
				System.out.println("사용가능공간 : " + store.getUsableSpace());
				System.out.println();
			}
			
			System.out.println("파일구분자 : " + fs.getSeparator());
			System.out.println();
			
			for(Path p : fs.getRootDirectories()) { 
				System.out.println(p.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


