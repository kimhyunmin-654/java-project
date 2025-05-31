package ch14.unit03.score;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ScoreUI {
	private Score score = new ScoreImpl();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() {
		int ch;
		
		while(true) {
			try {
				System.out.print("1.등록 2.수정 3.삭제 4.학번검색 5.전체리스트 6.종료 => ");
				ch = Integer.parseInt(br.readLine());
				
				if(ch == 6) {
					score.saveFile();
					System.exit(0);
				}
				
				switch(ch) {
				case 1: insert(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: findById(); break;
				case 5: findByAll(); break;
				}
				
								
			} catch (Exception e) {

			}
		}
	}

	public void insert() {
		System.out.println("[등록]");
		ScoreVO vo = new ScoreVO();
		
		try {
			System.out.print("학번 ? ");
			vo.setHak(br.readLine());
			
			System.out.print("이름 ? ");
			vo.setName(br.readLine());
			
			System.out.print("국어 ? ");
			vo.setKor(Integer.parseInt(br.readLine()));
			
			System.out.print("영어 ? ");
			vo.setEng(Integer.parseInt(br.readLine()));
			
			System.out.print("수학 ? ");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			score.insertScore(vo);
			
			System.out.println("데이터가 등록되었습니다. !!!");
			
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (DulicationException e) {
			System.out.println("학번 중복 에러 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
				
	}

	public void update() {
		System.out.println("[수정]");
		
		String hak;
		try {
			System.out.print("수정할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = score.findById(hak);
			if(vo == null) {
				System.out.println("등록된 학번이 아닙니다.\n");
				return;
			}
			
			System.out.print("이름 ? ");
			vo.setName(br.readLine());
			
			System.out.print("국어 ? ");
			vo.setKor(Integer.parseInt(br.readLine()));
			
			System.out.print("영어 ? ");
			vo.setEng(Integer.parseInt(br.readLine()));
			
			System.out.print("수학 ? ");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			System.out.println("데이터가 수정되었습니다. !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		System.out.println("[삭제]");
		
		String hak;
		try {
			System.out.print("삭제할 학번 ? ");
			hak = br.readLine();
			
			boolean b = score.deleteScore(hak);
			if(b) {
				System.out.println("데이터가 삭제되었습니다.");
			} else {
				System.out.println("등록된 데이터가 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void findById() {
		System.out.println("[학번검색]");
		String hak;
		
		try {
			System.out.print("검색할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = score.findById(hak);
			if(vo == null) {
				System.out.println("등록된 학번이 아닙니다.\n");
			}
			print();
			System.out.print(vo.getHak() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\n");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public void findByAll() {
		System.out.println("[전체리스트]");
		List<ScoreVO> list = score.listScore();
		
		print();
		for(ScoreVO vo : list) {
			System.out.print(vo.getHak() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\n");
		}
				
	}
	
	public void print() {
		System.out.print("학번\t");
		System.out.print("이름\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.println("수학");
	}

}
