package com.upon.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {
	
	String username;
	String password;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;
	
	public DBHelper(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public boolean select() {
		Boolean b = DButils.logging(username, password);
		
		return b;
	}
	
	public boolean insert() {
		Boolean b = DButils.insert(username, password);
		return b;
	}

}
