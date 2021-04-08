package com.javalec.base;

public class Shop1 extends StoreHQ{
	
	public Shop1() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 4500원");
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5000원");
	}
	
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 판매하지 않습니다.");
	}
	
	public void print() {
		System.out.println("Shop1----------------------");
		orderKim();
		orderBu();
		orderBi();
		orderSoon();
		orderKong();
	}
	
}
