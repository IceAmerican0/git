package com.javalec.base;



public class Main {

	public static void main(String[] args) {
		int sum=0;
		
		for(int i=1;i<=10;i++) sum+=i;
		if(sum%2==0) System.out.println("합은 "+sum+" 짝수");
		else System.out.println("합은 "+sum+" 홀수");
		
	}

}
