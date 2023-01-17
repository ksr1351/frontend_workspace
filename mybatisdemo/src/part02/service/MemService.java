package part02.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.SqlSessionTemplate;
import part02.dao.MemDAO;
import part02.dto.MemDTO;

public class MemService {

	private MemDAO dao;

	private SqlSessionFactory factory;

	public MemService() {
		dao = new MemDAO();
		factory = SqlSessionTemplate.setSqlSessionFactory();
	}

	public List<MemDTO> getAllListProcess() {

		SqlSession sqlSession = null;
		List<MemDTO> aList = null;

		try {
			sqlSession = factory.openSession(false);
			aList = dao.getAllListMethod(sqlSession);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return aList;

	}

	public int setInsertProcess(MemDTO dto) {
		SqlSession sqlSession = null;
		List<MemDTO> aList = null;
		int chk = 0;

		try {
			sqlSession = factory.openSession(false);
			chk = dao.setInsertMethod(sqlSession, dto);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return chk;
	}// end setInsertProcess()

	public int setUpdateProcess(MemDTO dto) {
		SqlSession sqlSession = null;
		int chk = 0;

		try {
			sqlSession = factory.openSession(false);
			chk = dao.setUpdateMethod(sqlSession, dto);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return chk;
	}// end setUpdateProcess()

	public int setDeleteProcess(int num) {
		SqlSession sqlSession = null;
		int chk = 0;

		try {
			sqlSession = factory.openSession(false);
			chk = dao.setDeleteMethod(sqlSession, num);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return chk;

	}//end setDeleteProcess()

}// end class
