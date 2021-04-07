package com.javalec.function;

public class AddNum {
	public int num1,num2;
	
	
	public AddNum() {
		
	}
	
	
	
	public AddNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	public int addAction(int i,int j) {
		return i+j;
	}
	
	public int addAction2(int i,int j) {
		return num1+num2;
	}
	
	public void addPrint(int i,int j) {
		System.out.println(i+j);
	}
}
