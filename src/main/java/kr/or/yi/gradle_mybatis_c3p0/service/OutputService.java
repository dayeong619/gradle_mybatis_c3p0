package kr.or.yi.gradle_mybatis_c3p0.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dao.SaleMapper;
import kr.or.yi.gradle_mybatis_c3p0.dao.SaleMapperImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Sale;

public class OutputService {
	private SaleMapper saleDao;

	public OutputService() {
		saleDao = new SaleMapperImpl();
	}
	
	public List<Sale> outputOrder(boolean isSale) throws SQLException{
		return saleDao.selectSaleRank(isSale);
	}
}
