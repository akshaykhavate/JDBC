package com.akshaytech.application.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrestmtDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo?user=root&password=root";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("insert into user values(?,?,?,?)");
			
			pstmt.setString(1, "Dhoni");
			pstmt.setString(3, "Dhoni@gmail.com");
			pstmt.setInt(2, 21);
			pstmt.setString(4, "12367890");
			
			pstmt.addBatch();
			
			pstmt.setString(1, "Sachin");
			pstmt.setString(3, "sachin@gmail.com");
			pstmt.setInt(2, 22);
			pstmt.setString(4, "1290");
			
			pstmt.addBatch();
			
			int[] a = pstmt.executeBatch();

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
