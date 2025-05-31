package db.item3.employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaryUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private SalaryDAO dao = new SalaryDAO();
	private EmployeeUI emp = null;
	
	public SalaryUI(EmployeeUI emp) {
		this.emp = emp;
	}
	
	public void salaryManage() {
		int ch = 0;
		
		while(true) {
			System.out.println("\n[급여관리]");
			
			try {
				System.out.print("1.등록 2.수정 3.삭제 4.월별급여리스트 5.사번검색 6.전체급여리스트 7.사원리스트 8.메인 => ");
				ch = Integer.parseInt(br.readLine());
				
				if(ch == 8) return;
				
				switch(ch) {
				case 1: payment(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: monthList(); break;
				case 5: findBySabeon(); break;
				case 6: listAll(); break;
				case 7: emp.listAll(); break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void payment() {
		System.out.println("\n급여 등록...");
		
	}
	
	public void update() {
		System.out.println("\n급여 수정...");

	}

	public void delete() {
		System.out.println("\n급여 삭제...");
		
	}

	public void findBySabeon() {
		System.out.println("\n사번 검색...");
		
	}

	public void monthList() {
		System.out.println("\n월별 리스트...");
		
	}
	
	public void listAll() {
		System.out.println("\n급여 리스트...");
	
	}

}
