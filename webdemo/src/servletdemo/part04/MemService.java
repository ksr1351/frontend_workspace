package servletdemo.part04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MemService {
	MemDAO dao = null;

	public MemService() {
		dao = MemDAO.getInstance();
	}

	public List<MemDTO> getMemList() {
		Connection conn = JdbcTemplate.getConnection();
		List<MemDTO> aList = null;
		try {
			conn.setAutoCommit(false);
			aList = dao.getListMethod(conn);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}
		return aList;

	}

	public int getInsert(MemDTO dto) {
		int chk = 0;

		Connection conn = JdbcTemplate.getConnection(); // 커넥션 객체값 받아오기

		try {
			conn.setAutoCommit(false);
			chk = dao.insertMethod(conn, dto);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}

		return chk;
	}

	public int getUpdate(HashMap<String, Object> map) {// 이름은 String, 값은 Object로 받음

		int chk = 0;
		Connection conn = JdbcTemplate.getConnection(); // 커넥션 객체값 받아오기

		try {
			conn.setAutoCommit(false); //
			chk = dao.updateMethod(conn, map);
			JdbcTemplate.commit(conn);

		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}

		return chk;
	}// end getUpdate( )

	public int getDelete(int num) {
		int chk = 0;
		Connection conn = JdbcTemplate.getConnection(); // 커넥션 객체값 받아오기

		try {
			conn.setAutoCommit(false);
			chk = dao.deleteMethod(conn, num);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}

		return chk;
	}

}
