package com.javalec.base;

public class Shop3 extends StoreHQ {
	
	public Shop3() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 6000원");
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 7000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 7000원");
	}
	
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 6000원");
	}
	
	public void print() {
		System.out.println("Shop3----------------------");
		orderKim();
		orderBu();
		orderBi();
		orderSoon();
		orderKong();
	}
	
}
