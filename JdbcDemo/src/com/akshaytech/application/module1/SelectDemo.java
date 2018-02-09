package com.akshaytech.application.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from user");
			//Processing the data
			while(res.next()){
				String name = res.getString(1);
				int age = res.getInt(2);
				String mail = res.getString(3);
				String phone = res.getString(4);
				System.out.println("Name:"+name+",Age:"+age+",Email:"+mail+",Phone:"+phone);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
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
