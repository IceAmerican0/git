package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int account[]=new int[5];
		int userNum=0, price=0;
		
		while(true) {
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 현황");
			System.out.println("4. 종료");
			
			System.out.print("번호를 선택하세요 ! ");
			int num=scanner.nextInt();
			
			if(num>4||num<1) {
				System.out.println("1~4 사이의 번호를 입력해주세요! ");
				continue;
			}
			
			if(num!=3&&num!=4) { 
				System.out.print("고객번호 : ");
				userNum=scanner.nextInt();
				if(userNum>5||userNum<1) {
					System.out.println("1~5사이의 번호를 입력해주세요! ");
					continue;
				}

				System.out.print("금액 : ");
				price=scanner.nextInt();
				if(price<0) {
					System.out.println("올바른 금액을 입력해주세요! ");
					continue;
				}
			}
			
			
			if(num==1) {
				account[userNum-1]+=price;
				System.out.println("입금 결과 : 고객번호 : "+num+" 잔액 : "+account[userNum-1]);
				System.out.println("----------------------------------");
			}else if(num==2) 	{
				if(account[userNum-1]-price<0) System.out.println("잔액이 부족합니다!");
				else {
					account[userNum-1]-=price;
					System.out.println("입금 결과 : 고객번호 : "+num+" 잔액 : "+account[userNum-1]);
					System.out.println("----------------------------------");
				}
			}else if(num==3) {
				System.out.println("\t\t고객명\t 잔액");
				System.out.println("----------------------------------");
				for(int i=0;i<5;i++) System.out.println("\t\t"+(i+1)+"\t\t"+account[i]);
			}else if(num==4) {
				System.out.println(">>>> Thank you <<<<");
				break;
			}
			
		}

	}

}
