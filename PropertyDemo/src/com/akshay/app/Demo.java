package com.akshay.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
		Connection con = null;
		
	try {
		Properties prop = new Properties();
		FileReader fr = new FileReader("src/com/akshay/app/util/mysql.properties");
		prop.load(fr);
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", prop);
		
		CallableStatement stmt = con.prepareCall("{call insertR(?,?,?,?)}");
		stmt.setString(1, "raju");
		stmt.setInt(2, 35);
		stmt.setString(3, "raju@live.com");
		stmt.setString(4, "1234567890");
		
		int a = stmt.executeUpdate();
		System.out.println(a);
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if(con!=null){
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}
}
