package ch14.unit04.score;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private final static String PATHNAME = "sung.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File file = new File(PATHNAME);
		
		if(! file.exists()) {
			return;
		}
		
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(file));
			
			while(true) {
				ScoreVO vo = new ScoreVO();
				vo.setHak(dis.readUTF());
				vo.setName(dis.readUTF());
				vo.setKor(dis.readInt());
				vo.setEng(dis.readInt());
				vo.setMat(dis.readInt());
				
				list.add(vo);
			}
			
			
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (EOFException e) {
			// DataInputStream은 더이상 읽을 데이터가 없으면 EOFException 예외발생
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(dis != null) { 
				try {
					dis.close();
				} catch (Exception e2) {
				}
			}
				
		}
		
		
		
	}
	
	@Override
	public void insertScore(ScoreVO vo) throws DulicationException {
		if(findById(vo.getHak()) != null) {
			throw new DulicationException("학번 중복 오류 !!!");
		}
		
		list.add(vo);
	}

	@Override
	public boolean deleteScore(String hak) {
		// ScoreVO vo = findById(hak);
		// return list.remove(vo);
		return list.remove(findById(hak));
	}

	@Override
	public List<ScoreVO> listScore() {
		return list;
	}

	@Override
	public ScoreVO findById(String hak) {
		for(ScoreVO vo : list) {
			if(vo.getHak().equals(hak)) {
				return vo;
			}
		}
		return null;
	}

	@Override
	public void saveFile() {
		File file = new File(PATHNAME);
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
			for(ScoreVO vo : list) {
				dos.writeUTF(vo.getHak());
				dos.writeUTF(vo.getName());
				dos.writeInt(vo.getKor());
				dos.writeInt(vo.getEng());
				dos.writeInt(vo.getMat());
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
