package com.akshayapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banktransac","root","root");
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("update ");
			while (res.next()) {
				String Name = res.getString(1);
				int Acc_no = res.getInt(2);
				int balance = res.getInt(3);
				System.out.println("Name:"+Name+",Acc_no:"+Acc_no+",balance:"+balance);
			}
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
