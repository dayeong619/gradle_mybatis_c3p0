package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Sale;
import kr.or.yi.gradle_mybatis_c3p0.service.OutputService;

public class OutputFrame extends JFrame {

	private JPanel contentPane;
	private boolean isSale;
	private OutputService service;
	private RankListPanel panel;


	/**
	 * Create the frame.
	 */
	public OutputFrame(boolean isSale) {
		service = new OutputService();
		this.isSale = isSale;
		setTitle(isSale ? "판매금액 순위" : "마진액 순위");
		initComponents();
	}


	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		List<Sale> list;
		try {
			list = service.outputOrder(isSale);
			
			panel = new RankListPanel();
			panel.setList(list);
			panel.loadDatas();
			contentPane.add(panel, BorderLayout.CENTER);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel pTitle = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pTitle.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(pTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel(isSale ? "판매금액 순위" : "마진액 순위");
		pTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
	}

}