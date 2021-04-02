package com.javalec.base;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		//if
		Scanner scanner=new Scanner(System.in);
		int inputNumber=0;
		String result="";
		
		//처리
		System.out.print("성적 입력하세요! ");
		inputNumber=scanner.nextInt();
		
		/*if(inputNumber%2==0) {//짝
			result="짝수";
		}else {//홀
			result="홀수";
		}*/
		
		switch(inputNumber%2) {
		case 0: 
			result="짝수";
			break;
		case 1: 
			result="홀수";
			break;
		default: break;
		}
		
		
		//결과
		System.out.println("입력하신 숫자 "+inputNumber+"는 "+result+"입니다.");
	}

}
