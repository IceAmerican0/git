package com.javalec.community;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class WriteReply {

	private JFrame frame;
	private JButton btnOK;
	private JButton btnCancel;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteReply window = new WriteReply();
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
	public WriteReply() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("댓글 작성");
		frame.setBounds(100, 100, 450, 155);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getTextPane());
	}

	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("작성");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//-----------
					check();
				}
			});
			btnOK.setBounds(140, 92, 73, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			});
			btnCancel.setBounds(215, 92, 73, 29);
		}
		return btnCancel;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(17, 6, 412, 74);
		}
		return textPane;
	}
	private void check() {
		if (textPane.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "내용을 입력해주세요!");
		}
		if (textPane.getText().length()>=140) {
			JOptionPane.showMessageDialog(null, "140자 이하로 작성해주세요!");
		}
		else {
			//database input
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
