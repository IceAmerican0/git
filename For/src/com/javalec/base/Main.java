package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("Input your decimal no. : ");
		
		Scanner scanner=new Scanner(System.in);
		int factorial=1;	
		int num=scanner.nextInt();
		
		for(int i=num;i>=1;i--)  factorial*=i;
		
		System.out.println(num+"'s factorial value = "+factorial);
	}

}
