package com.javalec.tab;

import java.awt.EventQueue;		
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.AdminAction;
import com.javalec.admin.UpdateClothDB;
import com.javalec.admin.UpdateDocumentDB;
import com.javalec.admin.UpdateUserDB;
import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.login.Login;
import com.javalec.profile.ChangePassword;
import com.javalec.user.InsertCloth;
import com.javalec.with.AnswerQueryInsert;
import com.javalec.with.InsertNotice;
import com.javalec.with.NoticeMain;
import com.javalec.with.QueryMain;
import com.javalec.with.UpdateNotice;
import com.mysql.cj.protocol.x.Notice;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;



public class admin_tab extends JFrame{

	private JFrame frame;
	private JFrame frame1;
	private JPanel notice;
	private JPanel inquiry;
	private JPanel board;
	private JPanel closet;
	private JPanel member;
	private JPanel admin;
	private JLayeredPane layeredPane;
	private JTextField tfresult_bd;
	private JTextField tfname;
	private JTextField tfid;
	private JTextField tfemail;
	private JTextField txresult_nt;
	private JTextField tfresult_iq;
	private JTextField tfresult_cs;
	
	//--------------------------------------------
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnWrite_nt;
	private JScrollPane scrollPane;
	private JTable table_nt;
	private JTable table_iq;
	private JTable table_cs;
	private JTable table_bd;
	private JScrollPane scrollPane_mb;
	private JTextField textField;
	private JButton btnLoad_mb;
	private JComboBox cbtitle_mb;
	private JRadioButton rdbtnAll;
	private JRadioButton rdbtnBlocked;
	private JRadioButton rdbtnCommon;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable Inner_Table_mb;
	private final DefaultTableModel Outer_Table_mb = new DefaultTableModel();
	//--------------------------------------------
	
	

	//탭 전환하기 (2021.04.27 김민규)
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_tab window = new admin_tab();
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
	public admin_tab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(250, 63, 925, 537);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		admin = new JPanel();
		layeredPane.add(admin, "name_10014477907462");
		admin.setLayout(null);
		
		JLabel lblprofile = new JLabel("관리자 프로필");
		lblprofile.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofile.setBounds(6, 6, 97, 26);
		admin.add(lblprofile);
		
		JLabel lblname = new JLabel("이름 :");
		lblname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname.setBounds(560, 95, 61, 16);
		admin.add(lblname);
		
		JLabel lblid = new JLabel("아이디 :");
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(560, 129, 61, 16);
		admin.add(lblid);
		
		JLabel lblemail = new JLabel("이메일 :");
		lblemail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemail.setBounds(560, 163, 61, 16);
		admin.add(lblemail);
		
		tfname = new JTextField();
		tfname.setEditable(false);
		tfname.setColumns(10);
		tfname.setBounds(632, 91, 208, 26);
		admin.add(tfname);
		tfname.setText(ShareVar.userName); // jy : 추가
		
		tfid = new JTextField();
		tfid.setEditable(false);
		tfid.setColumns(10);
		tfid.setBounds(633, 124, 207, 26);
		admin.add(tfid);
		tfid.setText(ShareVar.nowId); // jy : 추가
		
		tfemail = new JTextField();
		tfemail.setEditable(false);
		tfemail.setColumns(10);
		tfemail.setBounds(633, 158, 207, 26);
		admin.add(tfemail);
		tfemail.setText(ShareVar.userEmail);
		
		JButton btnchangepw = new JButton("비밀번호 변경");
		btnchangepw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.main(null); // jy : 추가
			}
		});
		btnchangepw.setBounds(635, 257, 117, 29);
		admin.add(btnchangepw);
		
		member = new JPanel();
		layeredPane.add(member, "name_10025409858196");
		member.setLayout(null);
		
		JLabel lblmember = new JLabel("회원관리");
		lblmember.setBounds(6, 6, 104, 36);
		member.add(lblmember);
		lblmember.setHorizontalAlignment(SwingConstants.CENTER);
		member.add(getScrollPane_mb());
		member.add(getTextField_1());
		member.add(getBtnLoad_mb_1());
		member.add(getCbtitle_mb_1());
		member.add(getRdbtnAll_1());
		member.add(getRdbtnBlocked_1());
		member.add(getRdbtnCommon_1());
		
		closet = new JPanel();
		layeredPane.add(closet, "name_10028148525053");
		closet.setLayout(null);
		
		JLabel lblcloset = new JLabel("옷장관리");
		lblcloset.setHorizontalAlignment(SwingConstants.CENTER);
		lblcloset.setBounds(6, 6, 142, 41);
		closet.add(lblcloset);
		
		JScrollPane scrollPane_cs = new JScrollPane();
		scrollPane_cs.setBounds(7, 53, 913, 479);
		closet.add(scrollPane_cs);
		
		table_cs = new JTable();
		scrollPane_cs.setViewportView(table_cs);
		
		tfresult_cs = new JTextField();
		tfresult_cs.setColumns(10);
		tfresult_cs.setBounds(519, 7, 208, 26);
		closet.add(tfresult_cs);
		
		JComboBox cbtitle_cb = new JComboBox();
		cbtitle_cb.setModel(new DefaultComboBoxModel(new String[] {"상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
		cbtitle_cb.setBounds(418, 8, 89, 27);
		closet.add(cbtitle_cb);
		
		JButton btnDelete_cs = new JButton("삭제");
		btnDelete_cs.setBounds(855, 7, 65, 29);
		closet.add(btnDelete_cs);
		
		JButton btnLoad_cs = new JButton("조회");
		btnLoad_cs.setBounds(731, 7, 65, 29);
		closet.add(btnLoad_cs);
		
		board = new JPanel();
		layeredPane.add(board, "name_10030972904756");
		board.setLayout(null);
		
		JLabel lblboard = new JLabel("게시글관리");
		lblboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblboard.setBounds(6, 6, 108, 34);
		board.add(lblboard);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 52, 913, 479);
		board.add(scrollPane_1);
		
		table_bd = new JTable();
		scrollPane_1.setViewportView(table_bd);
		
		tfresult_bd = new JTextField();
		tfresult_bd.setBounds(578, 6, 208, 26);
		board.add(tfresult_bd);
		tfresult_bd.setColumns(10);
		
		JComboBox cbtitle_bd = new JComboBox();
		cbtitle_bd.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_bd.setBounds(450, 7, 116, 27);
		board.add(cbtitle_bd);
		
		JButton btnDelete_bd = new JButton("삭제");
		btnDelete_bd.setBounds(854, 6, 65, 29);
		board.add(btnDelete_bd);
		
		JButton btnLoad_bd = new JButton("조회");
		btnLoad_bd.setBounds(790, 6, 65, 29);
		board.add(btnLoad_bd);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10033259740421");
		inquiry.setLayout(null);
		
		JLabel lblinquiry = new JLabel("문의관리");
		lblinquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblinquiry.setBounds(6, 6, 116, 31);
		inquiry.add(lblinquiry);
		
		JScrollPane scrollPane_iq = new JScrollPane();
		scrollPane_iq.setBounds(6, 49, 913, 482);
		inquiry.add(scrollPane_iq);
		
		table_iq = new JTable();
		scrollPane_iq.setViewportView(table_iq);
		
		JComboBox cbtitle_iq = new JComboBox();
		cbtitle_iq.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_iq.setBounds(366, 7, 116, 27);
		inquiry.add(cbtitle_iq);
		
		tfresult_iq = new JTextField();
		tfresult_iq.setColumns(10);
		tfresult_iq.setBounds(494, 6, 208, 26);
		inquiry.add(tfresult_iq);
		
		JButton btnLoad_iq = new JButton("조회");
		btnLoad_iq.setBounds(706, 6, 65, 29);
		inquiry.add(btnLoad_iq);
		
		JButton btnDelete_iq = new JButton("삭제");
		btnDelete_iq.setBounds(854, 6, 65, 29);
		inquiry.add(btnDelete_iq);
		
		JButton btnWrite_iq1 = new JButton("답변하기");
		btnWrite_iq1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnswerQueryInsert.main(null);
			}
		});
		btnWrite_iq1.setBounds(768, 6, 94, 29);
		inquiry.add(btnWrite_iq1);
		
		notice = new JPanel();
		layeredPane.add(notice, "name_10036677548749");
		notice.setLayout(null);
		
		JLabel lblnotice = new JLabel("공지관리");
		lblnotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblnotice.setBounds(6, 6, 107, 36);
		notice.add(lblnotice);
		
		JScrollPane scrollPane_nt = new JScrollPane();
		scrollPane_nt.setBounds(6, 54, 913, 477);
		notice.add(scrollPane_nt);
		
		table_nt = new JTable();
		scrollPane_nt.setViewportView(table_nt);
		
		JComboBox cbtitle_nt = new JComboBox();
		cbtitle_nt.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_nt.setBounds(390, 7, 116, 27);
		notice.add(cbtitle_nt);
		
		txresult_nt = new JTextField();
		txresult_nt.setColumns(10);
		txresult_nt.setBounds(518, 6, 208, 26);
		notice.add(txresult_nt);
		
		JButton btnLoad_nt = new JButton("조회");
		btnLoad_nt.setBounds(730, 6, 65, 29);
		notice.add(btnLoad_nt);
		
		JButton btnWrite_nt = new JButton("글쓰기");
		btnWrite_nt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNotice.main(null);
			}
		});
		btnWrite_nt.setBounds(794, 6, 65, 29);
		notice.add(btnWrite_nt);

		
		JButton btnDelete_nt = new JButton("삭제");
		btnDelete_nt.setBounds(854, 6, 65, 29);
		notice.add(btnDelete_nt);
		
		JButton btnAdmin = new JButton("관리자 프로필");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(admin);//탭전환
			}
		});
		btnAdmin.setBounds(52, 63, 151, 50);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnMember = new JButton("회원관리");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserDB.main(null);
				frame.dispose();
			}
		});
		btnMember.setBounds(52, 125, 151, 50);
		frame.getContentPane().add(btnMember);
		
		JButton btnCloset = new JButton("옷장관리");
		btnCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(closet);//탭전환
				UpdateClothDB.main(null);
				frame.dispose();
			}
		});
		btnCloset.setBounds(52, 187, 151, 50);
		frame.getContentPane().add(btnCloset);
		
		JButton btnBoard = new JButton("게시글관리");
		btnBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(board);//탭전환
				UpdateDocumentDB.main(null);
				frame.dispose();
			}
		});
		btnBoard.setBounds(52, 249, 151, 50);
		frame.getContentPane().add(btnBoard);
		
		JButton btnInquiry = new JButton("문의관리");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inquiry);//탭전환
				frame.dispose();
				QueryMain.main(null);
			}
		});
		btnInquiry.setBounds(52, 311, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnNotice = new JButton("공지관리");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(notice);//탭전환
				frame.dispose();
				NoticeMain.main(null);
			}
		});
		btnNotice.setBounds(52, 373, 151, 50);
		frame.getContentPane().add(btnNotice);
		
		JButton btnlogOut = new JButton("로그아웃");
		btnlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.nowId="";
				ShareVar.nowPw="";
				ShareVar.userName="";
				frame.dispose();
				Login.main(null);
			}
		});
		btnlogOut.setBounds(86, 435, 117, 29);
		frame.getContentPane().add(btnlogOut);
	}
	//-------------------------------------------- 이 부분 확인 필요
	private JButton getbtnWrite_nt() {
		if (btnWrite_nt == null) {
			btnWrite_nt = new JButton("글쓰기");
			btnWrite_nt.setBounds(794, 6, 65, 29);
		}
		return btnWrite_nt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 54, 913, 477);
			scrollPane.setViewportView(getTable_nt());
		}
		return scrollPane;
	}
	private JTable getTable_nt() {
		if (table_nt == null) {
			table_nt = new JTable();
			table_nt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_nt.setModel(Outer_Table);
		}
		return table_nt;
	//--------------------------------------------	여기까지
	}
	private JScrollPane getScrollPane_mb() {
		if (scrollPane_mb == null) {
			scrollPane_mb = new JScrollPane();
			scrollPane_mb.setBounds(12, 45, 913, 477);
			scrollPane_mb.setViewportView(getInner_Table_mb());
		}
		return scrollPane_mb;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(647, 7, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_mb_1() {
		if (btnLoad_mb == null) {
			btnLoad_mb = new JButton("조회");
			btnLoad_mb.setBounds(859, 6, 65, 29);
		}
		return btnLoad_mb;
	}
	private JComboBox getCbtitle_mb_1() {
		if (cbtitle_mb == null) {
			cbtitle_mb = new JComboBox();
			cbtitle_mb.setModel(new DefaultComboBoxModel(new String[] {"ID", "NAME", "E-MAIL"}));
			cbtitle_mb.setBounds(537, 7, 98, 27);
		}
		return cbtitle_mb;
	}
	private JRadioButton getRdbtnAll_1() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("ALL");
			buttonGroup.add(rdbtnAll);
			rdbtnAll.setSelected(true);
			rdbtnAll.setBounds(292, 9, 55, 23);
		}
		return rdbtnAll;
	}
	private JRadioButton getRdbtnBlocked_1() {
		if (rdbtnBlocked == null) {
			rdbtnBlocked = new JRadioButton("Blocked");
			buttonGroup.add(rdbtnBlocked);
			rdbtnBlocked.setBounds(359, 9, 86, 23);
		}
		return rdbtnBlocked;
	}
	private JRadioButton getRdbtnCommon_1() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("Normal");
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(446, 9, 79, 23);
		}
		return rdbtnCommon;
	}
	private JTable getInner_Table_mb() {
		if (Inner_Table_mb == null) {
			Inner_Table_mb = new JTable();
		}
		return Inner_Table_mb;
	}
	
	
	private void TableInit(){
        int i = Outer_Table_mb.getRowCount();
        
        Outer_Table_mb.addColumn("UserID");
        Outer_Table_mb.addColumn("UserName");
        Outer_Table_mb.addColumn("UserE-mail");
        Outer_Table_mb.addColumn("가입날짜");
        Outer_Table_mb.addColumn("정지날짜");
        Outer_Table_mb.addColumn("Admin");
        Outer_Table_mb.addColumn("");
        Outer_Table_mb.setColumnCount(7);

        for(int j = 0 ; j < i ; j++){
            Outer_Table_mb.removeRow(0);
        }

        Inner_Table_mb.setAutoResizeMode(Inner_Table_mb.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

	}
	private void SearchAction(String WhereCheck){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.UserList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getAdmin());
			String[] qTxt = {beanList.get(index).getUserid(), beanList.get(index).getUsername(),beanList.get(index).getUseremail(),beanList.get(index).getUseraddtime(),beanList.get(index).getUserblindtime(), temp};
			Outer_Table_mb.addRow(qTxt);
		}

	}
	private void OpenAction() {
		InsertNotice.main(null);

	}
	private void TableClick() {
		//선택한 번호
		int i = Inner_Table_mb.getSelectedRow();
		String tkSequence = (String)Inner_Table_mb.getValueAt(i, 0);
		
		AdminAction adminAction = new AdminAction();
		String userid = adminAction.UserBlindCheck(tkSequence);
		if (userid == null) {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateUserBlindtime(tkSequence, 1);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "차단이 해제되었습니다!");      
			          TableInit();
						ScreenPartition();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}if (userid != null) {
			int result = JOptionPane.showConfirmDialog(null, "해당 사용자를 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateUserBlindtime(tkSequence, 0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "사용자가 차단되었습니다!");
			          TableInit();
						ScreenPartition();
			          
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}
		
		

	}
	
	private void ScreenPartition() {
		String WhereCheck = "";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " where not userblindtime is null ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " where userblindtime is null ";
		}
		TableInit();
		SearchAction(WhereCheck);
	}
	private void ConditionQuery() {
		int i = cbtitle_mb.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "userid";
			break;
		case 1:
			ConditionQueryColumn = "username";
			break;
		case 2:
			ConditionQueryColumn = "useremail";
			break;
		default:
			break;
		}
		String WhereCheck = " where ";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " where not userblindtime is null and ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " where userblindtime is null and ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);

	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.UserConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getAdmin());
			String[] qTxt = {beanList.get(index).getUserid(), beanList.get(index).getUsername(), beanList.get(index).getUseremail(),beanList.get(index).getUseraddtime(),beanList.get(index).getUserblindtime(), temp};
			Outer_Table_mb.addRow(qTxt);
		}

	}
}  //-------------
