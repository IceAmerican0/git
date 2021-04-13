package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI05 {

	private JFrame frame;
	private JTextField tfResult;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn6;
	private JButton btn5;
	private JButton btn4;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn0;
	private JButton btnEqual;
	private JButton btnAdd;
//	addAction addAction=new addAction();
	private JButton btnC;
	ArrayList<String> arrayList1=new ArrayList<String>();
	ArrayList<String> arrayList2=new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI05 window = new GUI05();
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
	public GUI05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getBtn7());
		frame.getContentPane().add(getBtn8());
		frame.getContentPane().add(getBtn9());
		frame.getContentPane().add(getBtn6());
		frame.getContentPane().add(getBtn5());
		frame.getContentPane().add(getBtn4());
		frame.getContentPane().add(getBtn1());
		frame.getContentPane().add(getBtn2());
		frame.getContentPane().add(getBtn3());
		frame.getContentPane().add(getBtn0());
		frame.getContentPane().add(getBtnEqual());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnC());
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setBounds(12, 10, 410, 46);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("7");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("7");
				}
			});
			btn7.setBounds(39, 81, 66, 51);
		}
		return btn7;
	}
	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("8");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("8");
				}
			});
			btn8.setBounds(117, 81, 66, 51);
		}
		return btn8;
	}
	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton("9");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("9");
				}
			});
			btn9.setBounds(195, 81, 66, 51);
		}
		return btn9;
	}
	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("6");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("6");
				}
			});
			btn6.setBounds(195, 142, 66, 51);
		}
		return btn6;
	}
	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("5");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("5");
				}
			});
			btn5.setBounds(117, 142, 66, 51);
		}
		return btn5;
	}
	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("4");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("4");
				}
			});
			btn4.setBounds(39, 142, 66, 51);
		}
		return btn4;
	}
	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("1");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("1");
				}
			});
			btn1.setBounds(39, 203, 66, 51);
		}
		return btn1;
	}
	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("2");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("2");
				}
			});
			btn2.setBounds(117, 203, 66, 51);
		}
		return btn2;
	}
	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("3");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("3");
				}
			});
			btn3.setBounds(195, 203, 66, 51);
		}
		return btn3;
	}
	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("0");
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addString("0");
				}
			});
			btn0.setBounds(39, 264, 66, 51);
		}
		return btn0;
	}
	private JButton getBtnEqual() {
		if (btnEqual == null) {
			btnEqual = new JButton("=");
			btnEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addResult();
				}
			});
			btnEqual.setBounds(117, 264, 66, 51);
		}
		return btnEqual;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addSequence();
				}
			});
			btnAdd.setBounds(195, 264, 66, 51);
		}
		return btnAdd;
	}
	
	
	private JButton getBtnC() {
		if (btnC == null) {
			btnC = new JButton("C");
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnC.setBounds(274, 81, 66, 51);
		}
		return btnC;
	}
	
	public void addString(String num) {
		tfResult.setText(tfResult.getText()+num);
		arrayList1.add(num);
	}
	
	public void addSequence() {
		for(int i=0;i<arrayList1.size();i++) arrayList2.add(arrayList1.get(i));
		arrayList1.clear();
		tfResult.setText(tfResult.getText()+" + ");
	}
	
	public void addResult() {
		String first="";
		String second="";
		for(int i=0;i<arrayList2.size();i++) first+=arrayList2.get(i);
		for(int i=0;i<arrayList1.size();i++) second+=arrayList1.get(i);
		String sum=Integer.toString(Integer.parseInt(first)+Integer.parseInt(second));
		tfResult.setText(first+" + "+second+" = "+sum);
	}
	
	public void clear() {
		tfResult.setText("");
		arrayList1.clear();
		arrayList2.clear();
	}
	
}
