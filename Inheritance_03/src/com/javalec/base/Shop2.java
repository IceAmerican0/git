package com.javalec.base;

public class Shop2 extends StoreHQ {
	
	public Shop2() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 5000원");
	}
	
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 4000원");
	}
	
	@Override
	public void orderKong() {
		System.out.println("공기밥 : 무료입니다.");
	}
	
	public void print() {
		System.out.println("Shop2----------------------");
		orderKim();
		orderBu();
		orderBi();
		orderSoon();
		orderKong();
	}
	
}
