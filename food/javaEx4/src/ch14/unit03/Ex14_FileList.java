package ch14.unit03;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex14_FileList {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s;
			
			// 경로 ? C:\windows
			System.out.print("경로 ? ");
			s = br.readLine();
			
			dirList(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void dirList(String pathname) {
		File file = new File(pathname);
		File[] ff = file.listFiles(); // 경로에 존재하는 모든 파일 또는 폴더에 대한 파일 객 체 반환
		if(ff == null || ff.length == 0) {
			return;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String s;
			
			for(File f : ff) {
				s = sdf.format(new Date(f.lastModified()));
				System.out.printf("%-40s\t%s\t", f.getName(), s);
				
				if(f.isFile()) {
					System.out.println(f.length());
					
				} else if(f.isDirectory()) {
					System.out.println("[폴더]");
				} else {
					System.out.println();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


