package kr.or.yi.gradle_mybatis_c3p0;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //이름순정렬
public class DepartmentDaoTest extends AbstractTest {
	private static DepartmentDao departmentDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		departmentDao = new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		departmentDao = null;
	}

	@Test
	public void test02SelectDepartmentbyAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Department> deptList = departmentDao.selectDepartmentbyAll();
		Assert.assertNotNull(deptList);	
		for(Department t : deptList) {
			log.debug(String.format("%d -> %s", t.getDeptCode(), t.getDeptName()));
		}		
	}
	
	@Test
	public void test01InsertDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Department insertDept = new Department(9, "우우", 12);
		int res = departmentDao.insertDepartment(insertDept); //실패하면 -1
		Assert.assertEquals(1, res); //1이면 insert 됨.
		
	}
	
	@Test
	public void test04deleteDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Department deleteDept = new Department(9);
		int res = departmentDao.deleteDepartment(deleteDept); //실패하면 -1
		Assert.assertEquals(1, res); //1이면 insert 됨.		
	}
	
	@Test
	public void test03updateDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Department updateDept = new Department(9, "우우", 12);
		int res = departmentDao.updateDepartment(updateDept); //실패하면 -1
		Assert.assertEquals(1, res); //1이면 insert 됨.	
	}
	
	@Test
	public void test05SelectDepartmentByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Department selectedDept = new Department(9);
		Department searchDept = departmentDao.selectDepartmentByCode(selectedDept);
		log.debug("searchDepartment" + searchDept);
		Assert.assertNotNull(searchDept); 
	}
	
}







