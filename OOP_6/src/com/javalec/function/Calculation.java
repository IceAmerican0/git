package com.javalec.function;

public class Calculation {
	int num1;
	int num2;
	
	public Calculation(int num1,int num2) {
		super();
		this.num1=num1;
		this.num2=num2;
	}
	
	public void Addout() {
		System.out.println("덧셈 : "+(num1+num2));
	}
	
	public void Minout() {
		System.out.println("뺄셈 : "+(num1-num2));
	}
	public void Mulout() {
		System.out.println("곱셈 : "+(num1*num2));
	}
	public void Divout() {
		System.out.println("나눗셈 : "+(Double.toString((double)num1/(double)num2)));
	}
}
