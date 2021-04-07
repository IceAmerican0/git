package com.javalec.base;

import com.javalec.function.AddNum;

public class Main {

	public static void main(String[] args) {
		int num1=10,num2=20;
		AddNum addNum=new AddNum();
		int resultNum=addNum.addAction(num1,num2);
		System.out.println(resultNum);
		
		addNum.addPrint(num1, num2);
		
		AddNum addNum2=new AddNum(num1,num2);
		int resultNum2=addNum2.addAction2(num1,num2);
		System.out.println(resultNum2);
		
		addNum.num1=num1;
		addNum.num2=num2;
		int resultNum3=num1+num2;
		System.out.println(resultNum3);
	}

}
