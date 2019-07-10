package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class TitleDaoImpl implements TitleDao {
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao.";
	@Override
	public List<Title> selectTitlebyAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+"selectTitlebyAll");
			//TitleMapper.xml에 있는 패키지명과함수명 써야함.
			
		}
	
	}

}
