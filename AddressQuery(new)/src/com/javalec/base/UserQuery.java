package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class UserQuery {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField tfSeqno;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JTextField tfTelno;
	private JLabel lblNewLabel_2;
	private JTextField tfAddress;
	private JLabel lblNewLabel_3;
	private JTextField tfEmail;
	private JLabel lblNewLabel_4;
	private JTextField tfRelation;
	private JLabel lblNewLabel_5;
	private JTable Inner_Table;

	// Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/userinfo?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	
	// Table 환경 정의 // **** 테이블은 별도 환경정의 필요
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JTextField tfCount;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbModify;
	private JRadioButton rdbInsert;
	private JRadioButton rdbDelete;
	private JRadioButton rdbSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnOK;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery window = new UserQuery();
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
	public UserQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
				btnOK.setVisible(false);
			}
		});
		frame.setTitle("주소록 검색");
		frame.setBounds(100, 100, 450, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfCount());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getRdbModify());
		frame.getContentPane().add(getRdbInsert());
		frame.getContentPane().add(getRdbDelete());
		frame.getContentPane().add(getRdbSearch());
		frame.getContentPane().add(getBtnOK());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(16, 44, 78, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(106, 43, 201, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(310, 43, 117, 29);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(11, 82, 416, 169);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seq No :");
			lblNewLabel.setBounds(16, 269, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(89, 264, 61, 26);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(89, 302, 130, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(16, 307, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(89, 340, 185, 26);
		}
		return tfTelno;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호 :");
			lblNewLabel_2.setBounds(16, 345, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(89, 378, 308, 26);
		}
		return tfAddress;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주소 :");
			lblNewLabel_3.setBounds(16, 383, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(89, 416, 201, 26);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전자우편 :");
			lblNewLabel_4.setBounds(16, 421, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(89, 454, 308, 26);
		}
		return tfRelation;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("관계 : ");
			lblNewLabel_5.setBounds(16, 459, 61, 16);
		}
		return lblNewLabel_5;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); // ******* innertable 과 outertable 맞추기 
		}
		return Inner_Table;
	}
	
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
			tfCount.setBounds(328, 264, 49, 26);
			tfCount.setColumns(10);
		}
		return tfCount;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("명");
			lblNewLabel_6.setBounds(389, 269, 23, 16);
		}
		return lblNewLabel_6;
	}
	
	private JRadioButton getRdbModify() {
		if (rdbModify == null) {
			rdbModify = new JRadioButton("수정");
			rdbModify.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Editable();
					btnOK.setVisible(true);
				}
			});
			buttonGroup.add(rdbModify);
			rdbModify.setBounds(112, 14, 61, 23);
		}
		return rdbModify;
	}
	private JRadioButton getRdbInsert() {
		if (rdbInsert == null) {
			rdbInsert = new JRadioButton("입력");
			rdbInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clearColumn();
					Editable();
					btnOK.setVisible(true);
				}
			});
			buttonGroup.add(rdbInsert);
			rdbInsert.setBounds(33, 14, 61, 23);
		}
		return rdbInsert;
	}
	private JRadioButton getRdbDelete() {
		if (rdbDelete == null) {
			rdbDelete = new JRadioButton("삭제");
			rdbDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clearColumn();
					Ineditable();
					btnOK.setVisible(true);
				}
			});
			buttonGroup.add(rdbDelete);
			rdbDelete.setBounds(189, 14, 61, 23);
		}
		return rdbDelete;
	}
	private JRadioButton getRdbSearch() {
		if (rdbSearch == null) {
			rdbSearch = new JRadioButton("검색");
			rdbSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clearColumn();
					Editable();
					btnOK.setVisible(false);
				}
			});
			rdbSearch.setSelected(true);
			buttonGroup.add(rdbSearch);
			rdbSearch.setBounds(274, 14, 61, 23);
		}
		return rdbSearch;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbInsert.isSelected()==true) conditionQueryAdd();
					if(rdbModify.isSelected()==true) conditionQueryModify();
					if(rdbDelete.isSelected()==true) conditionQueryDelete();
					if(rdbSearch.isSelected()==true) conditionQuerySearch();
				}
			});
			btnOK.setBounds(315, 505, 97, 23);
		}
		return btnOK;
	}
	
	// 화면 Table 초기화
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
		
		
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
	}
		
	
	//검색
	private void searchAction() {
		String query = "select seqno, name, telno, relation from userinfo ";
		int dataCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 요즘 드라이버 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				Outer_Table.addRow(qTxt);
				dataCount++;
			}
			
			conn_mysql.close();
			tfCount.setText(Integer.toString(dataCount));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Table clicked
	private void tableClick() {
		int i = Inner_Table.getSelectedRow();
		String wkSeq = (String) Inner_Table.getValueAt(i, 0);
		
		String query = "select * from userinfo where seqno = " + wkSeq; // column 이름을 적어주는게 좋음
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				tfSeqno.setText(rs.getString(1));
				tfName.setText(rs.getString(2));
				tfTelno.setText(rs.getString(3));
				tfAddress.setText(rs.getString(4));
				tfEmail.setText(rs.getString(5));
				tfRelation.setText(rs.getString(6));
			}
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 조건 검색
	private void conditionQuery() {
		int i = cbSelection.getSelectedIndex();
		String conditionQueryColumn = "";
		
		switch(i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "address";
			break;
		case 2:
			conditionQueryColumn = "relation";
			break;
		default:
			break;
		}
		
		tableInit();
		clearColumn();
		conditionQueryAction(conditionQueryColumn);
		
		
	}
	
	//조건 검색
	private void conditionQueryAction(String columnName) {
		String query1 = "select seqno, name, telno, relation from userinfo where " + columnName;
		String query2 = " like '%" + tfSelection.getText() + "%'";
		int dataCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 요즘 드라이버 .cj 넣기
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				Outer_Table.addRow(qTxt);
				dataCount++;
			}
			
			conn_mysql.close();
			tfCount.setText(Integer.toString(dataCount));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void conditionQuerySearch() {
		
	}
	
	//정보 비우기
	private void clearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfCount.setText("");
		
	}
	
	//정보 수정
	private void conditionQueryModify() {
		try {
			int chk=insertFieldCheck();
			if(chk==0) {
				int i = Inner_Table.getSelectedRow();
				String wkSeq = (String) Inner_Table.getValueAt(i, 0);
				
				String query = "update userinfo set name=?,telno=?,address=?,email=?,relation=? where seqno=";
				
				PreparedStatement ps=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				
				ps=conn_mysql.prepareStatement(query+wkSeq);
				ps.setString(1, tfName.getText().trim());
				ps.setString(2, tfTelno.getText().trim());
				ps.setString(3, tfAddress.getText().trim());
				ps.setString(4, tfEmail.getText().trim());
				ps.setString(5, tfRelation.getText().trim());
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 수정됐습니다!");
				
				tableInit();
				searchAction();
				clearColumn();
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//정보 삭제
	private void conditionQueryDelete() {
		int i = Inner_Table.getSelectedRow();
		String wkSeq = (String) Inner_Table.getValueAt(i, 0);
		
		String query = "delete from userinfo where seqno = " + wkSeq; // column 이름을 적어주는게 좋음
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			stmt_mysql.executeUpdate(query);
			
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 삭제됐습니다!");
		
		tableInit();
		searchAction();
		clearColumn();
	}
	
	//정보 입력
	private void conditionQueryAdd() {
		try {	
			int chk=insertFieldCheck();
			if(chk==0) {
				PreparedStatement ps=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				
				String query="insert into userinfo(name,telno,address,email,relation) values (?,?,?,?,?)";
				ps=conn_mysql.prepareStatement(query);
				ps.setString(1, tfName.getText().trim());
				ps.setString(2, tfTelno.getText().trim());
				ps.setString(3, tfAddress.getText().trim());
				ps.setString(4, tfEmail.getText().trim());
				ps.setString(5, tfRelation.getText().trim());
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 입력됐습니다!");
				
				tableInit();
				searchAction();
				clearColumn();
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//빈칸 확인
	private int insertFieldCheck(){
		int i=0;
		String message="";
		if(tfName.getText().equals("")) {
			i++;
			message="이름을";
			tfName.requestFocus();
		}
		if(tfTelno.getText().equals("")) {
			i++;
			message="전화번호를";
			tfTelno.requestFocus();
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
	
	//편집 가능
	private void Editable() {
		tfName.setEditable(true);
		tfTelno.setEditable(true);
		tfAddress.setEditable(true);
		tfEmail.setEditable(true);
		tfRelation.setEditable(true);
	}
	
	//편집 불가능
	private void Ineditable() {
		tfName.setEditable(false);
		tfTelno.setEditable(false);
		tfAddress.setEditable(false);
		tfEmail.setEditable(false);
		tfRelation.setEditable(false);
	}
} // ----
