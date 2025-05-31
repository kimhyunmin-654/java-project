package db.item4.member;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConn;
import db.util.DBUtil;
import oracle.jdbc.internal.OracleTypes;

// PreparedStatement를 이용하여 db에 INSERT, UPDATE, DELETE, SELECT
/*
- 하나의 테이블에 추가
   INSERT INTO 테이블명(컬럼명, 컬럼명) VALUES (값, 값)
- 두개의 테이블에 추가
   INSERT ALL
     INTO 테이블명(컬럼명, 컬럼명) VALUES (값, 값)
     INTO 테이블명(컬럼명, 컬럼명) VALUES (값, 값)
     SELECT * FROM dual 
*/
public class MemberDAOImpl implements MemberDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertMember(MemberDTO dto) throws SQLException {
		int result = 0;
		CallableStatement cstmt = null;
		String sql;

		try {
			sql = " CALL insertMember(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getId());
			cstmt.setString(2, dto.getName());
			cstmt.setString(3, dto.getPwd());
			cstmt.setString(4, dto.getBirth());
			cstmt.setString(5, dto.getEmail());
			cstmt.setString(6, dto.getTel());

			cstmt.executeUpdate();
						
			
			result = 1;

/*
			sql = "INSERT ALL INTO member1(id,pwd,name) VALUES(?,?,?) "
			       + " INTO member2(id,birth,email,tel) VALUES(?,TO_DATE(?, 'YYYY-MM-DD'),?,?) ";
			       + " SELECT * FROM dual";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getTel());
			result=pstmt.executeUpdate();
 */
		} catch (SQLException e) {
			// e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(cstmt);
		}

		return result;
	}

	@Override
	public int updateMember(MemberDTO dto) throws SQLException {
		int result = 0;
		CallableStatement cstmt = null;
		String sql;

		
		try {
			sql = " CALL updateMember(?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, dto.getId());
			cstmt.setString(2, dto.getPwd());
			cstmt.setString(3, dto.getBirth());
			cstmt.setString(4, dto.getEmail());
			cstmt.setString(5, dto.getTel());

			cstmt.executeUpdate();
			
			result = 1;
			

			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(cstmt);
		}

		return result;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		int result = 0;
		CallableStatement cstmt = null;
		String sql;

		// DELETE FROM 테이블명 WHERE 조건
		
		// id 조건에 맞는 member1 테이블과 member2 테이블 데이터 삭제
		try {
			sql = " CALL deleteScore(?)";

			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, id);

			cstmt.executeUpdate();
			
			result = 1;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(cstmt);
		}

		return result;
	}

	@Override
	public MemberDTO findById(String id) {
		MemberDTO dto = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		/*
		  - 하나의 테이블
		    SELECT 컬럼, 컬럼 FROM 테이블 WHERE 조건
		  - EQUI 조인
		    SELECT 테이블1.컬럼, 테이블1.컬럼, 테이블2.컬럼
            FROM 테이블1
            JOIN 테이블2 ON 테이블1.컬럼 = 테이블2.컬럼
            WHERE 조건
		  - LEFT OUTER JOIN 조인
		    SELECT 테이블1.컬럼, 테이블1.컬럼, 테이블2.컬럼
            FROM 테이블1
            LEFT OUTER JOIN 테이블2 ON 테이블1.컬럼 = 테이블2.컬럼
            WHERE 조건
		 */
		
		// id 조건에 맞는 member1 테이블과 member2 테이블에 데이터를 OUTER JOIN 해서 아이디 검색
		try {
			sql = " CALL findById(?, ?) ";

			cstmt = conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.setString(2, id);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);
			
			if (rs.next()) {
				dto = new MemberDTO();

				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(cstmt);
		}

		return dto;
	}

	@Override
	public List<MemberDTO> listMember() {
		List<MemberDTO> list = new ArrayList<>();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		// member1과 member2를 id를 기준으로 LEFT OUTER JOIN 하여 전체 레코드 반환
		
		try {
			sql = " CALL findByAll(?) ";

			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);

			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();

				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getDate("birth") == null ? "" : rs.getDate("birth").toString());
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(cstmt);
		}

		return list;
	}

	@Override
	public List<MemberDTO> listMember(String name) {
		List<MemberDTO> list = new ArrayList<>();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		// member1 테이블과 member2 테이블의 전체 데이터를 OUTER JOIN 해서 이름 검색
		
		try {
			sql = " CALL findByName(?, ?)";

			cstmt = conn.prepareCall(sql);

			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.setString(2, name);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();

				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(cstmt);
		}

		return list;
	}

}
