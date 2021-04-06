package com.javalec.base;

import com.javalec.function.SumEvenOdd;
import com.javalec.function.SumEvenOdd2;

public class Main {

	public static void main(String[] args) {
		
		int i=1,j=10;
		
//		SumEvenOdd sumEvenOdd=new SumEvenOdd();
//		int sum=sumEvenOdd.sumCalc(i, j);
//		
//		String chk=sumEvenOdd.evenOdd(sum);
		
		SumEvenOdd2 sumEvenOdd2=new SumEvenOdd2();
		sumEvenOdd2.sumCalc(i, j);
		sumEvenOdd2.evenOdd();
	}

}
