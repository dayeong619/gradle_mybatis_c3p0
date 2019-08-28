package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Product;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class ProductMapperImpl implements ProductMapper {
	private static final String namespace = "kr.or.yi.gradle_mybatis_c3p0.dao.ProductMapper";
	
	private static final ProductMapper instance = new ProductMapperImpl();

	public static ProductMapper getInstance() {
		return instance;
	}
	
	public ProductMapperImpl() {}
	
	@Override
	public List<Product> selectProductByAll() throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectProductByAll");
		}
	}

	@Override
	public Product selectProductByCode(Product product) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectProductByCode", product);
		}
	}

}
