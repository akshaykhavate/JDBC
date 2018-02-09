package org.akshay.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SalaryFetchDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("Select * from empdetails where Esalary>25000");
			/*if (!res) {
				System.out.println("user requested data is fetched successfully");
			}*/
		//	System.out.println(res);
			while(res.next()){
				String Ename = res.getString(1);
				String Eid = res.getString(2);
				String Econtact = res.getString(3);
				int Esalary = res.getInt(4);
				System.out.println("Ename:"+Ename+",Eid:"+Eid+", Econtact:"+Econtact+", Esalary:"+Esalary);
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
