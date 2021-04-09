package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI00 {

	private JFrame frame;
	private JLabel LblTest;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI00 window = new GUI00();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI00() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblTest());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton_2());
		frame.getContentPane().add(getBtnNewButton_3());
		frame.getContentPane().add(getBtnNewButton_4());
	}
	private JLabel getLblTest() {
		if (LblTest == null) {
			LblTest = new JLabel("Java Swing Button Test");
			LblTest.setBounds(12, 27, 176, 23);
		}
		return LblTest;
	}
	

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LblTest.setText("Button을 click 했습니다");
				}
			});
			btnNewButton.setBounds(163, 83, 107, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("1");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LblTest.setText("1");
				}
			});
			btnNewButton_1.setBounds(37, 195, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("2");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LblTest.setText("2");
				}
			});
			btnNewButton_2.setBounds(163, 195, 107, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("3");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LblTest.setText("3");
				}
			});
			btnNewButton_3.setBounds(295, 195, 97, 23);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("Clear");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LblTest.setText("");
				}
			});
			btnNewButton_4.setBounds(163, 131, 107, 23);
		}
		return btnNewButton_4;
	}
}
