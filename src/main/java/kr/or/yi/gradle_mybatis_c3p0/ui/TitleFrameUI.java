package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.ui.content.PanelTitle;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.TitleList;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class TitleFrameUI extends JFrame implements ActionListener {
	private TitleDao dao;
	private JButton btnAdd;
	private PanelTitle pContent;
	private List<Title> titleList;
	private TitleList pList;
	private JButton btnCancel;
	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;

	
	public TitleFrameUI() {
		dao = new TitleDaoImpl();
		titleList = dao.selectTitlebyAll();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책관리");
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = new PanelTitle();
		clearContent();
		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = new TitleList("직책 목록");	
		reloadList(pList);
		
		getContentPane().add(pList, BorderLayout.SOUTH);
		
		popupMenu = new JPopupMenu();
		pList.add(popupMenu, BorderLayout.NORTH);
		
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);
		
		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		
		pList.setPopupMenu(popupMenu);
	}

	private void reloadList(TitleList pList) {
		titleList = dao.selectTitlebyAll();
		pList.setItemList(titleList);
		pList.reloadData();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDelete) {
			actionPerformedMntmDelete(e);
		}
		if (e.getSource() == mntmUpdate) {
			actionPerformedMntmUpdate(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("추가")) {//추가 버튼이라면
				actionPerformedBtnAdd(e);
			}
			if(e.getActionCommand().equals("수정")) {//수정 버튼이라면
				actionPerformedBtnupdate(e);

			}
			
		}
	}
	private void actionPerformedBtnupdate(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "수정 버튼 클릭했네!");
		Title updateTitle = pContent.getItem();
		int res = dao.updateTitle(updateTitle);
		refreshUI(updateTitle, res);
		btnAdd.setText("추가");
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Title inserTitle = pContent.getItem();
		//JOptionPane.showMessageDialog(null, inserTitle);
		int res = dao.insertTitle(inserTitle);
		refreshUI(inserTitle, res);
	}

	private void clearContent() {
		pContent.clearComponent(titleList.size()==0?1:titleList.size()+1);
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearContent();
	}
	protected void actionPerformedMntmUpdate(ActionEvent e) {
		Title updateTitle = pList.getSelectedItem();
		pContent.setItem(updateTitle);
		btnAdd.setText("수정");
		
	}
	protected void actionPerformedMntmDelete(ActionEvent e) {
		Title delTitle = pList.getSelectedItem();	
		int res = dao.deleteTitle(delTitle);
		refreshUI(delTitle, res);
	}

	private void refreshUI(Title item, int res) {
		String message = res==1?"성공":"실패";
		JOptionPane.showMessageDialog(null, item + message);
		reloadList(pList);
		clearContent();
	}
}















