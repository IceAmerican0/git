package com.javalec.base;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		int sum=0;
		
		for(int i=1;i<=100;i++) if(i%2==0) arrayList.add(i);
		
		for(int i=0;i<arrayList.size();i++) sum+=arrayList.get(i);
		
		System.out.println("짝수의 합 : "+sum);
			
	}

}
