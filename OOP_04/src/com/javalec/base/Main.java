package com.javalec.base;

import java.util.Scanner;

import com.javaelc.function.Add;
import com.javaelc.function.Division;
import com.javaelc.function.Minus;
import com.javaelc.function.Multiple;


public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("정수 2개를 입력하세요 : ");
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		
		Add add=new Add();
		Minus minus=new Minus();
		Multiple multiple=new Multiple();
		Division division=new Division();
		
		
		System.out.println("합 : "+add.Addresult(num1,num2)+"\n차 : "+minus.Minresult(num1,num2)+
							"\n곱 : "+multiple.Mulresult(num1,num2)+"\n나눔 : "+division.Divresult(num1,num2));
	}

}
