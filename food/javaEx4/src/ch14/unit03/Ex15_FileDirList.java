package ch14.unit03;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Ex15_FileDirList {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		try {
			System.out.print("경로 ? ");
			s = br.readLine();
			
			List<DirectoryVO> list = dirList(s);
			if(list == null) {
				System.exit(0);
			}
			
			Comparator<DirectoryVO> comp = new Comparator<DirectoryVO>() {
				
				@Override
				public int compare(DirectoryVO o1, DirectoryVO o2) {
					// return o1.getType() - o2.getType();
					if(o1.getType() != o2.getType()) {
						return o1.getType() - o2.getType(); // 폴더 먼저 출력
					} else {
						return -o1.getModified().compareTo(o2.getModified()); // 오름차순
					}
				}				
			};
			Collections.sort(list, comp);
				
				
			
			for(DirectoryVO vo : list) {
				System.out.printf("%-40s\t%s\t", vo.getName(), vo.getModified());
				if(vo.getType() == 1) {
					System.out.println(vo.getLength());
				} else {
					System.out.println("[폴더]");
				}
			}
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<DirectoryVO> dirList(String pathname) {
		List<DirectoryVO> list = new ArrayList<DirectoryVO>();
		File file = new  File(pathname);
		File[] ff = file.listFiles();
		
		if(ff == null) {
			return list;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s;
		
		for(File f : ff) {
			s = sdf.format(new Date(f.lastModified()));
			
			DirectoryVO vo = new DirectoryVO();
			vo.setName(f.getName());
			vo.setModified(s);
			
			if(f.isFile()) {
				vo.setType(1);
				vo.setLength(f.length());
				list.add(vo);
			} else if(f.isDirectory()) {
				vo.setType(0);
				list.add(vo);
			}
		}
		return list;
				
	}

}

class DirectoryVO {
	private String name; // 파일 또는 폴더명
	private String modified; // 수정일자
	private int type; // 0:폴더, 1:파일
	private long length; // 파일길이
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	
}
