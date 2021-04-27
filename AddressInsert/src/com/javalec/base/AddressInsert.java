package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddressInsert {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JButton btnOk;
	
	private final String url_mysql="jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql="root";
	private final String pw_mysql="qwer1234";
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfTel;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert window = new AddressInsert();
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
	public AddressInsert() {
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
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getBtnOk());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfTel());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfRelation());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uBA85 : ");
			lblNewLabel.setBounds(21, 25, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(90, 22, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int chk=insertFieldCheck();
					if(chk==0) insertAction();
				}
			});
			btnOk.setBounds(325, 228, 97, 23);
		}
		return btnOk;
	}
	
	private void insertAction() {
		try {	
			
				PreparedStatement ps=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql=conn_mysql.createStatement();
				
				String query="insert into userinfo(name,telno,address,email,relation) values (?,?,?,?,?)";
				ps=conn_mysql.prepareStatement(query);
				ps.setString(1, tfName.getText().trim());
				ps.setString(2, tfTel.getText().trim());
				ps.setString(3, tfAddress.getText().trim());
				ps.setString(4, tfEmail.getText().trim());
				ps.setString(5, tfRelation.getText().trim());
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 입력됐습니다!");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638 : ");
			lblNewLabel_1.setBounds(21, 62, 70, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC8FC\uC18C : ");
			lblNewLabel_2.setBounds(21, 97, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC804\uC790\uC6B0\uD3B8 : ");
			lblNewLabel_3.setBounds(21, 133, 70, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uAD00\uACC4 : ");
			lblNewLabel_4.setBounds(21, 171, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(90, 59, 175, 21);
		}
		return tfTel;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(90, 94, 314, 21);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(90, 130, 175, 21);
		}
		return tfEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(90, 168, 314, 21);
		}
		return tfRelation;
	}
	
	private int insertFieldCheck(){
		int i=0;
		String message="";
		if(tfName.getText().equals("")) {
			i++;
			message="이름을";
			tfName.requestFocus();
		}
		if(tfTel.getText().equals("")) {
			i++;
			message="전화번호를";
			tfTel.requestFocus();
		}
		if(tfAddress.getText().equals("")) {
			i++;
			message="주소를";
			tfAddress.requestFocus();
		}
		if(tfEmail.getText().equals("")) {
			i++;
			message="전자우편을";
			tfEmail.requestFocus();
		}
		if(tfRelation.getText().equals("")) {
			i++;
			message="관계를";
			tfRelation.requestFocus();
		}
		if(i!=0)JOptionPane.showMessageDialog(null, message+" 입력해주세요");
		return i;
	}
}
