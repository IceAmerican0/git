package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		String str1="abcdefg";
		String str2="IJNOLK";
		String str3="trug";
		String str4="htovg";
		
//		System.out.println(str1.concat(str2));
//		System.out.println(str1.substring(3));
//		System.out.println(str1.substring(3,5));
//		System.out.println(str1.toUpperCase());
//		System.out.println(str1.charAt(3));
		
		for(int i=0;i<str1.length();i++) System.out.println(str1.charAt(i));
		
		System.out.println(str1.indexOf('c'));
		System.out.println(str1.equals(str3));
		System.out.println(str4.trim());
		System.out.println(str1.replace('a', 'Z'));
		System.out.println(str1.replaceAll("abc","ZZZZZ"));
	}

}
