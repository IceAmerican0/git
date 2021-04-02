package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int[] inputValue=new int[3];
		int sum=0;
		double avg=0.0;
		
		System.out.print("숫자를 3개 입력하세요 : ");
		
		for(int i=0;i<inputValue.length;i++) {
			inputValue[i]=scanner.nextInt();
			sum+=inputValue[i];
			avg=(double)sum/inputValue.length;
		}
		
		System.out.println("숫자의 합 : "+sum+"\n숫자의 평균 : "+String.format("%.3f",avg));

	}

}
