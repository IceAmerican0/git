package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String[] name= {"James","Cathy","Kenny","Martin","Crystal"};
		int[] height = new int[name.length];
		int sum=0;
		double avg=0.0;
		String tallName="";
		String smallName="";
		int tall=0;
		int small=0;
		
		for(int i=0;i<name.length;i++) {
			System.out.print(name[i]+"의 신장을 입력하세요! ");
			height[i]=scanner.nextInt();
			
			if(tall<height[i]) {
				tall=height[i];
				tallName=name[i];
			}
			
			if(small==0||small>height[i]) {
				small=height[i];
				smallName=name[i];
			}
			
			sum+=height[i];
			avg=(double)sum/name.length;
		}
		
		
		System.out.println("평균 신장은 : "+avg+"\n가장 큰 학생은 "+tallName +"이고 그 학생의 키는 "+tall+
										"\n가장 작은 학생은 "+smallName+"이고 그 학생의 키는 "+small);
	}

}
