package part01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import part01.dto.EmpDTO;

public class EmployeesDAO {

	/*
	 * apache.org => iBatis => jdk1.4 이상
	 * google.com => myBatis => jdk1.5 이상
	 */
	
	public int countMethod(SqlSession sqlSession) {
		                         //namespace.id
		return sqlSession.selectOne("emp.cnt"); 
		//리턴해주는 행의 값이 한개이면 selectOne , 여러개의 레코드로 리턴해준다면 selectList
	}
	
	public List<EmpDTO> getAllListMethod(SqlSession sqlSession){
		return sqlSession.selectList("emp.list");
	}
	
	
	public List<EmpDTO> getSearchListMethod(SqlSession sqlSession, String data){
		return sqlSession.selectList("emp.searchList", data); 
		// empMapper의 searchList를 참조, 같게 해줘야함 / data는 #{data}에서 받아서 처리
	}
}
