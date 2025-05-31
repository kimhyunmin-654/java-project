package db.item3.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.util.DBConn;

public class SalaryDAO {
	private Connection conn = DBConn.getConnection();
	
	public int insertSalary(SalaryDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "INSERT INTO salary(salaryNum, sabeon, payDate, paymentDate "
					+ " pay, sudang, tax, memo "
					+ "  ";
		} catch (Exception e) {

		}
		
		return result;
	}
	
	public int updateSalary(SalaryDTO dto) throws SQLException {
		int result = 0;
		
		return result;
	}

	public int deleteSalary(int salaryNum) throws SQLException {
		int result = 0;

		return result;
	}
	
	public SalaryDTO readSalary(int salaryNum) {
		SalaryDTO dto = null;
		
		return dto;
	}
	
	public List<SalaryDTO> listSalary(String payDate) {
		List<SalaryDTO> list = new ArrayList<>();
		
		return list;
	}
	
	public List<SalaryDTO> listSalary(Map<String, Object> map) {
		List<SalaryDTO> list = new ArrayList<>();
		
		return list;
	}

	public List<SalaryDTO> listSalary() {
		List<SalaryDTO> list = new ArrayList<>();
		
		return list;
	}

}
