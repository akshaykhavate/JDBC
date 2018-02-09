package com.akshay.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TransactionDemo {
	public void trans1(){
		Savepoint s1 =null;
		SingleTonCon single = SingleTonCon.getObject();
		Connection con =single.getConnection();

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update customer set balance=? where id=?");
			pstmt.setDouble(1, 1001);
			pstmt.setInt(2, 1);

			pstmt.executeUpdate();

			pstmt.setDouble(1, 2001);
			pstmt.setInt(2, 2);

			pstmt.executeUpdate();

			s1 = con.setSavepoint();

			pstmt.setDouble(1, 9000);
			pstmt.setInt(2, 3);

			pstmt.executeUpdate();

			s1 = con.setSavepoint();

			pstmt.setDouble(1, 8000);
			pstmt.setInt(2, 4);

			pstmt.executeUpdate();

			con.commit();
			con.setAutoCommit(true);

		} catch (SQLException e) {
			if(con!=null){
				if(s1!=null){
					try {
						con.rollback(s1);
						con.commit();
						con.setAutoCommit(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else{
					try {
						con.rollback();
						con.setAutoCommit(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
