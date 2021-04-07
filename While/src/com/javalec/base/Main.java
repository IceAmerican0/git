package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("몇개의 숫자를 더할까요? : ");
		
		Scanner scanner=new Scanner(System.in);
		int inputValue=scanner.nextInt();
		int tot=0;
		
		//while문
		while(inputValue>0) {
			int sum=scanner.nextInt();
			tot+=sum;
			inputValue--;
		}
		
		//for문
		for(int i=1;i<=inputValue;i++) {
			int sum=scanner.nextInt();
			tot+=sum;
		}
		
		System.out.println("입력한 숫자의 합은 "+tot+" 입니다.");
	}

}
