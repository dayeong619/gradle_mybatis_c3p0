package kr.or.yi.gradle_mybatis_c3p0.main;

import java.awt.EventQueue;

import kr.or.yi.gradle_mybatis_c3p0.ui.CoffeeManagementFrame;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeManagementFrame frame = new CoffeeManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
