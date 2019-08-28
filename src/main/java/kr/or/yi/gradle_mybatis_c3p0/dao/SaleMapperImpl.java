package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Sale;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class SaleMapperImpl implements SaleMapper {
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0.dao.SaleMapper";
	
	private static final SaleMapper instance = new SaleMapperImpl();
	
	public static SaleMapper getInstance() {
		return instance;
	}
	
	public SaleMapperImpl() {}
	
	@Override
	public List<Sale> selectSaleByAll() throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleByAll");
		}
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertSale", sale);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public List<Sale> selectSaleRank(boolean isSale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleRank", isSale);
		}
	}

}
