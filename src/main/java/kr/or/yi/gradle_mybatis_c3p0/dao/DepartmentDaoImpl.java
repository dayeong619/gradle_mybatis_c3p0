package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0_teacher.dao.DepartmentDao";
	@Override
	public List<Department> selectTitlebyAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectTitlebyAll");
			//TitleMapper.xml에 있는 패키지명과함수명 써야함.
			
		}
	
	}
	@Override
	public int insertTitle(Department dept) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertTitle", dept);
			sqlSession.commit();
			return res;
			
		}
	}
	@Override
	public int deleteTitle(Department dept) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace + ".deleteTitle", dept);
			sqlSession.commit();
			return res;
			
		}
	}
	@Override
	public int updateTitle(Department dept) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".updateTitle", dept);
			sqlSession.commit();
			return res;
		}
	}
	@Override
	public Department selectTitleByCode(Department dept) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectTitleByCode", dept);
		}
	}
	
	
	
}
