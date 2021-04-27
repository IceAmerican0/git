package com.javalec.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.base.MainMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField tfId;
	private JButton btnLogin;
	private JButton btnFindid;
	private JButton btnFindpw;
	private JButton btnNewuser;
	
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
    private final String id_mysql = "root";
    private final String pw_mysql = "qwer1234";
    private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnFindid());
		frame.getContentPane().add(getBtnFindpw());
		frame.getContentPane().add(getBtnNewuser());
		frame.getContentPane().add(getPassword());
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(88, 65, 145, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginMethod();
				}				
			});
			btnLogin.setBounds(245, 65, 104, 64);
		}
		return btnLogin;
	}
	private JButton getBtnFindid() {
		if (btnFindid == null) {
			btnFindid = new JButton("아이디찾기");
			btnFindid.setBounds(156, 141, 92, 29);
		}
		return btnFindid;
	}
	private JButton getBtnFindpw() {
		if (btnFindpw == null) {
			btnFindpw = new JButton("비밀번호찾기");
			btnFindpw.setBounds(255, 141, 121, 29);
		}
		return btnFindpw;
	}
	private JButton getBtnNewuser() {
		if (btnNewuser == null) {
			btnNewuser = new JButton("회원가입");
			btnNewuser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					UserRegister.main(null);
				}
			});
			btnNewuser.setBounds(56, 141, 88, 29);
		}
		return btnNewuser;
	}
	
	private JPasswordField getPassword() {
		if (Password == null) {
			Password = new JPasswordField();
			Password.setBounds(88, 108, 145, 21);
		}
		return Password;
	}
	
	private void LoginMethod() {
		String id=tfId.getText().trim();
		String pw=new String(Password.getPassword());
		
		LoginAction loginAction=new LoginAction(id,pw);
		int msg=loginAction.Login();
		
		
		if(msg==1) {
			frame.dispose();
			MainMenu.main(null);
		}else JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 입력해주세요!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
		
	}
}
