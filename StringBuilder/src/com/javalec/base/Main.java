package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		String string=new String("abcdef");
		
		StringBuilder stringBuilder=new StringBuilder("abcdef");
		stringBuilder.append("hijklmn");
		System.out.println(stringBuilder);
		
		stringBuilder.insert(3, "zzz");
		System.out.println(stringBuilder);
		
		stringBuilder.delete(3, 6);
		System.out.println(stringBuilder);
		
		StringBuffer stringBuffer=new StringBuffer("abcdef");
		stringBuffer.append("hijklmn");
		
		stringBuffer.insert(3, "zzz");
		System.out.println(stringBuffer);
		
		stringBuffer.delete(3,6);
		System.out.println(stringBuffer);

	}

}
