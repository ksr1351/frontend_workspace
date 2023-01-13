package servletdemo.part04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemDAO {

	private MemDAO() {
	}

	private static MemDAO dao = new MemDAO();

	public static MemDAO getInstance() {
		return dao;
	}

	public List<MemDTO> getListMethod(Connection conn) {
		List<MemDTO> aList = new ArrayList<MemDTO>();
		Statement stmt = null; // 속도 및 간결함은 Statement 사용
		ResultSet rs = null;
		try {

			stmt = conn.createStatement();

			String sql = "SELECT * FROM mem ORDER BY NUM DESC";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}

		return aList;
	}// end getListMethod()

	public int insertMethod(Connection conn, MemDTO dto) {
		PreparedStatement pstmt = null; // 변수가 들어가기 때문에 prepared
		int chk = 0;

		try {
			String sql = "INSERT INTO mem(num, name, age, loc) VALUES(mem_num_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());

			// chk에는 insert한 갯수가 리턴됨
			chk = pstmt.executeUpdate(); // 쿼리문이 insert,update,delete 일 때는 executeUpdate

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}

		return chk;

	}// end insertMethod()

	public int updateMethod(Connection conn, HashMap<String, Object> map) {
		System.out.printf("%s, %s, %s, %s\n", map.get("num").toString(), map.get("name").toString(),
				map.get("age").toString(), map.get("loc").toString());
		int chk = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE mem SET name=?, age=?, loc=?,WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("name").toString());
			pstmt.setInt(2, Integer.parseInt(map.get("age").toString()));
			pstmt.setString(3, map.get("loc").toString());
			pstmt.setInt(4, Integer.parseInt(map.get("num").toString()));

			chk = pstmt.executeUpdate();
			JdbcTemplate.commit(conn);

		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(pstmt);
		}
		return chk;

	}// end updateMethod()

	public int deleteMethod(Connection conn, int num) {
		int chk = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM mem WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			chk = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);

		}

		return chk;
	}//end deleteMethod()

}// end class
