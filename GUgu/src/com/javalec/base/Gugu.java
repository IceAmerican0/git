package com.javalec.base;

import java.util.Scanner;

public class Gugu {

	public static void main(String[] args) {
		System.out.print("Enter an integer(0 ~ 9) : ");
		
		Scanner scanner=new Scanner(System.in);
		int sum=0;
		
		for(int num=scanner.nextInt();num!=0;num/=10) sum+=num%10;
		System.out.println("Sum of digits = "+sum);

	}
	
	

}
