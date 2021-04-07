package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.AddNum;	

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Enter an integer(0~9) : ");
		int num=scanner.nextInt();
		
		AddNum add=new AddNum(num);
		
		add.Addout();
	}

}
