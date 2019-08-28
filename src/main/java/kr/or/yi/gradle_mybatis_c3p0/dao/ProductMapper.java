package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Product;

public interface ProductMapper {
	
	public abstract List<Product> selectProductByAll() throws SQLException;
	Product selectProductByCode(Product product) throws SQLException;
}
