package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI01 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JLabel lblNewLabel_1;
	private JLabel Calculation;
	private JButton btnAdd;
	private JLabel lblNewLabel_1_2;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivision;
	private JTextField tfNum1_Clone;
	private JTextField tfNum2_Clone;
	private JLabel lblNewLabel_1_1_1;
	private JTextField result;
	Calculator calculator=new Calculator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI01 window = new GUI01();
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
	public GUI01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getCalculation());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getBtnMinus());
		frame.getContentPane().add(getBtnMultiply());
		frame.getContentPane().add(getBtnDivision());
		frame.getContentPane().add(getTfNum1_Clone());
		frame.getContentPane().add(getTfNum2_Clone());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getResult());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("사칙연산");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(46, 35, 71, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(46, 66, 71, 21);
		}
		return tfNum2;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("1 : ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 38, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getCalculation() {
		if (Calculation == null) {
			Calculation = new JLabel("+");
			Calculation.setHorizontalAlignment(SwingConstants.CENTER);
			Calculation.setBounds(125, 148, 57, 15);
		}
		return Calculation;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addSum();
				}
			});
			btnAdd.setBounds(184, 34, 47, 23);
		}
		return btnAdd;
	}
	
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("2 : ");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(0, 66, 57, 15);
		}
		return lblNewLabel_1_2;
	}
	private JButton getBtnMinus() {
		if (btnMinus == null) {
			btnMinus = new JButton("-");
			btnMinus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Minus();
				}
			});
			btnMinus.setBounds(239, 34, 47, 23);
		}
		return btnMinus;
	}
	private JButton getBtnMultiply() {
		if (btnMultiply == null) {
			btnMultiply = new JButton("*");
			btnMultiply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Multiply();
				}
			});
			btnMultiply.setBounds(298, 34, 47, 23);
		}
		return btnMultiply;
	}
	private JButton getBtnDivision() {
		if (btnDivision == null) {
			btnDivision = new JButton("/");
			btnDivision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Division();
				}
			});
			btnDivision.setBounds(356, 34, 47, 23);
		}
		return btnDivision;
	}
	private JTextField getTfNum1_Clone() {
		if (tfNum1_Clone == null) {
			tfNum1_Clone = new JTextField();
			tfNum1_Clone.setEditable(false);
			tfNum1_Clone.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1_Clone.setColumns(10);
			tfNum1_Clone.setBounds(63, 145, 71, 21);
		}
		return tfNum1_Clone;
	}
	private JTextField getTfNum2_Clone() {
		if (tfNum2_Clone == null) {
			tfNum2_Clone = new JTextField();
			tfNum2_Clone.setEditable(false);
			tfNum2_Clone.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2_Clone.setColumns(10);
			tfNum2_Clone.setBounds(171, 145, 71, 21);
		}
		return tfNum2_Clone;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("=");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setBounds(239, 148, 57, 15);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getResult() {
		if (result == null) {
			result = new JTextField();
			result.setEditable(false);
			result.setHorizontalAlignment(SwingConstants.TRAILING);
			result.setColumns(10);
			result.setBounds(289, 145, 71, 21);
		}
		return result;
	}

	private void addSum() {
		Calculation.setText("+");
		tfNum1_Clone.setText(tfNum1.getText());
		tfNum2_Clone.setText(tfNum2.getText());
		
		result.setText(Integer.toString(
				calculator.Add(Integer.parseInt(tfNum1.getText()),Integer.parseInt(tfNum2.getText()))));
	}
	
	private void Minus() {
		Calculation.setText("-");
		tfNum1_Clone.setText(tfNum1.getText());
		tfNum2_Clone.setText(tfNum2.getText());
		
		result.setText(Integer.toString(
				calculator.Minus(Integer.parseInt(tfNum1.getText()),Integer.parseInt(tfNum2.getText()))));
	}
	
	private void Multiply() {
		Calculation.setText("*");
		tfNum1_Clone.setText(tfNum1.getText());
		tfNum2_Clone.setText(tfNum2.getText());
		
		result.setText(Integer.toString(
				calculator.Multiply(Integer.parseInt(tfNum1.getText()),Integer.parseInt(tfNum2.getText()))));
	}
	
	private void Division() {
		Calculation.setText("/");
		tfNum1_Clone.setText(tfNum1.getText());
		tfNum2_Clone.setText(tfNum2.getText());
		Double wkNum1=Double.parseDouble(tfNum1.getText());
		Double wkNum2=Double.parseDouble(tfNum2.getText());
		if(wkNum1==0||wkNum2==0) {
			JOptionPane.showMessageDialog(null, "0을 제외하고 입력해주세요!");
			tfNum1_Clone.setText("");
			tfNum2_Clone.setText("");
			result.setText("");
		}else {
			result.setText(String.format("%.2f", (calculator.Division(wkNum1,wkNum2))));
		}
		
		
	}
	
}
