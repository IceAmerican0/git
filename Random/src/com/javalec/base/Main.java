package com.javalec.base;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String show[]={"가위","바위","보"};
		
		while(true) {
			System.out.print("가위 : 1 , 바위 : 2, 보 : 3, 종료 : 4 = > ");
			int inputNum=scanner.nextInt();
			
			if(inputNum>3||inputNum<1) {
				if(inputNum==4) {
					System.out.println("끝");
					break;
				}
				System.out.println("다시 입력하세요!" );
				continue;	
			} else {
				Random random=new Random();
				int i=random.nextInt(3)+1;
				System.out.println("나 : "+show[inputNum-1]+"\n컴퓨터 : "+show[i-1]);
				
				if(inputNum==1) {
					if(i==3) System.out.println("이김!");
					else if(i==2) System.out.println("짐!");
					else System.out.println("비김!");
				}else if(inputNum==2) {
					if(i==1) System.out.println("이김!");
					else if(i==3) System.out.println("짐!");
					else System.out.println("비김!");
				}else {
					if(i==2) System.out.println("이김!");
					else if(i==1) System.out.println("짐!");
					else System.out.println("비김!");
				}
			}
			System.out.println("==============");
		}
	}
}
