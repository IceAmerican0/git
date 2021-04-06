package com.javalec.function;

public class SumEvenOdd2 {
	int num=0;
	
	public SumEvenOdd2() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void sumCalc(int num1,int num2) {
		int sum=0;
		for(int i=num1;i<=num2;i++) sum+=i;
		num=sum;
		System.out.println(num1+" ~ "+num2+" 의 합은 "+sum+"입니다.");
	}
	
	public void evenOdd() {
		String analyze="";
		if(num%2==0) analyze="짝수";
		else analyze="홀수";
		System.out.println(analyze+"입니다.");
	}
}
