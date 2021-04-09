package com.javalec.base;

public class BPhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		System.out.println("A phone : Possible");
	}

	@Override
	public void telMethod() {
		System.out.println("A phone : 3G");

	}

	@Override
	public void tvRemoteController() {
		System.out.println("A phone : Not Applied");

	}

}
