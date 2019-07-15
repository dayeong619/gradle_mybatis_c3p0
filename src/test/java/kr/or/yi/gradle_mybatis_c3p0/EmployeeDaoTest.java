package kr.or.yi.gradle_mybatis_c3p0;

import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest extends AbstractTest {
	private static EmployeeDao empDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empDao = new EmployeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empDao = null;
	}
	
	@Test
	public void test01SelectEmployeeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Employee> empList = empDao.selectEmployeeByAll();
		Assert.assertNotNull(empList);
		
		for(Employee e : empList) {
			log.debug(e.toString());
		}
	}
	
	@Test
	public void test02UpdateEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Calendar join = Calendar.getInstance();
		join.clear();
		join.set(Calendar.YEAR, 2016);
		join.set(Calendar.MONTH, 5);
		join.set(Calendar.SOUTH,);
		
		Employoee emp = new Employee();
			Employee 
			int res - empDao.updateEmployee();
		
		Employee emp = new Employee(1003, "조민희", 3000000, 2, false, 2016-06-01, new Title(3));
	}
	
	@Test
	public void test04insertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Employee insertDept = new Employee();
		int res = empDao.insertEmployee(insertDept); //실패하면 -1
		Assert.assertEquals(1, res); //1이면 insert 됨.
	}
	
	@Test
	public void test05deleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Employee deleteDept = new Employee();
		int res = empDao.deleteEmployee(deleteDept); //실패하면 -1
		Assert.assertEquals(1, res); //1이면 insert 됨.	
	}
}
