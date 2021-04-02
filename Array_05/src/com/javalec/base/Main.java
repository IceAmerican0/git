package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		long multiple=1;
		
		for(int i=0;i<=10;i++) {
			System.out.println("10^"+String.format("%3d", i)+"="+String.format("%15d", multiple));
			multiple*=10;
		}

	}

}
