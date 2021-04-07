package com.javalec.base;

public class Variable_01 {
	public static void main(String[] args) {
		
		int startNum=30, endNum=40;
		
		System.out.println(startNum+"과 "+endNum+"의 덧셈 결과는 "+(startNum+endNum)+" 입니다");
		System.out.println(startNum+"과 "+endNum+"의 뺄셈 결과는 "+(startNum-endNum)+" 입니다");
		System.out.println(startNum+"과 "+endNum+"의 곱셈 결과는 "+(startNum*endNum)+" 입니다");
		System.out.println(startNum+"과 "+endNum+"의 나눗셈 중 몫은 "+(startNum%endNum)+" 입니다");
		System.out.println(startNum+"과 "+endNum+"의 나눗셈 결과는 "+(startNum/endNum)+" 입니다");
		System.out.println(startNum+"과 "+endNum+"의 덧셈결과와 뺄셈 결과의 곱 "+((startNum+endNum))*(startNum-endNum)+" 입니다");
	}
}
