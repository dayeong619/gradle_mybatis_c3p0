package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.State;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	int insertEmployee(Employee Employee);
	int deleteEmployee(Employee Employee);
	int updateEmployee(Employee Employee);
	Employee selectEmployeeByCode(Employee Employee);
	
	Map<String, Object> getSalaryByDepartment(Map<String, Object>param); //해쉬맵으로 전달
	State getStateSalaryByDepartment(Map<String, Object>param); //스테이트로 바로전달
	
}
