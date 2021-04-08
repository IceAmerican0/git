package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		int i=10;
		int j=0;
		
		System.out.println("Add : "+(i+j));
		System.out.println("Sub : "+(i-j));
		System.out.println("Mul : "+(i*j));
		
		try {
			System.out.println("Div : "+(i/j));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
