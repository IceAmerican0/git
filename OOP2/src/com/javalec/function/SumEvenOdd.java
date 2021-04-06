package com.javalec.function;

public class SumEvenOdd {
	
	
	
	public SumEvenOdd() {
		
	}
	
	public int sumCalc(int num1,int num2) {
		int sum=0;
		for(int i=num1;i<=num2;i++) sum+=i;
		return sum;
	}
	
	public String evenOdd(int sum) {
		String analyze="";
		if(sum%2==0) analyze="짝수";
		else analyze="홀수";
		return analyze;
	}
}
