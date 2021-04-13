//package com.javalec.base;
//
//import java.util.ArrayList;
//
//public class addAction extends GUI05 {
//	ArrayList<String> arrayList1=new ArrayList<String>();
//	ArrayList<String> arrayList2=new ArrayList<String>();
//	
//	
//	public addAction() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public void addString(String num) {
//		tfResult.setText(tfResult.getText()+num);
//		arrayList1.add(num);
//	}
//	
//	public void addSequence() {
//		for(int i=0;i<arrayList1.size();i++) arrayList2.add(arrayList1.get(i));
//		arrayList1.clear();
//		tfResult.setText(tfResult.getText()+" + ");
//	}
//	
//	public void addResult() {
//		String first="";
//		String second="";
//		for(int i=0;i<arrayList2.size();i++) first+=arrayList2.get(i);
//		for(int i=0;i<arrayList1.size();i++) second+=arrayList1.get(i);
//		String sum=Integer.toString(Integer.parseInt(first)+Integer.parseInt(second));
//		tfResult.setText(first+" + "+second+" = "+sum);
//	}
//	
//	public void clear() {
//		tfResult.setText("");
//		arrayList1.clear();
//		arrayList2.clear();
//	}
//
//
//	
//	
//}
