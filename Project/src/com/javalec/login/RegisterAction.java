package com.javalec.login;

import com.javalec.function.ShareVar;

public class RegisterAction {
	private final String url_mysql=ShareVar.url_mysql;	
	private final String id_mysql=ShareVar.id_mysql;	
	private final String pw_mysql=ShareVar.pw_mysql;
	
	String id;
	String pw1;
	String pw2;
	String name;
	
	public RegisterAction() {
		// TODO Auto-generated constructor stub
	}

	public RegisterAction(String id, String pw1, String pw2, String name) {
		super();
		this.id = id;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.name = name;
	}
	
	public int Register() {
		String sql="";
		
		return 0;
	}
}
