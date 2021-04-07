package com.javalec.function;

public class Gugu {
	int num;
	
	public Gugu(int num) {
		super();
		this.num=num;
	}
	
	public void Guguout() {
		for(int j=1;j<10;j++) 
			System.out.println(num+" X "+(j%2==0?"*":j)+" = "+num*j);
	}
}
