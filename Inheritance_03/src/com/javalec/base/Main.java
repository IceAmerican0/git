package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		StoreHQ store=new StoreHQ();
		StoreHQ shop1=new Shop1();
		StoreHQ shop2=new Shop2();
		StoreHQ shop3=new Shop3();
		
		StoreHQ[] store1= {store,shop1,shop2,shop3};
		
		for(int i=0;i<store1.length;i++) 	store1[i].print();
		
		System.out.println("----------------------");
	}

}
