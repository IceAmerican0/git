package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String subject[]= {"Korean","English","Mathematics","Total","Average"};
		int Korean[]=new int[subject.length];
		int English[]=new int[subject.length];
		int Mathematics[]=new int[subject.length];
		int Total[]=new int[subject.length];
		int Average[]=new int[subject.length];
		
		int sum=0;
		int avg=0;
		
		for(int i=0;i<3;i++) {
			System.out.println(subject[i]+"의 성적을 입력 : ");
			for(int j=0;j<4;j++) {
				if(i==0) {
					System.out.print("No"+(j+1)+"의 성적은 : ");
					Korean[j]=scanner.nextInt();
				}else if(i==1) {
					System.out.print("No"+(j+1)+"의 성적은 : ");
					English[j]=scanner.nextInt();
				}else{
					System.out.print("No"+(j+1)+"의 성적은 : ");
					Mathematics[j]=scanner.nextInt();
				}
				Total[j]=Korean[j]+English[j]+Mathematics[j];
				Average[j]=Total[j]/(i+1);
			}
		}
		
		for(int i=0;i<subject.length;i++) System.out.print("\t\t"+subject[i]);
		System.out.print("\n");
		
		for(int j=0;j<4;j++) {
			System.out.print("No"+(j+1)+"\t\t"+Korean[j]+"\t\t\t"+English[j]+"\t\t\t\t"+
											Mathematics[j]+"\t\t\t"+	Total[j]+"\t\t\t"+Average[j]+"\n");
		}
		
	}

}
