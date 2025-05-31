package ch15.unit01.score;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private final static String PATHNAME = "sung2.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File file = new File(PATHNAME);
		
		if(! file.exists()) {
			return;
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			while(true) {
				ScoreVO vo = (ScoreVO)ois.readObject();
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			
		} catch (EOFException e) {
			// 더 이상 읽을 데이터가 없는 경우
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			for(ScoreVO vo : list) {
				oos.writeObject(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
