import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class UserQuery {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel;
	private JTextField tfSeqno;
	private JTextField tfCount;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfName;
	private JLabel lblNewLabel_3;
	private JTextField tfTelno;
	private JLabel lblNewLabel_4;
	private JTextField tfAddress;
	private JLabel lblNewLabel_5;
	private JTextField tfEmail;
	private JLabel lblNewLabel_6;
	private JTextField tfRelation;
	
	private final String url_mysql="jdbc:mysql://127.0.0.1/userinfo?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql="root";
	private final String pw_mysql="qwer1234";
	
	private final DefaultTableModel Outer_Table=new DefaultTableModel();
	private JButton btnOK;
	private JRadioButton rdbInsert;
	private JRadioButton rdbModify;
	private JRadioButton rdbDelete;
	private JRadioButton rdbSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
			}
		});
		frame.setBounds(100, 100, 450, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getTfCount());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getRdbInsert());
		frame.getContentPane().add(getRdbModify());
		frame.getContentPane().add(getRdbDelete());
		frame.getContentPane().add(getRdbSearch());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(27, 47, 65, 25);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(104, 49, 196, 21);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnQuery.setBounds(312, 48, 97, 23);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 88, 383, 125);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
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
		}
		return Inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sequence No : ");
			lblNewLabel.setBounds(27, 243, 97, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(136, 240, 65, 21);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setColumns(10);
			tfCount.setBounds(344, 223, 44, 21);
		}
		return tfCount;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("명");
			lblNewLabel_1.setBounds(392, 226, 30, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 : ");
			lblNewLabel_2.setBounds(27, 286, 97, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(136, 283, 109, 21);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호 : ");
			lblNewLabel_3.setBounds(27, 331, 97, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(136, 328, 164, 21);
		}
		return tfTelno;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("주소 : ");
			lblNewLabel_4.setBounds(27, 373, 97, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(136, 370, 273, 21);
		}
		return tfAddress;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("전자우편 : ");
			lblNewLabel_5.setBounds(27, 415, 97, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(136, 412, 214, 21);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("관계 : ");
			lblNewLabel_6.setBounds(27, 459, 97, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(136, 456, 273, 21);
		}
		return tfRelation;
	}
	
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4);
		
		int i=Outer_Table.getRowCount();
		for(int j=0;j<i;j++) Outer_Table.removeRow(0);
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		int vColIndex=0;
		TableColumn col=Inner_Table.getColumnModel().getColumn(vColIndex);
		int width=30;
		col.setPreferredWidth(width);
		
		vColIndex=1;
		col=Inner_Table.getColumnModel().getColumn(vColIndex);
		width=100;
		col.setPreferredWidth(width);
		
		vColIndex=2;
		col=Inner_Table.getColumnModel().getColumn(vColIndex);
		width=100;
		col.setPreferredWidth(width);
		
		vColIndex=3;
		col=Inner_Table.getColumnModel().getColumn(vColIndex);
		width=200;
		col.setPreferredWidth(width);
	}
	
	private void searchAction() {
		String query="select seqno,name,telno,relation from userinfo";
		int dataCount=0;
		try {	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql=conn_mysql.createStatement();
			
			ResultSet rs=stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				String[] qTxt= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				Outer_Table.addRow(qTxt);
				dataCount++;
			}
			
			
			conn_mysql.close();
			tfCount.setText(Integer.toString(dataCount));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void tableClick() {
		int i=Inner_Table.getSelectedRow();
		String wkSeq=(String) Inner_Table.getValueAt(i, 0);
		String query1="select seqno,name,telno,address,email,relation from userinfo where seqno=";
		try {	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql=conn_mysql.createStatement();
			
			ResultSet rs=stmt_mysql.executeQuery(query1+wkSeq);
			
			while(rs.next()) {
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
	
	private void conditionQuery() {
		int i=cbSelection.getSelectedIndex();
		String conditionQueryColumn="";
		
		switch(i) {
		case 0:
			conditionQueryColumn="name";
			break;
		case 1:
			conditionQueryColumn="address";
			break;
		case 2:
			conditionQueryColumn="relation";
			break;
		default:
			break;
		}
		
		tableInit();
		clearColumn();
		conditionQueryAction(conditionQueryColumn);
		
	}
	
	private void clearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfCount.setText("");
	}
	
	private void conditionQueryAction(String columnName) {
		String query1="select seqno,name,telno,relation from userinfo where"+columnName;
		String query2="like '%'"+tfSelection.getText()+"'%'";
		int dataCount=0;
		try {	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql=conn_mysql.createStatement();
			
			ResultSet rs=stmt_mysql.executeQuery(query1+query2);
			
			while(rs.next()) {
				String[] qTxt= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				Outer_Table.addRow(qTxt);
				dataCount++;
			}
			
			
			conn_mysql.close();
			tfCount.setText(Integer.toString(dataCount));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbInsert.isSelected()==true) 
				}
			});
			btnOK.setBounds(325, 498, 97, 23);
		}
		return btnOK;
	}
	
	private void conditionQueryDelete() {
			try {	
				
				PreparedStatement ps=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql=DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	
				int i=Inner_Table.getSelectedRow();
				String wkSeq=(String) Inner_Table.getValueAt(i, 0);
				
				String query="delete from userinfo where seqno=";
				ps=conn_mysql.prepareStatement(query+wkSeq);
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 삭제됐습니다!");
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			tableInit();
			searchAction();
			clearColumn();
	}
	private JRadioButton getRdbInsert() {
		if (rdbInsert == null) {
			rdbInsert = new JRadioButton("입력");
			buttonGroup.add(rdbInsert);
			rdbInsert.setBounds(46, 18, 59, 23);
		}
		return rdbInsert;
	}
	private JRadioButton getRdbModify() {
		if (rdbModify == null) {
			rdbModify = new JRadioButton("수정");
			buttonGroup.add(rdbModify);
			rdbModify.setBounds(136, 18, 59, 23);
		}
		return rdbModify;
	}
	private JRadioButton getRdbDelete() {
		if (rdbDelete == null) {
			rdbDelete = new JRadioButton("삭제");
			buttonGroup.add(rdbDelete);
			rdbDelete.setBounds(224, 18, 59, 23);
		}
		return rdbDelete;
	}
	private JRadioButton getRdbSearch() {
		if (rdbSearch == null) {
			rdbSearch = new JRadioButton("검색");
			buttonGroup.add(rdbSearch);
			rdbSearch.setSelected(true);
			rdbSearch.setBounds(305, 18, 59, 23);
		}
		return rdbSearch;
	}
}
