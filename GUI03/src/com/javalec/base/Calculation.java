package com.javalec.base;

import javax.swing.JOptionPane;

public class Calculation extends GUI03 {
	
	int num1;
	int num2;
	
	public Calculation() {
		// TODO Auto-generated constructor stub
	}
	
	public Calculation(int num1,int num2) {
		super();
		this.num1=num1;
		this.num2=num2;
	}
	
	public String Add() {
		String result=(Integer.toString(num1)+" + "+Integer.toString(num2) +" = "+Integer.toString(num1+num2));
		return result;
	}
	
	public String Minus() {
		String result=(Integer.toString(num1)+" - "+Integer.toString(num2) +" = "+Integer.toString(num1-num2));
		return result;
	}
	
	public String Multiply() {
		String result=(Integer.toString(num1)+" * "+Integer.toString(num2) +" = "+Integer.toString(num1*num2));
		return result;
	}
	
	public String Division() {
		String result="";
		try {
			result=(Integer.toString(num1)+" / "+Integer.toString(num2) +" = "+String.format("%.3f",(double)num1/num2));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"0 대신 다른값을 넣어주세요!");
		}
		return result;
	}
}
