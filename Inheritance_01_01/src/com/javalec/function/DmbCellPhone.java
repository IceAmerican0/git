package com.javalec.function;

public class DmbCellPhone extends Cellphone {

	public int channel;
	
	
	public DmbCellPhone() {
		// TODO Auto-generated constructor stub
	}
	
	public DmbCellPhone(String model,String color,int channel) {
		super();
		this.model=model;
		this.color=color;
		this.channel=channel;
	}
	
	public void turnOnDmb() {
		System.out.println("채널 "+channel+"번 DMB방송 수신을 시작합니다.");
	}
	
	public void changeChannelDmb(int channel) {
		this.channel=channel;
		System.out.println("채널 "+channel+"번으로 바꿉니다.");
	}
	
	public void turnOffDmb() {
		System.out.println("DMB방송 수신을 멈춥니다.");
	}
	
}
