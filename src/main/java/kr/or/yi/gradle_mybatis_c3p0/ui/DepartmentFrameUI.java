package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
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
	private JPopupMenu popupMenu_1;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private DepartmentDao dao;
	
	public DepartmentFrameUI() {
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
		
		deptList = new ArrayList<Department>();
		pList.setItemList(deptList);
		pList.reloadData();
		
		getContentPane().add(pList, BorderLayout.SOUTH);
		
		popupMenu_1 = new JPopupMenu();
		
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu_1.add(mntmUpdate);
		
		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu_1.add(mntmDelete);
		
		
		pContent.clearComponent(1);
	}
	
	private void reloadList() {
		deptList = dao.selectDepartmentbyAll();
		pList.setItemList(deptList);
		pList.reloadData();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmUpdate) {
			actionPerformedMenuItem(e);
		}

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
		Department updateDept = pContent.getItem();
		int res = dao.updateDepartment(updateDept);
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department insertDept = pContent.getItem();
		int res = dao.insertDepartment(insertDept);
	}
	
	private void clearContent() {
		pContent.clearComponent(deptList.size() == 0 ? 1 : deptList.size() + 1);
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
	}
	
	protected void actionPerformedMenuItem(ActionEvent e) {
	}
	
	private void refreshUI(Department item, int res) {
		String message = res == 1 ? "성공" : "실패";
		JOptionPane.showMessageDialog(null, item + message);
		reloadList();
		clearContent();
	}
}
