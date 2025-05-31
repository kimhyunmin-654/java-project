package ch14.unit03.score;

import java.util.List;

public interface Score {
	public void insertScore(ScoreVO vo) throws DulicationException;
	public boolean deleteScore(String hak);
	public List<ScoreVO> listScore();
	public ScoreVO findById(String hak);
	public void saveFile();
	
	
}
