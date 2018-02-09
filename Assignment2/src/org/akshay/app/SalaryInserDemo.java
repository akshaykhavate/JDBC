package org.akshay.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SalaryInserDemo {
	
	public static void main(String[] args) {
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
			Statement stmt = con.createStatement();
			boolean res = stmt.execute("insert into empdetails values('Akshay','kjf12',9980040686,28000)");
			boolean res1 = stmt.execute("insert into empdetails values('Akshaykk','kjf13',8867966586,24999)");
			if (!(res && res1)) {
				System.out.println("User inserted successfully");
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
