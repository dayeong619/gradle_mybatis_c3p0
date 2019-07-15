package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao";

	@Override
	public List<Employee> selectEmployeeByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectEmployeeByAll");
			//TitleMapper.xml에 있는 패키지명과함수명 써야함.
			
		}
	
	}

	public int insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee selectEmployeeByCode(Employee Employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
