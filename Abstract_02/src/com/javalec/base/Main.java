package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		LunchMenu child1=new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		LunchMenu child2=new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		LunchMenu child3=new Child3(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		
		System.out.println("Child1의 식대 : "+child1.calc());
		System.out.println("Child2의 식대 : "+child2.calc());
		System.out.println("Child3의 식대 : "+child3.calc());
		
	}

}
