package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.ui.content.AbstractPanel;

public class EmployeeFrameUI extends AbstractPanel<Employee> {

	
	public EmployeeFrameUI(String title) {
		super(title);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
