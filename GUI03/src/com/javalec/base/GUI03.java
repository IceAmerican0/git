package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.awt.event.InputMethodEvent;

public class GUI03 {

	private JFrame frmCheckboxradiobutton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField num1;
	private JTextField num2;
	private JLabel lbResult1;
	private JLabel lbResult2;
	private JLabel lbResult3;
	private JLabel lbResult4;
	private JCheckBox chkAdd;
	private JCheckBox chkMinus;
	private JCheckBox chkMultiply;
	private JCheckBox chkDivision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI03 window = new GUI03();
					window.frmCheckboxradiobutton.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckboxradiobutton = new JFrame();
		frmCheckboxradiobutton.setTitle("CheckBox/RadioButton");
		frmCheckboxradiobutton.setBounds(100, 100, 450, 300);
		frmCheckboxradiobutton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckboxradiobutton.getContentPane().setLayout(null);
		frmCheckboxradiobutton.getContentPane().add(getNum1());
		frmCheckboxradiobutton.getContentPane().add(getNum2());
		frmCheckboxradiobutton.getContentPane().add(getLbResult1());
		frmCheckboxradiobutton.getContentPane().add(getLbResult2());
		frmCheckboxradiobutton.getContentPane().add(getLbResult3());
		frmCheckboxradiobutton.getContentPane().add(getLbResult4());
		frmCheckboxradiobutton.getContentPane().add(getChkAdd());
		frmCheckboxradiobutton.getContentPane().add(getChkMinus());
		frmCheckboxradiobutton.getContentPane().add(getChkMultiply());
		frmCheckboxradiobutton.getContentPane().add(getChkDivision());
	}
	
	
	private JTextField getNum1() {
		if (num1 == null) {
			num1 = new JTextField();
			num1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			num1.setBounds(22, 30, 130, 26);
			num1.setColumns(10);
		}
		return num1;
	}
	private JTextField getNum2() {
		if (num2 == null) {
			num2 = new JTextField();
			num2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			num2.setColumns(10);
			num2.setBounds(22, 76, 130, 26);
		}
		return num2;
	}
	private JLabel getLbResult1() {
		if (lbResult1 == null) {
			lbResult1 = new JLabel("");
			lbResult1.setHorizontalAlignment(SwingConstants.CENTER);
			lbResult1.setBounds(29, 147, 348, 16);
		}
		return lbResult1;
	}
	
	
	private JLabel getLbResult2() {
		if (lbResult2 == null) {
			lbResult2 = new JLabel("");
			lbResult2.setHorizontalAlignment(SwingConstants.CENTER);
			lbResult2.setBounds(29, 174, 348, 16);
		}
		return lbResult2;
	}
	private JLabel getLbResult3() {
		if (lbResult3 == null) {
			lbResult3 = new JLabel("");
			lbResult3.setHorizontalAlignment(SwingConstants.CENTER);
			lbResult3.setBounds(29, 201, 348, 16);
		}
		return lbResult3;
	}
	private JLabel getLbResult4() {
		if (lbResult4 == null) {
			lbResult4 = new JLabel("");
			lbResult4.setHorizontalAlignment(SwingConstants.CENTER);
			lbResult4.setBounds(29, 228, 348, 16);
		}
		return lbResult4;
	}
	private JCheckBox getChkAdd() {
		if (chkAdd == null) {
			chkAdd = new JCheckBox("Add");
			chkAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			chkAdd.setSelected(true);
			chkAdd.setBounds(249, 6, 128, 23);
		}
		return chkAdd;
	}
	private JCheckBox getChkMinus() {
		if (chkMinus == null) {
			chkMinus = new JCheckBox("Minus");
			chkMinus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			chkMinus.setBounds(249, 41, 128, 23);
		}
		return chkMinus;
	}
	private JCheckBox getChkMultiply() {
		if (chkMultiply == null) {
			chkMultiply = new JCheckBox("Multiply");
			chkMultiply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			chkMultiply.setBounds(249, 77, 128, 23);
		}
		return chkMultiply;
	}
	private JCheckBox getChkDivision() {
		if (chkDivision == null) {
			chkDivision = new JCheckBox("Division");
			chkDivision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			chkDivision.setBounds(249, 112, 128, 23);
		}
		return chkDivision;
	}
	
	private void broadCheck() {
		ArrayList<String> calculate=new ArrayList<String>();
		int Num1=Integer.parseInt(num1.getText());
		int Num2=Integer.parseInt(num2.getText());
		Calculation calculation=new Calculation(Num1,Num2);
		
		lbResult1.setText("");
		lbResult2.setText("");
		lbResult3.setText("");
		lbResult4.setText("");
		
		
		if(chkAdd.isSelected()==true) calculate.add(calculation.Add());
		if(chkMinus.isSelected()==true) calculate.add(calculation.Minus());
		if(chkMultiply.isSelected()==true) calculate.add(calculation.Multiply());
		if(chkDivision.isSelected()==true) calculate.add(calculation.Division());
		
		for(int i=0;i<calculate.size();i++) {
			switch(i) {
				case 0: lbResult1.setText(calculate.get(i));
					break;
				case 1: lbResult2.setText(calculate.get(i));
					break;
				case 2: lbResult3.setText(calculate.get(i));
					break;
				case 3: lbResult4.setText(calculate.get(i));
					break;
			}
		}
		calculate.clear();
	}
}
