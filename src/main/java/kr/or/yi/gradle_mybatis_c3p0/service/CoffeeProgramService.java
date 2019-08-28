package kr.or.yi.gradle_mybatis_c3p0.service;

import java.sql.SQLException;

import kr.or.yi.gradle_mybatis_c3p0.dao.ProductMapper;
import kr.or.yi.gradle_mybatis_c3p0.dao.ProductMapperImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.SaleMapper;
import kr.or.yi.gradle_mybatis_c3p0.dao.SaleMapperImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Product;
import kr.or.yi.gradle_mybatis_c3p0.dto.Sale;

public class CoffeeProgramService {
	private ProductMapper productDao;
	private SaleMapper saleDao;
	
	public CoffeeProgramService() {
		productDao = new ProductMapperImpl();
		saleDao = new SaleMapperImpl();
	}
	
	public int registerSale(Sale sale) throws SQLException{
		return saleDao.insertSale(sale);
	}
	
	public Product searchProduct(Product product) throws SQLException{
		return productDao.selectProductByCode(product);
	}
}
