package db.member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConn;
import db.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn = DBConn.getConnection();
	
	
	
	// Insert ALL로도 가능
	@Override
	public int insertMember(MemberDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO member1(id, pwd, name) "
					+ " VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			sql = "INSERT INTO member2(id, birth, email, tel) "
					+ " VALUES(?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getTel());
			
			result += pstmt.executeUpdate();
			
			conn.commit();
									
			
		} catch (SQLException e) {
			DBUtil.rollback(conn); // 롤백
			
			//e.printStackTrace();
			throw e;
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
			}
			
			DBUtil.close(pstmt);
		}
		
		return result;
	}

	@Override
	public int updateMemeber(MemberDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
		
			
			sql = "UPDATE member1 SET pwd = ?, name = ? "
					+ " WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getId());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
	
			sql = "UPDATE member2 SET birth = TO_DATE(?, 'YYYY-MM-DD'), email = ?, tel = ? "
					+ " WHERE id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBirth());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getId());
			
			result += pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			DBUtil.rollback(conn);
			
			throw e;
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
			}
			DBUtil.close(pstmt);
		}
				
		return result;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "DELETE FROM member2 WHERE id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			
			sql = "DELETE FROM member1 WHERE id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			result += pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtil.close(pstmt);
		}
		
		return result;
	}

	@Override
	public MemberDTO findById(String id) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		// LEFT OUTER JOIN 도 가능
		try {
			sql = "SELECT m.id, name, pwd, TO_CHAR(birth, 'YYYY-MM-DD') birth, "
				+ " email, tel "
				+ " FROM member1 m "
				+ " JOIN member2 mm ON m.id = mm.id "
				+ " WHERE m.id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
				
		return dto;
	}

	@Override
	public List<MemberDTO> listMember() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "SELECT m.id, name, pwd, birth, email, tel "
					+ " FROM member1 m "
					+ " JOIN member2 mm ON m.id = mm.id "
					+ " ORDER BY id";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(); 
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setBirth(rs.getDate("birth").toString());
// dto.setBirth(rs.getDate("birth") == NULL ? "" : rs.getDate("birth").toString());
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		
		
		return list;
	}

	@Override
	public List<MemberDTO> listMember(String name) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "SELECT m.id, name, pwd, TO_CHAR(birth, 'YYYY-MM-DD') birth,"
					+ " email, tel "
					+ " FROM member1 m "
					+ " JOIN member2 mm ON m.id = mm.id "
					+ " WHERE INSTR(name, ?) >= 1";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				
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
