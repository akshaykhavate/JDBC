package com.akshaytech.application.module3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SingleTonCon {
	private static final SingleTonCon single;
	private Connection con = null;
	static{
		single = new SingleTonCon();

	}
	private SingleTonCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banktransac","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static SingleTonCon getObject(){
		return single;
	}
	public Connection getConnection(){
		return con;
	}
	//To close the connection object before the garbage collector
	@Override
	protected void finalize() throws Throwable {
		//System.out.println("In Finally");
		if(con!=null)
		con.close();
		con=null;
	}
}
