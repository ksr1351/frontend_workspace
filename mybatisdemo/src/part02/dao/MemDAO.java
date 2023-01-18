package part02.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import part02.dto.MemDTO;

public class MemDAO {

	public List<MemDTO> getAllListMethod(SqlSession sqlSession) {
		return sqlSession.selectList("mem.list");
	}

	public int setInsertMethod(SqlSession sqlSession, MemDTO dto) {
		return sqlSession.insert("mem.memInsert", dto);
	}

	public int setUpdateMethod(SqlSession sqlSession, MemDTO dto) {
		return sqlSession.update("mem.memUpdate", dto);
	}

	public int setDeleteMethod(SqlSession sqlSession, int num) {
		return sqlSession.delete("mem.memDelete", num);
	}

	///////////////////////////////////////////////////////////////////////
	
	public int getKeyNumMethod(SqlSession sqlSession) {
		return sqlSession.selectOne("mem.keyNum");
	}
	
	public int setInsertListMethod(SqlSession sqlSession, List<MemDTO> memList) {
		return sqlSession.insert("mem.multiIns", memList);
	}
	
	public int setDeleteArrayMethod(SqlSession sqlSession, int[] num) {
		return sqlSession.delete("mem.multiDel",num);
	}
	
	public List<MemDTO> getPartSearchMethod(SqlSession sqlSession, MemDTO dto){
		return sqlSession.selectList("mem.partSearch", dto);
	}
	
	public int setUpdateMultiMethod(SqlSession sqlSession, MemDTO dto) {
		return sqlSession.update("mem.multiUpt", dto);
	}
	
	public int setInsertDataMethod(SqlSession sqlSession, MemDTO dto) {
		return sqlSession.insert("mem.insData", dto);
	}
	
	
	
	
	
	
	
	
	
}// end class
