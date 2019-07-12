package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.ui.content.PanelDepartment;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList;

@SuppressWarnings("serial")
public class DepartmentFrameUI extends JFrame implements ActionListener {
	private JButton btnAdd;
	private PanelDepartment pContent;
	private List<Department> deptList;
	private DepartmentList pList;
	private JButton btnCancel;
	private DepartmentDao dao;
	
	public DepartmentFrameUI() {
		dao = new DepartmentDaoImpl();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책관리");
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = new PanelDepartment("부서");
		
		
		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = new DepartmentList("부서");
		
		deptList =  dao.selectDepartmentbyAll();
		pList.setItemList(deptList);
		pList.reloadData();
		
		getContentPane().add(pList, BorderLayout.SOUTH);
		
		pContent.clearComponent(deptList.size() == 0 ? 1 : deptList.size() + 1);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			}
			if(e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate(e);
			}
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department insertDepartment = pContent.getItem();
		int res = dao.insertDepartment(insertDepartment);
		
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
	}
	
}