package com.javalec.base;

public class ChildMenu extends ParentsMenu {

	public ChildMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public void makeBeefChung() {
		System.out.println("소고기 청국");
	}
	
	public void makeHotDoen() {
		System.out.println("얼큰 된장");
	}
	
	@Override
	public void makeChung() {
		// TODO Auto-generated method stub
		System.out.println("냄새 없는 청국장");
	}
	
}
