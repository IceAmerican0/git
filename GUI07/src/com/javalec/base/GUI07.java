package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GUI07 {

	private JFrame frmMain;
	private JButton btnOk;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField inputId;
	private JPasswordField inputPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI07 window = new GUI07();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.setBounds(100, 100, 450, 203);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		frmMain.getContentPane().add(getBtnOk());
		frmMain.getContentPane().add(getLblNewLabel());
		frmMain.getContentPane().add(getLblPassword());
		frmMain.getContentPane().add(getInputId());
		frmMain.getContentPane().add(getInputPassword());
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Help help=new Help();
					String password=new String(inputPassword.getPassword());
					
					if(inputId.getText().equals("abc")&&password.equals("1234")) help.setVisible(true);
					else JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 확인해주세요!");
				}
			});
			btnOk.setBounds(288, 86, 97, 23);
		}
		return btnOk;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(58, 57, 48, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(38, 90, 68, 15);
		}
		return lblPassword;
	}
	private JTextField getInputId() {
		if (inputId == null) {
			inputId = new JTextField();
			inputId.setBounds(135, 54, 116, 21);
			inputId.setColumns(10);
		}
		return inputId;
	}
	private JPasswordField getInputPassword() {
		if (inputPassword == null) {
			inputPassword = new JPasswordField();
			inputPassword.setBounds(135, 87, 116, 21);
		}
		return inputPassword;
	}
}
