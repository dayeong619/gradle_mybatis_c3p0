package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class DepartmentDaoImpl implements DepartmentDao {
//	private static final String namespace = "mappers.DepartmentMapper";
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0_teacher.dao.DepartmentDao";

	@Override
	public List<Department> selectDepartmentbyAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectDepartmentByAll");
		}
	}

	@Override
	public int insertDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Department selectDepartmentByCode(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectDepartmentByCode", department);
		}
	}

}
