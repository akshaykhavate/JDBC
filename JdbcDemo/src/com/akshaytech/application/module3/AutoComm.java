package com.akshaytech.application.module3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutoComm {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banktransac?user=root&password=root");
			con.setAutoCommit(false);//transaction begins
			PreparedStatement pstmt = con.prepareStatement("update customer set balance=? where id=?");
			
			pstmt.setDouble(1, 30000);
			pstmt.setInt(2	, 1);

			pstmt.executeUpdate();
			
			pstmt.setDouble(1, 50000);
			pstmt.setInt(2	, 2);

			pstmt.executeUpdate();
			
			con.commit();//transaction ends
			System.out.println("Successfull!!!!!!!!!!!!!!!!!!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null){
				try {
					con.close();
					con=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
