import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI02 {

	private JFrame frame;
	private JComboBox num1;
	private JComboBox calculate;
	private JComboBox num2;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI02 window = new GUI02();
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
	public GUI02() {
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
		frame.getContentPane().add(getNum1());
		frame.getContentPane().add(getCalculate());
		frame.getContentPane().add(getNum2());
		frame.getContentPane().add(getResult());
	}
	private JComboBox getNum1() {
		if (num1 == null) {
			num1 = new JComboBox();
			num1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculation();
				}
			});
			num1.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "7", "8", "9"}));
			num1.setBounds(31, 49, 80, 27);
		}
		return num1;
	}
	private JComboBox getCalculate() {
		if (calculate == null) {
			calculate = new JComboBox();
			calculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculation();
				}
			});
			calculate.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
			calculate.setBounds(123, 49, 73, 27);
		}
		return calculate;
	}
	private JComboBox getNum2() {
		if (num2 == null) {
			num2 = new JComboBox();
			num2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculation();
				}
			});
			num2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
			num2.setBounds(208, 49, 85, 27);
		}
		return num2;
	}
	private JTextField getResult() {
		if (result == null) {
			result = new JTextField();
			result.setEditable(false);
			result.setBounds(314, 48, 130, 26);
			result.setColumns(10);
		}
		return result;
	}
	
	private  void calculation() {
		int number1=Integer.parseInt(num1.getSelectedItem().toString());
		int number2=Integer.parseInt(num2.getSelectedItem().toString());
		String calculator=calculate.getSelectedItem().toString();
		if(calculator=="+") result.setText(Integer.toString(number1+number2));
		else if(calculator=="-") result.setText(Integer.toString(number1-number2));
		else if(calculator=="*") result.setText(Integer.toString(number1*number2));
		else {
			try {
				result.setText(String.format("%.3f",(double)number1/(double)number2));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
	}
}
