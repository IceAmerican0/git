package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		while(true) {
			System.out.print("입력할 숫자의 갯수 ? (100개 미만) : ");
			
			Scanner scanner=new Scanner(System.in);
			int num=scanner.nextInt();
			
			if(num<100) {
				System.out.println(num+"개의 숫자를 입력하세요!");
				
				int biggest=0;
				int rank=0;
				
				for(int i=0;i<num;i++) {
					int inputNum=scanner.nextInt();
					
					if(biggest<inputNum) {
						biggest=inputNum;
						rank=i+1;
					}
					
				}
				
				System.out.println("입력한 숫자중 최대값은 "+biggest+"이고 "+rank+"번째 값 입니다.");
				break;
			}else System.out.println("다시 입력하세요");
		}
	}

}
