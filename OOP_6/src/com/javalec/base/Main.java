package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.Calculation;	


public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int num1=scanner.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		int num2=scanner.nextInt();
		
		Calculation calculate=new Calculation(num1,num2);
		
		calculate.Addout();
		calculate.Minout();
		calculate.Mulout();
		calculate.Divout();
	}

}
