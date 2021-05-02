package com.javalec.user;

import java.awt.BorderLayout;		
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserPresetSelectedCloth {

	private JFrame frame;
	private JTextField tfClothname;
	private JLabel lblTitle;
	private JButton btnOK;
	private JTextField tfAddtime;
	private JLabel lbladdtime;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	int answerIndex;
	private JLabel ClothData;
	private JButton btnModify;
	private JLabel lbltype;
	private JTextField tfClothtype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPresetSelectedCloth window = new UserPresetSelectedCloth();
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
	public UserPresetSelectedCloth() {
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
				SearchAction();
			}
		});
		frame.setBounds(100, 100, 460, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfClothname());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfAddtime());
		frame.getContentPane().add(getLbladdtime());
		frame.getContentPane().add(getClothData());
		frame.getContentPane().add(getBtnModify());
		frame.getContentPane().add(getLbltype());
		frame.getContentPane().add(getTfClothtype());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfClothname() {
		if (tfClothname == null) {
			tfClothname = new JTextField();
			tfClothname.setEditable(false);
			tfClothname.setColumns(10);
			tfClothname.setBounds(40, 10, 215, 26);
		}
		return tfClothname;
	}
	private JLabel getClothData() {
		if (ClothData == null) {
			ClothData = new JLabel((Icon) null);
			ClothData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothData.setBounds(6, 103, 426, 298);
		}
		return ClothData;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("이름 :");
			lblTitle.setBounds(6, 15, 47, 16);
		}
		return lblTitle;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					ImgChk();
				}
			});
			btnOK.setBounds(127, 428, 81, 29);
		}
		return btnOK;
	}
	public JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setBounds(40, 70, 178, 26);
			tfAddtime.setColumns(10);
		}
		return tfAddtime;
	}
	private JLabel getLbladdtime() {
		if (lbladdtime == null) {
			lbladdtime = new JLabel("add :");
			lbladdtime.setBounds(6, 70, 61, 16);
		}
		return lbladdtime;
	}
	
	private void SearchAction() {
		UserAction userAction=new UserAction();
        Bean bean = userAction.ClothDBTableClick();
        
        tfClothname.setText(bean.getClothname());
        tfAddtime.setText(bean.getAddtime());
        tfClothtype.setText(bean.getClothtype());
		
		
//---------------------------------------combo값 지정하기--------------------------------------
//        comboBox.getSelectedItem(bean.getTitle());
    
//----------------------------------------파일 불러오기--------------------------------------
        String filePath = Integer.toString(ShareVar.filename);
		ClothData.setIcon(new ImageIcon(filePath));
		ClothData.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filePath);
		file.delete();

//----------------------------------------파일 불러오기--------------------------------------
        
        
//----------------------------------------댓글 불러오기--------------------------------------
		
	}
	
	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("뒤로가기");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnModify.setBounds(220, 428, 117, 29);
		}
		return btnModify;
	}
	
	private JLabel getLbltype() {
		if (lbltype == null) {
			lbltype = new JLabel("type :");
			lbltype.setHorizontalAlignment(SwingConstants.CENTER);
			lbltype.setBounds(0, 41, 47, 16);
		}
		return lbltype;
	}
	private JTextField getTfClothtype() {
		if (tfClothtype == null) {
			tfClothtype = new JTextField();
			tfClothtype.setEditable(false);
			tfClothtype.setColumns(10);
			tfClothtype.setBounds(40, 39, 117, 26);
		}
		return tfClothtype;
	}
	
	private void ImgChk() {
		if(ShareVar.cloth.equals("모자")) ShareVar.HatImg=ShareVar.filename;
		if(ShareVar.cloth.equals("아우터")) ShareVar.OuterImg=ShareVar.filename;
		if(ShareVar.cloth.equals("상의")) ShareVar.TopImg=ShareVar.filename;			
		if(ShareVar.cloth.equals("하의")) ShareVar.BottomImg=ShareVar.filename;
		if(ShareVar.cloth.equals("가방")) ShareVar.BagImg=ShareVar.filename;
		if(ShareVar.cloth.equals("신발")) ShareVar.ShoesImg=ShareVar.filename;
		if(ShareVar.cloth.equals("원피스")) ShareVar.OnepieceImg=ShareVar.filename;
	}
	
}
