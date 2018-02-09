package com.akshaytech.application.module3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TransactionDemo {
	public void transac1(){
		//	Connection con = null;
		Savepoint s1 = null;
		SingleTonCon single = SingleTonCon.getObject();
		Connection con = single.getConnection();
		try {
			con.setAutoCommit(false);//Transaction Begins
			PreparedStatement pstmt = con.prepareStatement("update customer set balance=? where id=?");
			pstmt.setDouble(1, 99);
			pstmt.setInt(2	, 1);

			pstmt.executeUpdate();//Compulsory

			pstmt.setDouble(1, 39000000);
			pstmt.setInt(2	, 2);

			pstmt.executeUpdate();//Compulsory

			//s1 = con.setSavepoint();
			con.commit();
			
			pstmt.setDouble(1, 80000000);
			pstmt.setInt(2	, 3);

			pstmt.executeUpdate();//Not Compulsory

			con.commit();//Transaction ends
			con.setAutoCommit(true);
			System.out.println("Successfull");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null){
			//if(s1!=null){
				try {
					con.rollback(/*s1*/);
					//con.commit();
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}/*else{
				try {
					con.rollback();
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
}

