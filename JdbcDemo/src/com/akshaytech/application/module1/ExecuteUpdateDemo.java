package com.akshaytech.application.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdateDemo {

	public static void main(String[] args) {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate("delete from demo.user where name='Bengaluru'");
				System.out.println("result:"+res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
