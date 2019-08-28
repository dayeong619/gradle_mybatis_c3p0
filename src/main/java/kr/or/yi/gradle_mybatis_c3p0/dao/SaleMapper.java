package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Sale;

public interface SaleMapper {
	
	List<Sale> selectSaleByAll() throws SQLException;
	int insertSale(Sale sale) throws SQLException;
	List<Sale> selectSaleRank(boolean isSale) throws SQLException;
}
