package com.akshayapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDetails {

	public static void main(String[] args)  {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankTransac","root","root");
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into Cutomer values('akshay',1234656789,10000)");
			stmt.addBatch("insert into Cutomer values('akash',1234,8000)");
			stmt.addBatch("insert into Cutomer values('John',12789,4000)");
			stmt.execute("insert into Transaction values('akshay',5000)"  );
			stmt.executeBatch();
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
