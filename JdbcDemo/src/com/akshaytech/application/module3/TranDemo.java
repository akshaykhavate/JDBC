package com.akshaytech.application.module3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TranDemo {
	public void transac2(){
		SingleTonCon single = SingleTonCon.getObject();
		Connection con = single.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update customer set balance=? where id=?");
			
			pstmt.setDouble(1, 6000);
			pstmt.setInt(2	, 3);
		
			pstmt.executeUpdate();
			//con.commit();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
