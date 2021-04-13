package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI04 {

	private JFrame frmPasswordfield;
	private JLabel lblNewLabel;
	private JPasswordField pfInput;
	private JButton btnOK;
	private JTextField tfMessage;
	private JLabel lblNewLabel_1;
	private JTextField idInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI04 window = new GUI04();
					window.frmPasswordfield.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasswordfield = new JFrame();
		frmPasswordfield.setTitle("PasswordField");
		frmPasswordfield.setBounds(100, 100, 450, 300);
		frmPasswordfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordfield.getContentPane().setLayout(null);
		frmPasswordfield.getContentPane().add(getLblNewLabel());
		frmPasswordfield.getContentPane().add(getPfInput());
		frmPasswordfield.getContentPane().add(getBtnOK());
		frmPasswordfield.getContentPane().add(getTfMessage());
		frmPasswordfield.getContentPane().add(getLblNewLabel_1());
		frmPasswordfield.getContentPane().add(getIdInput());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(66, 29, 57, 15);
		}
		return lblNewLabel;
	}
	private JPasswordField getPfInput() {
		if (pfInput == null) {
			pfInput = new JPasswordField();
			pfInput.setBounds(135, 73, 117, 21);
		}
		return pfInput;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			btnOK.setBounds(296, 72, 97, 23);
		}
		return btnOK;
	}
	private JTextField getTfMessage() {
		if (tfMessage == null) {
			tfMessage = new JTextField();
			tfMessage.setEditable(false);
			tfMessage.setBounds(47, 139, 346, 61);
			tfMessage.setColumns(10);
		}
		return tfMessage;
	}
	
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setBounds(50, 75, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getIdInput() {
		if (idInput == null) {
			idInput = new JTextField();
			idInput.setBounds(135, 26, 117, 21);
			idInput.setColumns(10);
		}
		return idInput;
	}
	
	private void checkPassword() {
		tfMessage.setText("");
		String idString=idInput.getText();
		char[] str=pfInput.getPassword();
		String passString=new String(str);
		
		if(idString.equals("abc")&&passString.equals("1234")) tfMessage.setText("id : "+idString+"password : "+passString+"입니다.");
		else tfMessage.setText("id 및 비밀번호를 확인해주세요!"); 
	}
}
