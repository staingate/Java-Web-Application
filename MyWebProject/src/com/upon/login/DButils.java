package com.upon.login;

import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DButils {
	
	private static final String URL;
	
	private static final String USER;
	
	private static final String PASSWORD;
	
	private static final String DRIVER;
	
	private static ResourceBundle rb;
	
	public static Connection conn = null;
	
	public static PreparedStatement state;
	
	public static ResultSet rs;
	
	static{
		rb = ResourceBundle.getBundle("dbConfig");
		URL = rb.getString("url");
		USER = rb.getString("user");
		PASSWORD = rb.getString("password");
		DRIVER = rb.getString("driver");
	}
	
	
	
	public DButils() {
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection co = null;
		try {
			Class.forName(DRIVER);
			co = DriverManager.getConnection(URL, USER, PASSWORD);
			return co;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return co;
		
	}
	
	/**
	 * 
	 * @param StuID
	 * @param StuPassword
	 * @return
	 */
	public static boolean logging(String StuID, String StuPassword) {
		conn = getConnection();
		String sql = "select * from customer where username=? and password=?";
		try {
			state = getPreparedStatement(conn, sql);
			rs = getPreResultSet(state, StuID, StuPassword);
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			connectStop();			
		}
		return false;
	}
	
	
	public static PreparedStatement getPreparedStatement(Connection con, String sql) {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			return  pst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pst;
	}
	
	
	/**
	 * 对预处理Statement进行设置并执行
	 * @param ps 接收
	 * @param objs
	 * @return
	 */
	public static ResultSet getPreResultSet(PreparedStatement ps, Object ... objs) {
		ResultSet rs = null;
		try {
			for(int i = 1; i <= objs.length; i ++) {
				ps.setObject(i, objs[i - 1]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void connectStop() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(rs != null) {
				state.close();
			}
			if(rs != null) {
				conn.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public static int update(PreparedStatement ps, Object ... objs) {
		int r = 0;
		try {
			for(int i = 1; i <= objs.length; i ++) {
				ps.setObject(i, objs[i - 1]);
			}
			r = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	public static boolean insert(String StuID, String StuPassword) {
		conn = getConnection();
		String sql = "insert into customer set username=?, password=?";
		try {
			state = getPreparedStatement(conn, sql);
			int r = update(state, StuID, StuPassword);
			if(r > 0) {
				return true;
			} else {
				return false;
			}
		} finally {
			connectStop();			
		}
	}
}
