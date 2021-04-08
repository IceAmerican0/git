package com.javalec.base;

public class SecondSon {

	
	
	public SecondSon() {
		// TODO Auto-generated constructor stub
	}
	
	public void takeChoco() {
		MaMaBag.choco=MaMaBag.choco-1;
		if(MaMaBag.choco<0) {
			System.out.println("둘째는 초코파이 먹고 싶어요!");
		}else {
			System.out.println("둘째는 맛있게 먹었어요!");
		}
	}
	
}
