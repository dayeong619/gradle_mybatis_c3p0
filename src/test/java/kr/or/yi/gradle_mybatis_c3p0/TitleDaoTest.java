package kr.or.yi.gradle_mybatis_c3p0;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //이름순정렬
public class TitleDaoTest extends AbstractTest {
	private static TitleDao titleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		titleDao = new TitleDaoImpl();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		titleDao = null;
	}

	@Test
	public void testSelectTitleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Title> titleList = titleDao.selectTitlebyAll();
		Assert.assertNotNull(titleList);
		
		for(Title t : titleList) {
			log.debug(String.format("%d -> %s", t.getTitleNo(), t.getTitleName()));
		}
		
	}

}







