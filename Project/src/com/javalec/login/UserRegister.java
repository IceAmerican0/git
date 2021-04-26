package com.javalec.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.javalec.base.MainMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserRegister {

	private JFrame frame;
	private JTextField tfId;
	private JButton btnTestid;
	private JTextField tfEmail;
	private JButton btnTestid_1;
	private JTextField tfPw1;
	private JTextField tfPw2;
	private JLabel lbCheckpw;
	private JTextField tfName;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister window = new UserRegister();
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
	public UserRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 488, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getBtnTestid());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getBtnTestid_1());
		frame.getContentPane().add(getTextField_1_1());
		frame.getContentPane().add(getTfPw2());
		frame.getContentPane().add(getLbCheckpw());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblNewLabel_1());
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setText("아이디를 입력해주세요");
			tfId.setBounds(85, 103, 220, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JButton getBtnTestid() {
		if (btnTestid == null) {
			btnTestid = new JButton("중복확인");
			btnTestid.setBounds(317, 103, 117, 29);
		}
		return btnTestid;
	}
	private JTextField getTextField_1() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setText("이메일 주소를 입력해주세요");
			tfEmail.setColumns(10);
			tfEmail.setBounds(85, 141, 220, 26);
		}
		return tfEmail;
	}
	private JButton getBtnTestid_1() {
		if (btnTestid_1 == null) {
			btnTestid_1 = new JButton("중복확인");
			btnTestid_1.setBounds(317, 141, 117, 29);
		}
		return btnTestid_1;
	}
	private JTextField getTextField_1_1() {
		if (tfPw1 == null) {
			tfPw1 = new JTextField();
			tfPw1.setText("비밀번호를 입력해주세요");
			tfPw1.setColumns(10);
			tfPw1.setBounds(85, 179, 349, 26);
		}
		return tfPw1;
	}
	private JTextField getTfPw2() {
		if (tfPw2 == null) {
			tfPw2 = new JTextField();
			tfPw2.setText("비밀번호를 한번 더 입력해주세요");
			tfPw2.setColumns(10);
			tfPw2.setBounds(85, 217, 349, 26);
		}
		return tfPw2;
	}
	private JLabel getLbCheckpw() {
		if (lbCheckpw == null) {
			lbCheckpw = new JLabel("비밀번호가 일치하지 않습니다!");
			lbCheckpw.setBounds(95, 244, 276, 16);
		}
		return lbCheckpw;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setText("이름을 입력해 주세요");
			tfName.setBounds(85, 272, 173, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("회원가입");
			btnNewButton.setBounds(111, 323, 117, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("가입취소");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu main=new MainMenu();
					frame.dispose();
					main.main(null);
				}
			});
			btnNewButton_1.setBounds(254, 323, 117, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원가입");
			lblNewLabel_1.setBounds(216, 49, 89, 42);
		}
		return lblNewLabel_1;
	}
}
