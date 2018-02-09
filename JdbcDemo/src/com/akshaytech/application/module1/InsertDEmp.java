package com.akshaytech.application.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class InsertDEmp {
	public static void main(String[] args) {
		/*String URL = "jdbc:mysql://localhost:3306";
		String USER = "root"; 
		String PASS = "root";
		Connection con = null;
		String query = "insert into demo.user values('Akshay',21,'akshaykhavae@live.com',9980040686)";
		System.out.println("START");
		try{
			//load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//for creating the connection
			con = DriverManager.getConnection(URL, USER, PASS);
			// for creating the platform
			Statement st = con.createStatement();
			//for Executing the query
			st.execute(query);
			System.out.println(con);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.err.println("Driver class not found");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Connection Failed");
		}
		finally {
			try{
				if(con!=null)
					con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}*/
		System.out.println("+++++++++Start++++++++++");
		
		Connection con = null;
		String sql = "insert into demo.user values('jspiders',10,'jspiders@gmail.com',1234567890)";
		
		try {
			//load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish a connection
			con	= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			//create platform
			Statement st = con.createStatement();
			//execute the statement
			boolean res = st.execute(sql);
			if(!res)
				System.out.println("User inserted the data successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null)// to avoid nullPointerException
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("########End#########");
	}
}
