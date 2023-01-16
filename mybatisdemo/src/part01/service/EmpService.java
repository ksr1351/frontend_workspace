package part01.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.SqlSessionTemplate;
import part01.dao.EmployeesDAO;
import part01.dto.EmpDTO;

public class EmpService {

	private EmployeesDAO dao;
	// private SqlSession sqlSession;
	private SqlSessionFactory factory;

	public EmpService() {
		dao = new EmployeesDAO();
		factory = SqlSessionTemplate.setSqlSessionFactory();

	}

	public int countProcess() {
		int chk = 0;
		SqlSession sqlSession = null;
		try {
			// sqlSession = SqlSessionTemplate.getSqlSession();
			sqlSession = factory.openSession(false); // true쓰면 자동 commit(commit과 rollback필요없음)
			chk = dao.countMethod(sqlSession);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();// 연결종료
		}
		return chk;
	}// end countProcess()

	public List<EmpDTO> getAllListProcess() {
		List<EmpDTO> aList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession(false);
			aList = dao.getAllListMethod(sqlSession);
			sqlSession.commit();
		} catch (Exception ex) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();// 연결종료
		}
		return aList;
	}// end getAllListProcess()

	public List<EmpDTO> getSearchListProcess(String data) {
		List<EmpDTO> aList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession(false);
			aList = dao.getSearchListMethod(sqlSession, data);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();// 연결종료
		}
		return aList;
	}// end getSearchListProcess()

}// end class
