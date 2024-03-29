package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class TitleDaoImpl implements TitleDao {
	private static final String namespace = "mapper.titleMapper";
	@Override
	public List<Title> selectTitlebyAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectTitlebyAll");
			//TitleMapper.xml에 있는 패키지명과함수명 써야함.
			
		}
	
	}
	@Override
	public int insertTitle(Title title) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertTitle", title);
			sqlSession.commit();
			return res;
			
		}
	}
	@Override
	public int deleteTitle(Title title) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace + ".deleteTitle", title);
			sqlSession.commit();
			return res;
			
		}
	}
	@Override
	public int updateTitle(Title title) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".updateTitle", title);
			sqlSession.commit();
			return res;
		}
	}
	@Override
	public Title selectTitleByCode(Title title) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectTitleByCode", title);
		}
	}
	
	
	
}
