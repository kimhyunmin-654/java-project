package food_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConn;
import db.util.DBUtil;

public class OwnerDAO {
	private Connection conn = DBConn.getConnection();
	
	// 점주(Owner) 테이블 CRUD
	public void insertOwner(OwnerDTO dto) throws SQLException{
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO Owner(owner_id, owner_pwd, owner_name) "
					+ " VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getOwner_id());
			pstmt.setString(2, dto.getOwner_pwd());
			pstmt.setString(3, dto.getOwner_name());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = null;
			
			sql = "INSERT INTO OwnerDetail(owner_id, owner_birth, owner_tel, owner_email) "
					+ " VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getOwner_id());
			pstmt.setString(2, dto.getOwner_birth());
			pstmt.setString(3, dto.getOwner_tel());
			pstmt.setString(4, dto.getOwner_email());
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw e;
		} finally {
			DBUtil.close(pstmt);
			
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
			}
		}
		
		
	}
	
	public void updateOwner(OwnerDTO dto) throws SQLException{
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
			
			sql = "UPDATE Owner SET owner_pwd = ? "
					+ " WHERE owner_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getOwner_pwd());
			pstmt.setString(2, dto.getOwner_id());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = null;
			
			sql = "UPDATE OwnerDetail SET owner_birth = TO_DATE(?, 'YYYY-MM-DD'), owner_tel = ?, owner_email = ? "
					+ "WHERE owner_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getOwner_birth());
			pstmt.setString(2, dto.getOwner_tel());
			pstmt.setString(3, dto.getOwner_email());
			pstmt.setString(4, dto.getOwner_id());
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw e;
		} finally {
			DBUtil.close(pstmt);
			
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
			}
		}
	}
	
	public void deleteOwner(String owner_id) throws SQLException{
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
			
			sql = "DELETE FROM OwnerDetail WHERE owner_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, owner_id);
			
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			sql = "DELETE FROM Owner WHERE owner_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, owner_id);
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw e;
		} finally {
			DBUtil.close(pstmt);
			
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
			}
		}
		
	}
	
	public OwnerDTO findById(String owner_id) {
		OwnerDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "SELECT o1.owner_id, owner_pwd, owner_name, owner_birth, owner_tel, owner_email "
					+ " FROM Owner o1 "
					+ " LEFT OUTER JOIN OwnerDetail o2 ON o1.owner_id = o2.owner_id "
					+ " WHERE o1.owner_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, owner_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new OwnerDTO();
				
				dto.setOwner_id(rs.getString("owner_id"));
				dto.setOwner_pwd(rs.getString("owner_pwd"));
				dto.setOwner_name(rs.getString("owner_name"));
				dto.setOwner_birth(rs.getString("owner_birth"));
				dto.setOwner_tel(rs.getString("owner_tel"));
				dto.setOwner_email(rs.getString("owner_email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		
		return dto;
	}
	
	
	public List<OwnerDTO> listOwner(){
		List<OwnerDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "SELECT o1.owner_id, owner_pwd, owner_name, TO_CHAR(owner_birth, 'YYYY-MM-DD') owner_birth, owner_tel, owner_email "
					+ " FROM Owner o1 "
					+ " LEFT OUTER JOIN OwnerDetail o2 ON o1.owner_id = o2.owner_id ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OwnerDTO dto = new OwnerDTO();
				
				dto.setOwner_id(rs.getString("owner_id"));
				dto.setOwner_pwd(rs.getString("owner_pwd"));
				dto.setOwner_name(rs.getString("owner_name"));
				dto.setOwner_birth(rs.getString("owner_birth"));
				dto.setOwner_tel(rs.getString("owner_tel"));
				dto.setOwner_email(rs.getString("owner_email"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		
		return list;
	}
	
}