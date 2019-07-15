package kr.or.yi.gradle_mybatis_c3p0.ui;

import javax.swing.JFrame;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.service.EmployeeUIService;

public class EmployeeFrameUI extends AbstractPanel<Employee> {
	private EmployeeUIService service;
	
	public EmployeeFrameUI(String title) {
		super(title);
		setBounds(100, 100, 500, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected  void initDao() {
		service = new EmployeeUIService();
	}

	@Override
	protected void initComponents(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItem(Employee item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearComponent(int nextNo) {
		// TODO Auto-generated method stub
		
	}
	
	
}
