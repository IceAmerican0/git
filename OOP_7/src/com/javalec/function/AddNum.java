package com.javalec.function;

public class AddNum {
	int num;
	
	public AddNum(int num) {
		super();
		this.num=num;
	}
	
	public void Addout() {
		int sum=0;
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		
		System.out.println("Sum of digits = "+sum);
			
	}
}
