package com.javalec.base;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
//		
//		ArrayList<String> arrayList=new ArrayList<String>();
//		System.out.println("<<<< ArrayList >>>>");
//		arrayList.add("str1");
//		arrayList.add("str2");
//		arrayList.add("str3");
//		arrayList.add("str4");
//		
//		System.out.println(arrayList);
//		
//		String str1=arrayList.get(3);
//		System.out.println("Index 3 : "+str1);
//		
//		arrayList.set(1, "str2222");
//		System.out.println(arrayList);
//		
//		int size=arrayList.size();
//		System.out.println("Size : "+size);
//		
//		arrayList.remove(1);
//		System.out.println(arrayList);
//		arrayList.remove("str4");
//		System.out.println(arrayList);
//		
//		arrayList.clear();
//		System.out.println(arrayList);
		
		LinkedList<String> linkedList=new LinkedList<String>();
		System.out.println(">>>> Linked List <<<<");
		linkedList.add("str1");
		linkedList.add("str2");
		linkedList.add("str3");
		linkedList.add("str4");
		
		System.out.println(linkedList);
		
		String str1=linkedList.get(3);
		System.out.println("Index 3 : "+str1);
		
		linkedList.set(1, "str2222");
		System.out.println(linkedList);
		
		int size=linkedList.size();
		System.out.println("Size : "+size);
		
		linkedList.remove(1);
		System.out.println(linkedList);
		linkedList.remove("str4");
		System.out.println(linkedList);
		
		linkedList.clear();
		System.out.println(linkedList);
	}

}
