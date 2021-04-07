package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//for문 한번
		
		/*int dan=2;
	
		for(int i=1;i<=9;i++) {
			System.out.print(dan+" X "+i+" = "+(i*dan)+"\t\t");
			
			if(i%3==0) {
				System.out.println("\n");
				dan++;
				i=0;
			}
			
			if(dan==10) break;
		}*/
		
		//이중 for문
		System.out.print("무슨 단? : ");
		
		Scanner scanner=new Scanner(System.in);
		int dan=scanner.nextInt();
		int sum=0;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) System.out.print(dan+" * "+(sum+j)+" = "+(dan*(sum+j))+"\t");
			sum+=3;
			System.out.print("\n");
		}
		
	}

}
