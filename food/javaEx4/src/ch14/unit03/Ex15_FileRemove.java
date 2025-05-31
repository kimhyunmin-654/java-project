package ch14.unit03;

import java.io.File;

public class Ex15_FileRemove {

	public static void main(String[] args) {
		String pathname = "C:" + File.separator + "ex";
		
		FileManager fm = new FileManager();
		
		fm.removeDir(pathname);
		
		System.out.println("삭제 완료...");
		
	}

}

// 모든 하위 폴더 및 파일 목록도 삭제 
class FileManager {
	public boolean removeDir(String pathname) {
		
		try {
			File f = new File(pathname);
			if(f.isDirectory()) {
				removeSubDir(pathname);
			}
			
			return f.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void removeSubDir(String pathname) {
		File[] ff = new File(pathname).listFiles();
		
		try {
			if(ff.length == 0) {
				return;
			}
			
			for(File f : ff) {
				if(f.isDirectory()) {
					removeSubDir(f.getPath()); // 재귀호출
				}
				
				f.delete();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
