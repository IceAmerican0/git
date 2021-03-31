package com.javalec.base;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("성적을 입력하세요 : ");
		
		int score=scanner.nextInt();
		String grade="";
		
		if(score>100||score<0) grade="올바르지 않은 ";
		else {
			switch(score/10) { 
				case 10:
				case 9: 
					grade="A";
					break;
				case 8:
					grade="B";
					break;
				case 7:
					grade="C";
					break;
				case 6:
					grade="D";
					break;
				default:
					grade="F";
					break;
			}
			
		}
		System.out.println(grade+"학점입니다.");
	}

}
