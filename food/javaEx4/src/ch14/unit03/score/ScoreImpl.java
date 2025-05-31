package ch14.unit03.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private final static String PATHNAME = "score.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File file = new File(PATHNAME);
		
		if(! file.exists()) {
			return;
		}
		
		// 파일의 내용을 읽어 List에 저장
		try(BufferedReader fbr = new BufferedReader(new FileReader(file))) {
			String s;
			
			while((s = fbr.readLine()) != null) {
				String[] ss = s.split(",");
				if(ss.length != 5) {
					continue;
				}
				
				ScoreVO vo = new ScoreVO();
				vo.setHak(ss[0]);
				vo.setName(ss[1]);
				vo.setKor(Integer.parseInt(ss[2]));
				vo.setEng(Integer.parseInt(ss[3]));
				vo.setMat(Integer.parseInt(ss[4]));
				
				list.add(vo);
				
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
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
		
		// List의 데이터를 파일에 저장하기
		try(PrintStream ps = new PrintStream(file)) {
			for(ScoreVO vo : list) {
				ps.print(vo.getHak() + ",");
				ps.print(vo.getName() + ",");
				ps.print(vo.getKor() + ",");
				ps.print(vo.getEng() + ",");
				ps.print(vo.getMat() + "\n");
			}
			
			System.out.println("파일 저장 완료 !!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
