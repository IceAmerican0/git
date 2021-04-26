package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class LoginAction {
	private final String url_mysql=ShareVar.url_mysql;	
	private final String id_mysql=ShareVar.id_mysql;	
	private final String pw_mysql=ShareVar.pw_mysql;
	
	String id;
	String pw;
	String name;
	
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	public LoginAction(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public int Login() {
		String sql="select userpw from user";
		String userid="";
		String userpw="";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(sql);
	          while(rs.next()) {
	        	  userpw=rs.getString(1);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		
		if(userpw.equals(pw)) return 1;
		if(!userpw.equals(pw)) return 2;
		else return 3;
	}
}
